package com.design.services;

import com.design.bo.BookingBo;
import com.design.enums.VehicleType;
import com.design.model.ParkingSpot;
import com.design.dto.VehicleEntryRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
  private static Map<String, BookingBo> bookingBoMap = new HashMap<>();

  @Override
  public String generateBooking(
      VehicleEntryRequest vehicleEntryRequest, ParkingSpot parkingSpot, VehicleType vehicleType) {
    BookingBo bookingBo = new BookingBo();
    // TODO: another approch to be used to  generate booking id to avoid duplicate
    String bookingId = UUID.randomUUID().toString().substring(0, 5);
    bookingBo.setBookingId(bookingId);
    bookingBo.setCheckInTime(new Date());
    bookingBo.setParkingSpot(parkingSpot);
    bookingBo.setVehicleType(vehicleType);
    bookingBo.setVehicleNumber(vehicleEntryRequest.getVehicleNumber());
    bookingBoMap.put(bookingId, bookingBo);
    return bookingId;
  }

  @Override
  public BookingBo getBookingById(String bookingId) {
    return bookingBoMap.get(bookingId);
  }
}
