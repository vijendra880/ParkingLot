package com.design.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum VehicleType {
  BIKE(1, ParkingSpotType.SMALL, 10),
  CAR(2, ParkingSpotType.MEDIUM, 20),
  BUS(3, ParkingSpotType.LARGE, 30);

  private int id;
  private ParkingSpotType spotType;
  private double baseFare;

  VehicleType(int id, ParkingSpotType spotType, double baseFare) {
    this.id = id;
    this.spotType = spotType;
    this.baseFare = baseFare;
  }

  public static VehicleType getVehicleTypeById(int id) {
    return Arrays.stream(VehicleType.values())
        .filter(type -> type.id == id)
        .findFirst()
        .orElse(null);
  }
}
