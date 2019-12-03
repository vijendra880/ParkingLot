package com.design.exception;

import com.design.enums.CustomExceptionResponseCodes;

public class CustomException extends RuntimeException {
  private CustomExceptionResponseCodes customExceptionResponseCodes;

  public CustomException(CustomExceptionResponseCodes customExceptionResponseCodes) {
    this.customExceptionResponseCodes = customExceptionResponseCodes;
  }

  public CustomExceptionResponseCodes getCustomExceptionResponseCodes() {
    return customExceptionResponseCodes;
  }
}
