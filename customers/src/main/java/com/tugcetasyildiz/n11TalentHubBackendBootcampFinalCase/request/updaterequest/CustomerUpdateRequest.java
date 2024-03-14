package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseUpdateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class CustomerUpdateRequest extends BaseUpdateRequest {
    @NotBlank
    @Size(max = 50, min = 2)
    private String name;

    @NotBlank
    @Size(max = 50, min = 2)
    private String surname;

    @NotBlank
    @Positive
    private Double longitude;

    @NotBlank
    @Positive
    private Double latitude;
}
