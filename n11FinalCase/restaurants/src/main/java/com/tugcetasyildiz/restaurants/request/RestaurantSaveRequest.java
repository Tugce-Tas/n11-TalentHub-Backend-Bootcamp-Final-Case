package com.tugcetasyildiz.restaurants.request;

import lombok.Data;

@Data
public class RestaurantSaveRequest {
    private String name;
    private Double longitude;
    private Double latitude;
}
