package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller.contract;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CommentRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentRestaurantResponseDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.baseController.BaseControllerContractImpl;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.mapper.CommentMapper;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CommentSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CommentUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CommentControllerControllerImpl extends BaseControllerContractImpl<
        CommentService,
        Comment,
        CommentRepository,
        CommentMapper,
        CommentDTO,
        CommentUpdateRequest,
        CommentSaveRequest> {

    private final CommentService commentService;
    @Override
    protected CommentService getService() {
        return commentService;
    }
    public ArrayList<CommentRestaurantResponseDTO> getAllByRestaurantId(String restaurantId) {
        return getService().getAllByRestaurantId(restaurantId);
    }
}
