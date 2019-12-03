package com.design.dto;

import com.design.model.ParkingSpot;
import lombok.Builder;

@Builder
public class VehicleEntryResponse {
  private ParkingSpot parkingSpot;
  private String bookingId;

  @Override
  public String toString() {
    return "VehicleEntryResponse{" +
            "parkingSpot=" + parkingSpot +
            ", bookingId='" + bookingId + '\'' +
            '}';
  }
}
