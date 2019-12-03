package com.design.manager;

import com.design.dto.ParkingInventoryUpdateRequest;
import com.design.dto.VehicleEntryRequest;
import com.design.dto.VehicleExitRequest;
import com.design.enums.ActionType;
import com.design.services.ParkingLotService;
import com.design.services.ParkingSpotInventoryService;
import com.design.utils.JsonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotManager {

  @Autowired private ParkingLotService parkingLotService;

  public void performAction(byte actionId, String requestData) {
    ActionType actionType = ActionType.getActionTypeById(actionId);
    switch (actionType) {
      case ADD_PARKING_LOT:
        ParkingSpotInventoryService.addParkingLot(
            JsonUtility.parseJsonStringToObject(requestData, ParkingInventoryUpdateRequest.class)
                .getLotId());
        break;
      case ADD_PARKING_FLOOR:
        ParkingSpotInventoryService.addParkingFloor(
            JsonUtility.parseJsonStringToObject(requestData, ParkingInventoryUpdateRequest.class));
        break;
      case ADD_PARKING_SPOT:
        ParkingSpotInventoryService.addParkingSpot(
            JsonUtility.parseJsonStringToObject(requestData, ParkingInventoryUpdateRequest.class));
        break;
      case VEHICLE_ENTRY:
        System.out.println(
            parkingLotService
                .makeVehicleEntry(
                    JsonUtility.parseJsonStringToObject(requestData, VehicleEntryRequest.class))
                .toString());
        break;
      case VEHICLE_EXIT:
        System.out.println(
            parkingLotService
                .makeVehicleExit(
                    JsonUtility.parseJsonStringToObject(requestData, VehicleExitRequest.class))
                .toString());
        break;
      case PARKING_MAP_VIEW:
        ParkingSpotInventoryService.printAvailableParkingMap();
        break;
    }
  }
}
