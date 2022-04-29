package com.uipkg.components;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import com.uipkg.components.defined.ClientMachine;

import java.awt.Color;

public final class Configurator {
  private Dimension dim;
  private Color bg = Color.WHITE;
  private Color fg = Color.BLACK;
  private String name = "";
  private ListenerConfigurator listenerConfigurator;
  private ImageIcon icon = null;
  public Configurator(int width, int height) {
    dim = new Dimension(width, height);
    name = ClientMachine.getClientName();
  }

  public Configurator(String title, int width, int height, Color background) {
    this(width, height);
    bg = background;
    this.name = title;
  }

  public Configurator(String title, int width, int height, Color background, Color foreground, ImageIcon icon, ListenerConfigurator listenerConfigurator) {
    this(title, width, height, background);
    fg = foreground;
    this.name = title;
    this.icon = icon;
    this.listenerConfigurator = listenerConfigurator;
  }

  public Dimension getDimension() {
    return dim;
  }

  public Color getBackgroundColor() {
    return bg;
  }

  public Color getForegroundColor() {
    return fg;
  }

  public String getTitleStr() {
    return name;
  }

  public ImageIcon getIcon() {
    return icon;
  }

  public ListenerConfigurator getListenerConfigurator() {
    return listenerConfigurator;
  }
}
