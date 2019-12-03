package com.design.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VehicleExitRequest {
    private String bookingId;
    private Date checkOutTime;
}
