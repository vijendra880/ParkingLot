package com.design.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public class VehicleExitResponse {
    private String vehicleNumber;
    private double amount;
    private Date checkOutTime;


    @Override
    public String toString() {
        return "VehicleExitResponse{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", amount=" + amount +
                ", checkOutTime=" + checkOutTime +
                '}';
    }
}
