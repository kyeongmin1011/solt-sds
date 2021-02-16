package com.safetyas.sds.auth.api.exception;

public class CustomNoSuchElementException extends RuntimeException {
  public CustomNoSuchElementException(String msg, Throwable t) {
    super(msg, t);
  }

  public CustomNoSuchElementException(String msg) {
    super(msg);
  }

  public CustomNoSuchElementException() {
    super();
  }
}
