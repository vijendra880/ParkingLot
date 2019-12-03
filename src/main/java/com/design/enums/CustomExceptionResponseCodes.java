package com.design.enums;

import lombok.Getter;

@Getter
public enum CustomExceptionResponseCodes {
  INVALID_ACTION_ERROR("PL_001", "Invalid Action"),
  INVALID_PARKING_SPOT("PL_002","Invalid Parking Spot"),
  NO_PARKING_SPOT_FOUND("PL_003","Parking Spot not available");
  private String errorCode;
  private String errorMessage;

  CustomExceptionResponseCodes(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }


}
