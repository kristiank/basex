package org.basex.gui.dialog;

import static org.basex.core.Text.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import org.basex.core.Progress;
import org.basex.gui.GUI;
import org.basex.gui.layout.BaseXBack;
import org.basex.gui.layout.BaseXButton;
import org.basex.gui.layout.BaseXLabel;
import org.basex.gui.layout.BaseXLayout;

/**
 * Dialog window for displaying the progress of a process.
 *
 * @author Workgroup DBIS, University of Konstanz 2005-09, ISC License
 * @author Christian Gruen
 */
public final class DialogProgress extends Dialog implements ActionListener {
  /** Refresh action. */
  private final Timer timer = new Timer(100, this);
  /** Information label. */
  private final BaseXLabel info;
  /** Progress reference. */
  private final Progress prog;
  /** Progress bar. */
  private JProgressBar bar;
  /** Current progress length. */
  private int ww;

  /**
   * Default constructor.
   * @param main reference to the main window
   * @param msg waiting message.
   * @param pb showing a progress bar
   * @param cnc cancel flag
   * @param prg progress reference
   */
  public DialogProgress(final GUI main, final String msg, final boolean pb,
      final boolean cnc, final Progress prg) {

    super(main, msg, false);

    info = new BaseXLabel(" ", true, true);
    set(info, BorderLayout.NORTH);

    if(!pb) {
      BaseXLayout.setWidth(info, 600);
    } else {
      ww = 320;
      bar = new JProgressBar(0, ww);
      bar.setPreferredSize(new Dimension(ww, 16));
      set(bar, BorderLayout.CENTER);
    }

    final BaseXBack p = new BaseXBack();
    p.setLayout(new BorderLayout());
    p.setBorder(10, 0, 0, 0);
    if(cnc) p.add(new BaseXButton(BUTTONCANCEL, this),
        BorderLayout.EAST);
    set(p, BorderLayout.SOUTH);
    finish(null);

    prog = prg;
    timer.start();
  }

  @Override
  public void cancel() {
    prog.stop();
    close();
  }

  @Override
  public void close() {
    dispose();
  }

  @Override
  public void dispose() {
    timer.stop();
    super.dispose();
  }

  public void actionPerformed(final ActionEvent e) {
    setTitle(prog.title());
    info.setText(prog.detail());
    if(bar != null) bar.setValue((int) (prog.progress() * ww));
  }
}
