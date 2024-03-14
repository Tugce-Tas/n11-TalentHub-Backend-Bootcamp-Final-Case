package com.tugcetasyildiz.restaurants.request;

import lombok.Data;

@Data
public class RestaurantUpdateRequest {
    private String name;
    private Double longitude;
    private Double latitude;
}
