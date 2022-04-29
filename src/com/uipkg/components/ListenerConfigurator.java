package com.uipkg.components;

import java.awt.event.AWTEventListener;
import java.util.ArrayList;

public class ListenerConfigurator {
  ArrayList<AWTEventListener> listeners = new ArrayList<>();

  public ListenerConfigurator(AWTEventListener... listeners) {
    for (AWTEventListener listener : listeners) {
      this.listeners.add(listener);
    }
  }

  public ArrayList<AWTEventListener> getListeners() {
    return listeners;
  }
}
