package com.design.services;

import com.design.bo.BookingBo;
import com.design.enums.CustomExceptionResponseCodes;
import com.design.enums.VehicleType;
import com.design.exception.CustomException;
import com.design.model.ParkingSpot;
import com.design.dto.VehicleEntryRequest;
import com.design.dto.VehicleEntryResponse;
import com.design.dto.VehicleExitRequest;
import com.design.dto.VehicleExitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

  @Autowired private BookingService bookingService;
  @Autowired private FareCalculationService fareCalculationService;

  @Override
  public VehicleEntryResponse makeVehicleEntry(VehicleEntryRequest vehicleEntryRequest) {
    VehicleType vehicleType = VehicleType.getVehicleTypeById(vehicleEntryRequest.getVehicleType());
    ParkingSpot parkingSpot = ParkingSpotInventoryService.assignVehicle(vehicleType);
    if (parkingSpot == null) {
      throw new CustomException(CustomExceptionResponseCodes.NO_PARKING_SPOT_FOUND);
    }
    String bookingId =
        bookingService.generateBooking(vehicleEntryRequest, parkingSpot, vehicleType);
    return VehicleEntryResponse.builder().bookingId(bookingId).parkingSpot(parkingSpot).build();
  }

  @Override
  public VehicleExitResponse makeVehicleExit(VehicleExitRequest vehicleExitRequest) {
    BookingBo bookingBo = bookingService.getBookingById(vehicleExitRequest.getBookingId());
    bookingBo.setCheckOutTime(vehicleExitRequest.getCheckOutTime());
    ParkingSpotInventoryService.unAssignParkingSpot(bookingBo.getParkingSpot());
    double parkingCharges = fareCalculationService.calculateFare(bookingBo);
    return VehicleExitResponse.builder()
        .amount(parkingCharges)
        .vehicleNumber(bookingBo.getVehicleNumber())
        .checkOutTime(bookingBo.getCheckOutTime())
        .build();
  }
}
