package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface BaseMapper<
        E extends BaseEntity,
        DTO extends BaseDTO,
        SR extends BaseSaveRequest,
        UR extends BaseUpdateRequest> {

    E convertUpdateRequestToEntity(UR updateRequest);
    E convertSaveRequestToEntity(SR saveRequest);
    DTO convertToDTO(E entity);
    List<DTO> convertToDTOs(List<E> entityList);
    E convertToEntity(SR saveRequest);
}
