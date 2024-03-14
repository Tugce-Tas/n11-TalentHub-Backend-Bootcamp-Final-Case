package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseUpdateRequest;

import java.util.List;

public interface BaseControllerContract<D extends BaseDTO, U extends BaseUpdateRequest, S extends BaseSaveRequest> {
    D save(S saveRequest);

    List<D> getAll();

    D updateById(Long id, U updateRequest);

    void deleteById(Long id);
}
