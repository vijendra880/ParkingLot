package com.design.model;

import com.design.enums.ParkingSpotType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ParkingFloor {
  private Map<Integer, ParkingSpot> parkingSpotMap;

  public void addParkingSpots(int lotId, int floorId) {
    parkingSpotMap = new HashMap<>();
    int spotIndex = 1;
    addParkingSpot(spotIndex, floorId, lotId, ParkingSpotType.SMALL);
  }

  public void addParkingSpot(int spotId, int floorId, int lotId, ParkingSpotType parkingSpotType) {
    parkingSpotMap.put(
        spotId, new ParkingSpot(spotId, parkingSpotType).addParkingSpot(lotId, floorId));
  }
}
