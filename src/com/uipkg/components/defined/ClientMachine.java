package com.uipkg.components.defined;

import java.awt.Dimension;
import java.awt.Toolkit;

public final class ClientMachine {
  private ClientMachine() {}

  public static Dimension getClientScreenSpace() {
    return Toolkit.getDefaultToolkit().getScreenSize();
  }

  public static String getClientName() {
    return System.getProperty("os.name");
  }
}
