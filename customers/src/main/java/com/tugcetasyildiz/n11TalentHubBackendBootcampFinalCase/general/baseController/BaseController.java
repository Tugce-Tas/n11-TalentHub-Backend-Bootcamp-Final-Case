package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Validated
public abstract class BaseController<
        DTO extends BaseDTO,
        SR extends BaseSaveRequest,
        UR extends BaseUpdateRequest,
        S extends BaseService<E,R,M,DTO,SR,UR>,
        E extends BaseEntity,
        R extends JpaRepository<E, Long>,
        M extends BaseMapper<E,DTO,SR,UR>> {

    protected abstract BaseControllerContractImpl<S,E,R,M,DTO,UR,SR> getControllerContract();

    @PostMapping
    public ResponseEntity<RestResponse<DTO>> save(@Valid @RequestBody SR saveRequest) {
        DTO dto = getControllerContract().save(saveRequest);
        return ResponseEntity.ok(RestResponse.of(dto));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<DTO>>> getAll() {
        List<DTO> dtoList = getControllerContract().getAll();
        return ResponseEntity.ok(RestResponse.of(dtoList));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<DTO>> updateById(@PathVariable @NotBlank Long id,
                                                        @Valid @RequestBody UR updateRequest) {
        DTO dto = getControllerContract().updateById(id, updateRequest);
        return ResponseEntity.ok(RestResponse.of(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        getControllerContract().deleteById(id);
    }
}
