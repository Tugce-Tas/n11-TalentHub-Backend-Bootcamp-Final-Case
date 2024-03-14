package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.RestaurantClientService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CommentRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentRestaurantResponseDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.InvalidCustomerIdException;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.InvalidRestaurantIdException;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.InvalidCommentIdException;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.message.EnumErrorMessage;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.mapper.CommentMapper;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CommentSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CommentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentService extends BaseService<
        Comment,
        CommentRepository,
        CommentMapper,
        CommentDTO,
        CommentSaveRequest,
        CommentUpdateRequest>{

    private final CommentRepository commentRepository;
    private final RestaurantClientService restaurantClientService;
    private final CustomerRepository customerRepository;
    @Override
    protected CommentRepository getRepository() {
        return commentRepository;
    }
    @Override
    protected CommentMapper getMapper() {
        return CommentMapper.INSTANCE;
    }

    @Override
    public CommentDTO save(CommentSaveRequest saveRequest) {
        Comment comment = getMapper().convertSaveRequestToEntity(saveRequest);
        Customer customer = customerRepository.findById(saveRequest.getCustomerId()).orElse(null);
        RestaurantDTO restaurant = restaurantClientService.getRestaurantById(saveRequest.getRestaurantId());

        if (Objects.isNull(customer)) {
            throw new InvalidCustomerIdException(EnumErrorMessage.INVALID_CUSTOMER_ID);
        }
        if (Objects.isNull(restaurant)) {
            throw new InvalidRestaurantIdException(EnumErrorMessage.INVALID_RESTAURANT_ID);
        }

        comment.setCustomer(customer);
        getRepository().save(comment);

        updateCommentsAndScore(comment.getRestaurantId());

        return getMapper().convertToDTO(comment);
    }

    @Override
    public CommentDTO updateById(Long commentId, CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (Objects.isNull(comment)) {
            throw new InvalidCommentIdException(EnumErrorMessage.INVALID_COMMENT_ID);
        }
        comment.setText(request.getText());
        comment.setScore(request.getScore());
        commentRepository.save(comment);

        updateCommentsAndScore(comment.getRestaurantId());

        return getMapper().convertToDTO(comment);
    }

    public void updateCommentsAndScore(String restaurantId) {
        restaurantClientService.updateCommentsAndScore(restaurantId, getAllByRestaurantId(restaurantId));
    }

    public ArrayList<CommentRestaurantResponseDTO> getAllByRestaurantId(String restaurantId) {
        List<Comment> allByRestaurantId = commentRepository.findAllByRestaurantId(restaurantId);
        List<CommentRestaurantResponseDTO> allDTOSByRestaurantId = CommentMapper.INSTANCE.convertToCommentDTOsForRestaurant(allByRestaurantId);

        ArrayList<CommentRestaurantResponseDTO> arrayList = new ArrayList<>(allDTOSByRestaurantId);
        return arrayList;
    }
}