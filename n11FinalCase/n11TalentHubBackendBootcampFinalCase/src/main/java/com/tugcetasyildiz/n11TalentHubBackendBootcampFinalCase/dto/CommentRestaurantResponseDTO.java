package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.enums.EnumScore;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommentRestaurantResponseDTO extends BaseDTO {
    private String text;
    private EnumScore score;
}
