package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.RestaurantClientService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CommentRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestConstants;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestDataGenerator;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CommentSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CommentUpdateRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    CommentRepository commentRepository;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    RestaurantClientService restaurantClientService;

    @InjectMocks
    CommentService commentService;

    @Test
    void shouldSaveComment() {
        CommentSaveRequest commentSaveRequest = TestDataGenerator.createCommentSaveRequest();
        Customer customer = TestDataGenerator.createCustomer();
        RestaurantDTO restaurant = TestDataGenerator.createRestaurantDTO();

        when(customerRepository.findById(any())).thenReturn(Optional.of(customer));
        when(restaurantClientService.getRestaurantById(any())).thenReturn(restaurant);
        CommentDTO result = commentService.save(commentSaveRequest);

        assertEquals(commentSaveRequest.getScore(), result.getScore());
        assertEquals(commentSaveRequest.getText(), result.getText());
        assertEquals(customer.getName() + " " + customer.getSurname(), result.getCustomerName());
        assertEquals(commentSaveRequest.getRestaurantId(), result.getRestaurantId());
    }

    @Test
    void shouldGetAll() {
        List<CommentDTO> commentDTOList = TestDataGenerator.createCommentDTOList();
        List<Comment> commentList = TestDataGenerator.createCommentList();

        when(commentRepository.findAll()).thenReturn(commentList);
        List<CommentDTO> result = commentService.getAll();

        assertEquals(commentDTOList, result);
    }

    @Test
    void shouldUpdateById() {
        CommentUpdateRequest commentUpdateRequest = TestDataGenerator.createCommentUpdateRequest();
        Long commentId = TestConstants.TEST_COMMENT_ID;
        Comment comment = TestDataGenerator.createComment();

        when(commentRepository.findById(any())).thenReturn(Optional.of(comment));
        CommentDTO result = commentService.updateById(commentId, commentUpdateRequest);

        assertEquals(commentUpdateRequest.getScore(), result.getScore());
        assertEquals(commentUpdateRequest.getText(), result.getText());
    }
}