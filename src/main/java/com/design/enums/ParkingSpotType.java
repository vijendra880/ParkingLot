package com.design.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum ParkingSpotType {
  SMALL((byte) 1),
  MEDIUM((byte) 2),
  LARGE((byte) 3);

  private static Map<ParkingSpotType, ParkingSpotType> nextAvailableSpotMap;
  private byte id;

  ParkingSpotType(byte id) {
    this.id = id;
  }

  public static ParkingSpotType getNextAvailableParkingSpot(ParkingSpotType parkingSpotType) {
    if (nextAvailableSpotMap == null) {
      initializeNextParkingSpotData();
    }
    return nextAvailableSpotMap.get(parkingSpotType);
  }

  private static void initializeNextParkingSpotData() {
    nextAvailableSpotMap = new HashMap<>();
    nextAvailableSpotMap.put(SMALL, MEDIUM);
    nextAvailableSpotMap.put(MEDIUM, LARGE);
  }

  public static ParkingSpotType getParkingSpotTypeById(byte id) {
    return Arrays.stream(ParkingSpotType.values())
        .filter(parkingSpotType -> id == parkingSpotType.id)
        .findFirst()
        .orElse(null);
  }
}
