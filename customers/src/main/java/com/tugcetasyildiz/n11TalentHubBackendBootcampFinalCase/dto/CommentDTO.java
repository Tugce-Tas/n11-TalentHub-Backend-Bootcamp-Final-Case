package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto;


import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.enums.EnumScore;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseDTO;
import lombok.Data;
@Data
public class CommentDTO extends BaseDTO {
    private String text;
    private EnumScore score;
    private String customerName;
    private String restaurantId;

}
