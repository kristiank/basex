package org.basex.query.item;

import java.math.BigDecimal;
import org.basex.BaseX;
import org.basex.api.dom.BXAttr;
import org.basex.api.dom.BXComm;
import org.basex.api.dom.BXDoc;
import org.basex.api.dom.BXElem;
import org.basex.api.dom.BXNode;
import org.basex.api.dom.BXPI;
import org.basex.api.dom.BXText;
import org.basex.data.Data;
import org.basex.query.QueryException;
import org.basex.query.iter.NodIter;
import org.basex.query.iter.NodeIter;
import org.basex.query.iter.NodeMore;
import org.basex.util.Atts;
import org.basex.util.Token;

/**
 * Node type.
 *
 * @author Workgroup DBIS, University of Konstanz 2005-09, ISC License
 * @author Christian Gruen
 */
public abstract class Nod extends Item {
  /** Static node counter. */
  private static int sid;
  /** Unique node id. */
  protected final int id = sid++;
  /** Parent node. */
  protected Nod par;

  /**
   * Constructor.
   * @param t data type
   */
  protected Nod(final Type t) {
    super(t);
  }

  @Override
  public final boolean bool() {
    return true;
  }

  @Override
  public final long itr() throws QueryException {
    return Itr.parse(str());
  }

  @Override
  public final float flt() throws QueryException {
    return Flt.parse(str());
  }

  @Override
  public BigDecimal dec() throws QueryException {
    return Dec.parse(str());
  }

  @Override
  public double dbl() throws QueryException {
    return Dbl.parse(str());
  }

  @Override
  public final boolean eq(final Item i) throws QueryException {
    return i.type == Type.BLN || i.n() ? i.eq(this) : Token.eq(str(), i.str());
  }

  @Override
  public final int diff(final Item i) throws QueryException {
    return i.n() ? -i.diff(this) : Token.diff(str(), i.str());
  }

  /**
   * Creates a new copy (clone) of the node.
   * @return new copy
   */
  public abstract Nod copy();

  /**
   * Returns the node name.
   * @return name
   */
  public byte[] nname() {
    return null;
  }

  /**
   * Returns the node name.
   * @return name
   */
  public QNm qname() {
    return null;
  }

  /**
   * Returns a temporary node name.
   * @param nm temporary qname
   * @return name
   * @throws QueryException query exception
   */
  @SuppressWarnings("unused")
  public QNm qname(final QNm nm) throws QueryException {
    return qname();
  }

  /**
   * Returns a namespace array.
   * @return namespace array
   */
  public Atts ns() {
    return null;
  }

  /**
   * Returns the database name.
   * @return database name
   */
  public byte[] base() {
    return Token.EMPTY;
  }

  /**
   * Compares two nodes for equality.
   * @param nod node to be compared
   * @return result of check
   */
  public abstract boolean is(final Nod nod);

  /**
   * Compares two nodes for their unique order.
   * @param nod node to be compared
   * @return 0 if the nodes are equal or a positive/negative value
   * if the node appears after/before the argument
   */
  public abstract int diff(final Nod nod);

  /**
   * Returns a final node representation. This method should be called as
   * soon as a node is passed on as result node.
   * @return node
   */
  public Nod finish() {
    return this;
  }

  /**
   * Returns the parent node.
   * @return parent node
   */
  public abstract Nod parent();

  /**
   * Sets the parent node.
   * @param p parent node
   */
  public void parent(final Nod p) {
    par = p;
  }

  /**
   * Returns an ancestor axis iterator.
   * @return iterator
   */
  public NodeIter anc() {
    return new NodeIter() {
      /** Temporary node. */
      private Nod node = Nod.this;

      @Override
      public Nod next() {
        node = node.parent();
        return node;
      }
    };
  }

  /**
   * Returns an ancestor-or-self axis iterator.
   * @return iterator
   */
  public final NodeIter ancOrSelf() {
    return new NodeIter() {
      /** Temporary node. */
      private Nod node = Nod.this;

      @Override
      public Nod next() {
        if(node == null) return null;
        final Nod n = node;
        node = n.parent();
        return n;
      }
    };
  }

  /**
   * Returns an attribute axis iterator.
   * @return iterator
   */
  public abstract NodeIter attr();

  /**
   * Returns a child axis iterator.
   * @return iterator
   */
  public abstract NodeMore child();

  /**
   * Returns a descendant axis iterator.
   * @return iterator
   */
  public abstract NodeIter desc();

  /**
   * Returns a descendant-or-self axis iterator.
   * @return iterator
   */
  public abstract NodeIter descOrSelf();

  /**
   * Returns a following axis iterator.
   * @return iterator
   */
  public final NodeIter foll() {
    return new NodeIter() {
      /** Iterator. */
      private NodIter ir;

      @Override
      public Nod next() throws QueryException {
        if(ir == null) {
          ir = new NodIter();
          Nod n = Nod.this;
          Nod p = n.parent();
          while(p != null) {
            final NodeIter i = p.child();
            Nod c;
            while(n.type != Type.ATT && (c = i.next()) != null && !c.is(n));
            while((c = i.next()) != null) {
              ir.add(c.finish());
              addDesc(c.child(), ir);
            }
            n = p;
            p = p.parent();
          }
        }
        return ir.next();
      }
    };
  }

  /**
   * Returns a following-sibling axis iterator.
   * @return iterator
   */
  public final NodeIter follSibl() {
    return new NodeIter() {
      /** Iterator. */
      private NodeIter ir;

      @Override
      public Nod next() throws QueryException {
        if(ir == null) {
          final Nod r = parent();
          if(r == null) return null;
          ir = r.child();
          Nod n;
          while((n = ir.next()) != null && !n.is(Nod.this));
        }
        return ir.next();
      }
    };
  }

  /**
   * Returns a parent axis iterator.
   * @return iterator
   */
  public NodeIter par() {
    return new NodeIter() {
      /** First call. */
      private boolean more;

      @Override
      public Nod next() {
        return (more ^= true) ? parent() : null;
      }
    };
  }

  /**
   * Returns a preceding axis iterator.
   * @return iterator
   */
  public final NodeIter prec() {
    return new NodeIter() {
      /** Iterator. */
      private NodIter ir;

      @Override
      public Nod next() throws QueryException {
        if(ir == null) {
          ir = new NodIter();
          Nod n = Nod.this;
          Nod p = n.parent();
          while(p != null) {
            if(n.type != Type.ATT) {
              final NodIter tmp = new NodIter();
              final NodeIter i = p.child();
              Nod c;
              while((c = i.next()) != null && !c.is(n)) {
                tmp.add(c.finish());
                addDesc(c.child(), tmp);
              }
              for(int t = tmp.size() - 1; t >= 0; t--) ir.add(tmp.get(t));
            }
            n = p;
            p = p.parent();
          }
        }
        return ir.next();
      }
    };
  }

  /**
   * Returns a preceding-sibling axis iterator.
   * @return iterator
   */
  public final NodeIter precSibl() {
    return new NodeIter() {
      /** Children nodes. */
      private NodIter ir;
      /** Counter. */
      private int c;

      @Override
      public Nod next() throws QueryException {
        if(ir == null) {
          final Nod r = parent();
          if(r == null) return null;

          ir = new NodIter();
          final NodeIter iter = r.child();
          Nod n;
          while((n = iter.next()) != null) {
            if(n.is(Nod.this)) break;
            ir.add(n.finish());
          }
          c = ir.size();
        }
        return c > 0 ? ir.get(--c) : null;
      }
    };
  }

  /**
   * Returns an self axis iterator.
   * @return iterator
   */
  public final NodeMore self() {
    return new NodeMore() {
      /** First call. */
      private boolean more = true;

      @Override
      public boolean more() {
        return more;
      }
      @Override
      public Nod next() {
        return (more ^= true) ? null : Nod.this;
      }
    };
  }

  /**
   * Adds children of a sub node.
   * @param children child nodes
   * @param nodes node builder
   * @throws QueryException query exception
   */
  protected final void addDesc(final NodeIter children, final NodIter nodes)
      throws QueryException {
    Nod ch;
    while((ch = children.next()) != null) {
      nodes.add(ch.finish());
      addDesc(ch.child(), nodes);
    }
  }

  /**
   * Returns a database kind for the specified node type.
   * @param t node type
   * @return node kind
   */
  public static int kind(final Type t) {
    switch(t) {
      case DOC: return Data.DOC;
      case ELM: return Data.ELEM;
      case TXT: return Data.TEXT;
      case ATT: return Data.ATTR;
      case COM: return Data.COMM;
      case PI : return Data.PI;
      default : BaseX.notexpected(); return -1;
    }
  }

  @Override
  public final BXNode java() {
    switch(type) {
      case DOC: return new BXDoc(this);
      case ELM: return new BXElem(this);
      case TXT: return new BXText(this);
      case ATT: return new BXAttr(this);
      case COM: return new BXComm(this);
      case PI : return new BXPI(this);
      default : return null;
    }
  }
}
