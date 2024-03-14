package com.tugcetasyildiz.restaurants.client.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CommentRestaurantResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4662475407732921681L;

    private String text;
    private EnumScore score;
}
