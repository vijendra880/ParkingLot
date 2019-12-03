package com.design.services;

import com.design.enums.ParkingSpotType;
import com.design.enums.VehicleType;
import com.design.model.ParkingFloor;
import com.design.model.ParkingLot;
import com.design.model.ParkingSpot;
import com.design.dto.ParkingInventoryUpdateRequest;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingSpotInventoryService {
  /** Will maintain only available parking spot */
  private static Map<ParkingSpotType, List<ParkingSpot>> availableParkingSpotMap = new HashMap<>();
  /** Will maintain complete parking lot map */
  private static Map<Integer, ParkingLot> parkingLots;

  public static void addParkingSpotInInventory(ParkingSpot parkingSpot) {
    List<ParkingSpot> parkingSpots = availableParkingSpotMap.get(parkingSpot.getSpotType());
    if (parkingSpots == null) {
      parkingSpots = new LinkedList<>();
    }
    parkingSpots.add(parkingSpot);
    availableParkingSpotMap.put(parkingSpot.getSpotType(), parkingSpots);
  }

  public static Map<ParkingSpotType, List<ParkingSpot>> getAvailableParkingSpotMap() {
    return availableParkingSpotMap;
  }

  public static ParkingSpot assignVehicle(VehicleType vehicleType) {
    return findAvailableSpot(vehicleType.getSpotType());
  }

  private static ParkingSpot findAvailableSpot(ParkingSpotType spotType) {
    if (spotType == null) {
      return null;
    }
    List<ParkingSpot> availableParkingSpots = availableParkingSpotMap.get(spotType);
    if (CollectionUtils.isEmpty(availableParkingSpots)) {
      return findAvailableSpot(ParkingSpotType.getNextAvailableParkingSpot(spotType));
    }
    return availableParkingSpots.remove(0);
  }

  public static void unAssignParkingSpot(ParkingSpot parkingSpot) {
    addParkingSpotInInventory(parkingSpot);
  }

  public static void initializeParkingLots() {
    parkingLots = new HashMap<>();
    int lotIndex = 1;
    parkingLots.put(lotIndex, addParkingLot(lotIndex));
  }

  public static ParkingLot addParkingLot(int lotId) {
    ParkingLot parkingLot = parkingLots.get(lotId);
    if (parkingLot == null) {
      parkingLot = new ParkingLot();
    }
    parkingLot.addParkingFloors(2, lotId);
    return parkingLot;
  }

  public static Map<Integer, ParkingLot> getParkingLotsDetail() {
    return parkingLots;
  }

  public static void addParkingFloor(ParkingInventoryUpdateRequest parkingInventoryUpdateRequest) {
    parkingLots
        .get(parkingInventoryUpdateRequest.getLotId())
        .addParkingFloors(
            1, parkingInventoryUpdateRequest.getLotId());
  }

  public static void addParkingSpot(ParkingInventoryUpdateRequest parkingInventoryUpdateRequest) {
    parkingLots
        .get(parkingInventoryUpdateRequest.getLotId())
        .getParkingFloorMap()
        .get(parkingInventoryUpdateRequest.getFloorId())
        .addParkingSpot(
            parkingInventoryUpdateRequest.getSpotId(),
            parkingInventoryUpdateRequest.getFloorId(),
            parkingInventoryUpdateRequest.getLotId(),
            ParkingSpotType.getParkingSpotTypeById(parkingInventoryUpdateRequest.getSpotTypeId()));
  }

  public static void printAvailableParkingMap() {
    for (Map.Entry<ParkingSpotType, List<ParkingSpot>> parkingSpotTypeListEntry :
        availableParkingSpotMap.entrySet()) {
      System.out.println("Spot Type: " + parkingSpotTypeListEntry.getKey().toString());
      System.out.println();
      List<ParkingSpot> parkingSpots = parkingSpotTypeListEntry.getValue();
      parkingSpots.forEach(parkingSpot -> System.out.println("  " + parkingSpot.getId()));
    }
  }
}
