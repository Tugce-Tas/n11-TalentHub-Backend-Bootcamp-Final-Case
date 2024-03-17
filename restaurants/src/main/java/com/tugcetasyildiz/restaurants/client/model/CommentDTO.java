package com.tugcetasyildiz.restaurants.client.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CommentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4662475407732921681L;
    private Long id;
    private String text;
    private EnumScore score;
    private String customerId;
    private String customerName;
    private String restaurantId;
}
