package com.uipkg.exceptions;

public class NonApplicableException extends Exception {
  public NonApplicableException() {
    super();
  }

  public NonApplicableException(String message) {
    super(message);
  }

  public NonApplicableException(String message, Throwable cause) {
    super(message, cause);
  }

  public NonApplicableException(Throwable cause) {
    super(cause);
  }

  protected NonApplicableException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
