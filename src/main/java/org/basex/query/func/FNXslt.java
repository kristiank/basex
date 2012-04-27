package org.basex.query.func;

import static org.basex.query.QueryText.*;
import static org.basex.query.util.Err.*;
import static org.basex.util.Reflect.*;
import static org.basex.util.Token.*;

import java.io.*;
import java.lang.reflect.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import org.basex.io.*;
import org.basex.io.out.*;
import org.basex.query.*;
import org.basex.query.expr.*;
import org.basex.query.item.*;
import org.basex.query.item.Type;
import org.basex.query.item.map.*;
import org.basex.query.iter.*;
import org.basex.util.*;
import org.basex.util.hash.*;

/**
 * Project specific functions.
 *
 * @author BaseX Team 2005-12, BSD License
 * @author Christian Gruen
 */
public final class FNXslt extends StandardFunc {
  /** Element: parameters. */
  private static final QNm E_PARAM = new QNm("parameters", XSLTURI);

  /** XSLT implementations. */
  private static final String[] IMPL = {
    "", "Java", "1.0",
    "net.sf.saxon.TransformerFactoryImpl", "Saxon HE", "2.0",
    "com.saxonica.config.ProfessionalTransformerFactory", "Saxon PE", "2.0",
    "com.saxonica.config.EnterpriseTransformerFactory", "Saxon EE", "2.0"
  };
  /** Implementation offset. */
  private static final int OFFSET;

  static {
    final String fac = TransformerFactory.class.getName();
    final String impl = System.getProperty(fac);
    // system property has already been set
    if(System.getProperty(fac) != null) {
      // modify processor and version
      IMPL[1] = impl;
      IMPL[2] = "Unknown";
      OFFSET = 0;
    } else {
      // search for existing processors
      int s = IMPL.length - 3;
      while(s != 0 && find(IMPL[s]) == null) s -= 3;
      OFFSET = s;
      // set processor, or use default processor
      if(s != 0) System.setProperty(fac, IMPL[s]);
    }
  }

  /**
   * Returns details on the XSLT implementation.
   * @param name name flag
   * @return string
   */
  static String get(final boolean name) {
    return IMPL[OFFSET + (name ? 1 : 2)];
  }

  /**
   * Constructor.
   * @param ii input info
   * @param f function definition
   * @param e arguments
   */
  public FNXslt(final InputInfo ii, final Function f, final Expr... e) {
    super(ii, f, e);
  }

  @Override
  public Item item(final QueryContext ctx, final InputInfo ii) throws QueryException {
    checkCreate(ctx);
    try {
      final IO in = read(expr[0], ctx);
      final IO xsl = read(expr[1], ctx);
      final TokenObjMap<Object> map = xsltParams(2, E_PARAM, ctx);

      final byte[] result = transform(in, xsl, map);
      return new DBNode(new IOContent(result), ctx.context.prop);
    } catch(final Exception ex) {
      Util.debug(ex);
      // return cause of reflection error, or error itself
      throw IOERR.thrw(info, ex instanceof InvocationTargetException ?
          ex.getCause() : ex);
    }
  }

  /**
   * Creates serializer properties.
   * @param arg argument with parameters
   * @param root expected root element
   * @param ctx query context
   * @return serialization parameters
   * @throws QueryException query exception
   */
  private TokenObjMap<Object> xsltParams(final int arg, final QNm root,
      final QueryContext ctx) throws QueryException {

    // initialize token map
    final TokenObjMap<Object> tm = new TokenObjMap<Object>();
    // argument does not exist...
    if(arg >= expr.length) return tm;

    // empty sequence...
    final Item it = expr[arg].item(ctx, info);
    if(it == null) return tm;

    // XQuery map: convert to internal map
    if(it instanceof Map) return ((Map) it).tokenJavaMap(info);
    // no element: convert XQuery map to internal map
    if(!it.type().eq(SeqType.ELM)) throw NODFUNTYPE.thrw(info, this, it.type);

    // parse nodes
    ANode node = (ANode) it;
    if(!node.qname().eq(root)) PARWHICH.thrw(info, node.qname());

    // interpret query parameters
    final AxisIter ai = node.children();
    while((node = ai.next()) != null) {
      final QNm qn = node.qname();
      if(!eq(qn.uri(), XSLTURI)) PARWHICH.thrw(info, qn);
      tm.add(qn.local(), node.children().next());
    }
    return tm;
  }

  /**
   * Returns an input reference (possibly cached) to the specified input.
   * @param e expression to be evaluated
   * @param ctx query context
   * @return item
   * @throws QueryException query exception
   * @throws Exception exception
   */
  private IO read(final Expr e, final QueryContext ctx) throws Exception {
    final Item it = checkNoEmpty(e.item(ctx, info));
    final Type ip = it.type;
    if(ip.isNode()) return new IOContent(it.serialize().toArray());
    if(ip.isString()) return IO.get(string(it.string(info)));
    throw STRNODTYPE.thrw(info, this, ip);
  }

  @Override
  public boolean uses(final Use u) {
    return u == Use.NDT && sig == Function._UTIL_TRANSFORM || super.uses(u);
  }

  /**
   * Uses Java's XSLT implementation to perform an XSL transformation.
   * @param in input
   * @param xsl style sheet
   * @param par parameters
   * @return transformed result
   * @throws Exception exception
   */
  private static byte[] transform(final IO in, final IO xsl,
      final TokenObjMap<Object> par) throws Exception {

    // create transformer
    final TransformerFactory tc = TransformerFactory.newInstance();
    final Transformer tr =  tc.newTransformer(
        new StreamSource(new ByteArrayInputStream(xsl.read())));

    // bind parameters
    for(final byte[] key : par) tr.setParameter(string(key), par.get(key));

    // create serializer
    final ArrayOutput ao = new ArrayOutput();

    // do transformation and return result
    tr.transform(new StreamSource(new ByteArrayInputStream(in.read())),
        new StreamResult(ao));
    return ao.toArray();
  }
}
