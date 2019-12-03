package com.design.services;

import com.design.bo.BookingBo;

public interface FareCalculationService {
    double calculateFare(BookingBo bookingBo);
}
