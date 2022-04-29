package com.uipkg.simple;

import javax.swing.JFrame;

import com.uipkg.exceptions.NonApplicableException;

public interface SimpleFrame {
  public void run();
  public void runWithTask(Runnable s) throws NonApplicableException;
  public void killTask() throws NonApplicableException;
  public JFrame getInstanceFrame();
}
