package com.design.bo;

import com.design.enums.VehicleType;
import com.design.model.ParkingSpot;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingBo {
    private String bookingId;
    private Date checkInTime;
    private Date checkOutTime;
    private String vehicleNumber;
    private ParkingSpot parkingSpot;
    private VehicleType vehicleType;
}
