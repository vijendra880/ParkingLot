package com.design.enums;

import java.util.Arrays;

public enum ActionType {
  ADD_PARKING_LOT((byte) 1),
  ADD_PARKING_FLOOR((byte) 2),
  ADD_PARKING_SPOT((byte) 3),

  VEHICLE_ENTRY((byte) 4),
  VEHICLE_EXIT((byte) 5),
  PARKING_MAP_VIEW((byte) 6);

  private byte actionId;

  ActionType(byte actionId) {
    this.actionId = actionId;
  }

  public static ActionType getActionTypeById(byte id) {
    return Arrays.stream(ActionType.values())
        .filter(type -> type.actionId == id)
        .findFirst()
        .orElse(null);
  }
}
