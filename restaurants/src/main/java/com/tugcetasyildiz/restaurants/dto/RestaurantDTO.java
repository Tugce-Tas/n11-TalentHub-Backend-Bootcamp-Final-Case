package com.tugcetasyildiz.restaurants.dto;

import com.tugcetasyildiz.restaurants.client.model.CommentDTO;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RestaurantDTO {

    private String id;
    private String name;
    private Double longitude;
    private Double latitude;
    private Double averageScore;
    private ArrayList<CommentDTO> commentList;
}
