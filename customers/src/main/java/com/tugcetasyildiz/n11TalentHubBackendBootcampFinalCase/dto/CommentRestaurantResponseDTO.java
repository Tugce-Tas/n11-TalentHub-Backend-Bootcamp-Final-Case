package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.enums.EnumScore;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommentRestaurantResponseDTO extends BaseDTO {
    private Long id;
    private String text;
    private EnumScore score;
    private Long customerId;
    private String customerName;
    private String restaurantId;
}
