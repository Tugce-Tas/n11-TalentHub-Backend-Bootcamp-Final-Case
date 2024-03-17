package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CustomerDTO extends BaseDTO {
    private Long id;
    private String fullName;
    private Double longitude;
    private Double latitude;
}