package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.RestResponse;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CommentSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CommentUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
@RequiredArgsConstructor
@Validated
@Tag(name = "Comment Controller", description = "Comment Management")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "Save comment")
    public ResponseEntity<RestResponse<CommentDTO>> save(@Valid @RequestBody CommentSaveRequest saveRequest) {
        CommentDTO commentDTO = commentService.save(saveRequest);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @GetMapping
    @Operation(summary = "Get all comments")
    public ResponseEntity<RestResponse<List<CommentDTO>>> getAll() {
        List<CommentDTO> commentDTOList = commentService.getAll();
        return ResponseEntity.ok(RestResponse.of(commentDTOList));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update comment by id")
    public ResponseEntity<RestResponse<CommentDTO>> updateById(@PathVariable @NotBlank Long id,
                                                        @Valid @RequestBody CommentUpdateRequest updateRequest) {
        CommentDTO dto = commentService.updateById(id, updateRequest);
        return ResponseEntity.ok(RestResponse.of(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete comment by id")
    public void deleteById(@PathVariable Long id) {
        commentService.deleteById(id);
    }

    @GetMapping("/with-restaurant-id/{restaurantId}")
    @Operation(summary = "Get all comments by restaurant id")
    public ResponseEntity<RestResponse<List<CommentDTO>>> getAllByRestaurantId(@PathVariable String restaurantId) {
        List<CommentDTO> allByRestaurantId = commentService.getAllByRestaurantId(restaurantId);
        return ResponseEntity.ok(RestResponse.of(allByRestaurantId));
    }

}
