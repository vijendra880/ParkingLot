package com.design.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ParkingLot {

  private Map<Integer, ParkingFloor> parkingFloorMap;

  public void addParkingFloors(int floors, int lotId) {
    parkingFloorMap = new HashMap<>();
    for (int floorIndex = 1; floorIndex <= floors; floorIndex++) {
      addParkingFloor(floorIndex, lotId);
    }
  }

  public void addParkingFloor(int floorId, int lotId) {
    ParkingFloor parkingFloor = new ParkingFloor();
    parkingFloorMap.put(floorId, parkingFloor);
    parkingFloor.addParkingSpots(lotId, floorId);
  }
}
