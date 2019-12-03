package com.design.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VehicleEntryRequest {
    private int vehicleType;
    private String vehicleNumber;
    private Date checkInTime;
}
