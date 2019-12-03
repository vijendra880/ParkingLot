package com.design.model;

import com.design.enums.ParkingSpotType;
import com.design.services.ParkingSpotInventoryService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {
  private Integer id;
  private ParkingSpotType spotType;
  private int floorId;
  private int lotId;

  public ParkingSpot(int id, ParkingSpotType spotType) {
    this.id = id;
    this.spotType = spotType;
  }

  public ParkingSpot addParkingSpot(int lotId, int floorId) {
    this.lotId = lotId;
    this.floorId = floorId;
    ParkingSpotInventoryService.addParkingSpotInInventory(this);
    return this;
  }


}
