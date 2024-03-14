package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller.contract.CommentControllerControllerImpl;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CommentRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentRestaurantResponseDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.RestResponse;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController.BaseController;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController.BaseControllerContractImpl;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.mapper.CommentMapper;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CommentSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CommentUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
@RequiredArgsConstructor
public class CommentController extends BaseController<
        CommentDTO,
        CommentSaveRequest,
        CommentUpdateRequest,
        CommentService,
        Comment,
        CommentRepository,
        CommentMapper> {

        private final CommentControllerControllerImpl commentContract;
        private final CommentService commentService;
        @Override
        protected BaseControllerContractImpl<CommentService, Comment, CommentRepository, CommentMapper, CommentDTO, CommentUpdateRequest, CommentSaveRequest> getControllerContract() {
            return commentContract;
        }

        @GetMapping("/with-restaurant-id/{restaurantId}")
        public ResponseEntity<RestResponse<List<CommentRestaurantResponseDTO>>> getAllByRestaurantId(@PathVariable String restaurantId) {
            List<CommentRestaurantResponseDTO> allByRestaurantId = commentService.getAllByRestaurantId(restaurantId);
            return ResponseEntity.ok(RestResponse.of(allByRestaurantId));
        }
}

