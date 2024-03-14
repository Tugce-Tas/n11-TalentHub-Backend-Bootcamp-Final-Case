package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.enums.EnumScore;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseUpdateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentUpdateRequest extends BaseUpdateRequest {

    @NotBlank
    @Size(max = 250)
    private String text;

    @NotBlank
    private EnumScore score;
}

