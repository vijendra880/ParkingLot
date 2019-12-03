package com.design.services;

import com.design.bo.BookingBo;
import com.design.enums.VehicleType;
import com.design.model.ParkingSpot;
import com.design.dto.VehicleEntryRequest;

public interface BookingService {
  String generateBooking(
      VehicleEntryRequest vehicleEntryRequest, ParkingSpot parkingSpot, VehicleType vehicleType);

  BookingBo getBookingById(String bookingId);
}
