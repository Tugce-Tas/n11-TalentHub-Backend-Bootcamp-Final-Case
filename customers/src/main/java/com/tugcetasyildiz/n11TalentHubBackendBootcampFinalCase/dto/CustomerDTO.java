package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseDTO;
import lombok.Data;

@Data
public class CustomerDTO extends BaseDTO {
    private String fullName;
    private Double longitude;
    private Double latitude;
}