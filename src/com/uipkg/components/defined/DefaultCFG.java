package com.uipkg.components.defined;

import com.uipkg.components.Configurator;

public final class DefaultCFG {
  private DefaultCFG() {}
  public static final Configurator DEFAULT_CFG_SMALL = new Configurator(800, 800);
  public static final Configurator DEFAULT_CFG_MEDIUM = new Configurator(1024, 768);
  public static final Configurator DEFAULT_CFG_LARGE = new Configurator(1280, 1024);
  public static final Configurator CFG_480P = new Configurator(640, 480);
  public static final Configurator CFG_720P = new Configurator(1280, 720);
  public static final Configurator CFG_1080P = new Configurator(1920, 1080);
  public static final Configurator CFG_2160P = new Configurator(3840, 2160);
  public static final Configurator DEFAULT_FILL_CFG = new Configurator((int) ClientMachine.getClientScreenSpace().getWidth(), (int) ClientMachine.getClientScreenSpace().getHeight());
}
