package com.design.dto;

import lombok.Getter;

@Getter
public class ParkingInventoryUpdateRequest {
    private int lotId;
    private int floorId;
    private int spotId;
    private byte spotTypeId;
}
