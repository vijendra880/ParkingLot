package com.design.services;

import com.design.dto.VehicleEntryRequest;
import com.design.dto.VehicleEntryResponse;
import com.design.dto.VehicleExitRequest;
import com.design.dto.VehicleExitResponse;

public interface ParkingLotService {

    VehicleEntryResponse makeVehicleEntry(VehicleEntryRequest vehicleEntryRequest);

    VehicleExitResponse makeVehicleExit(VehicleExitRequest vehicleExitRequest);
}
