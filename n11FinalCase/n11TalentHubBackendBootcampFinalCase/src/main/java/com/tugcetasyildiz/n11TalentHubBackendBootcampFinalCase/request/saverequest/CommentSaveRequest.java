package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.enums.EnumScore;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseSaveRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class CommentSaveRequest extends BaseSaveRequest {
    @NotBlank
    @Size(max = 250)
    private String text;

    @NotBlank
    private EnumScore score;

    @NotBlank
    private Long customerId;

    @NotBlank
    private String restaurantId;
}
