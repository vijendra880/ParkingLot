package com.design.services;

import com.design.bo.BookingBo;
import org.springframework.stereotype.Service;

@Service
public class FareCalculationServiceImpl implements FareCalculationService {
  @Override
  public double calculateFare(BookingBo bookingBo) {
    double baseFare = bookingBo.getVehicleType().getBaseFare();
    long totalSecond =
        (bookingBo.getCheckOutTime().getTime() - bookingBo.getCheckInTime().getTime()) / 1000;
    return baseFare * totalSecond;
  }
}
