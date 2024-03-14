package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.ItemNotFoundException;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.message.EnumErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class BaseService<E extends BaseEntity,
                                  R extends JpaRepository<E, Long>,
                                  M extends BaseMapper<E, DTO,SR, UR>,
                                  DTO extends BaseDTO,
                                  SR extends  BaseSaveRequest,
                                  UR extends BaseUpdateRequest> {

    protected abstract R getRepository();
    protected abstract M getMapper();

    public DTO save(SR saveRequest) {
       E entity = getMapper().convertSaveRequestToEntity(saveRequest);
       getRepository().save(entity);
       return getMapper().convertToDTO(entity);
    }

    public List<DTO> getAll() {
        return getMapper().convertToDTOs(getRepository().findAll());
    }

    public abstract DTO updateById(Long id, UR updateRequest);

    public void deleteById(Long id) {
        E entity = getRepository().findById(id).orElse(null);

        if (Objects.isNull(entity)) {
            throw new ItemNotFoundException(EnumErrorMessage.ITEM_NOT_FOUND);
        }
        getRepository().deleteById(id);
    }
}
