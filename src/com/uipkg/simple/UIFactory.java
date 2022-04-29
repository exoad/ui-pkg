package com.uipkg.simple;

import java.awt.event.AWTEventListener;
import java.awt.event.WindowListener;
import java.awt.event.KeyListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.ComponentListener;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.uipkg.components.Configurator;
import com.uipkg.components.defined.DefaultCFG;
import com.uipkg.exceptions.NonApplicableException;

public final class UIFactory extends JFrame implements SimpleFrame {
  private static final long serialVersionUID = 1L;

  public UIFactory(Configurator cfg, JComponent... components) {
    setPreferredSize(cfg.getDimension());
    setBackground(cfg.getBackgroundColor());
    setForeground(cfg.getForegroundColor());
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setTitle(cfg.getTitleStr());
    if (cfg.getIcon() != null) {
      setIconImage(cfg.getIcon().getImage());
    }
    for (JComponent component : components) {
      add(component);
    }
    ArrayList<AWTEventListener> listeners = cfg.getListenerConfigurator().getListeners();
    for (AWTEventListener listener : listeners) {
      if (listener instanceof WindowListener) {
        addWindowListener((WindowListener) listener);
      } else if (listener instanceof KeyListener) {
        addKeyListener((KeyListener) listener);
      } else if (listener instanceof FocusListener) {
        addFocusListener((FocusListener) listener);
      } else if (listener instanceof MouseListener) {
        addMouseListener((MouseListener) listener);
      } else if (listener instanceof MouseMotionListener) {
        addMouseMotionListener((MouseMotionListener) listener);
      } else if (listener instanceof MouseWheelListener) {
        addMouseWheelListener((MouseWheelListener) listener);
      } else if (listener instanceof ComponentListener) {
        addComponentListener((ComponentListener) listener);
      } else {
        try {
          throw new NonApplicableException("Listener type not supported");
        } catch (NonApplicableException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public UIFactory() {
    this(DefaultCFG.CFG_480P);
  }

  public UIFactory(JComponent... components) {
    this(DefaultCFG.CFG_480P, components);
  }

  @Override
  public void run() {
    pack();
    setVisible(true);
  }

  @Override
  public void runWithTask(Runnable s) throws NonApplicableException {
    throw new NonApplicableException("UIFactory frames cannot be attached with a synchronous task.");
  }

  @Override
  public void killTask() throws NonApplicableException {
    throw new NonApplicableException("UIFactory frames cannot be attached with a synchronous task.");
  }

  @Override
  public JFrame getInstanceFrame() {
    return this;
  }
}