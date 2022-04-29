package com.uipkg.simple;

import javax.swing.JFrame;

import com.uipkg.exceptions.NonApplicableException;

public class SplashScreen implements SimpleFrame {
  private float timeMS;
  public SplashScreen(float timeMS) {
    this.timeMS = timeMS;
  }
  @Override
  public void run() {
  }
  @Override
  public void runWithTask(Runnable s) throws NonApplicableException {
  }
  @Override
  public void killTask() throws NonApplicableException {
  }
  @Override
  public JFrame getInstanceFrame() {return null;
  }
  
  
}
