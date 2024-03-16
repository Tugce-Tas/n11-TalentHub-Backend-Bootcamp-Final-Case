package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantDTO {
    private String id;
    private String name;
    private Double longitude;
    private Double latitude;
    private Double averageScore;
}
