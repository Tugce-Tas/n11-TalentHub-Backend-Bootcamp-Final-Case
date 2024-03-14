package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public abstract class BaseControllerContractImpl<
        S extends BaseService<E,R,M,DTO,SR,UR>,
        E extends BaseEntity,
        R extends JpaRepository<E, Long>,
        M extends BaseMapper<E, DTO, SR, UR>,
        DTO extends BaseDTO,
        UR extends BaseUpdateRequest,
        SR extends BaseSaveRequest
        > implements BaseControllerContract<DTO,UR,SR> {
    protected abstract S getService();

    @Override
    public DTO save(SR saveRequest) {
        return getService().save(saveRequest);
    }

    @Override
    public List<DTO> getAll() {
        return getService().getAll();
    }

    @Override
    public DTO updateById(Long id, UR request) {
        return getService().updateById(id, request);
    }

    @Override
    public void deleteById(Long id) {
        getService().deleteById(id);
    }

}
