package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.N11TalentHubBackendBootcampFinalCaseApplication;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestConstants;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestDataGenerator;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CommentSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CommentUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CommentService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CustomerService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.RestaurantSuggestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {
    @Mock
    CommentService commentService;
    @Mock
    RestaurantSuggestionService restaurantSuggestionService;
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CommentController commentController;

    @Test
    void shouldSaveCustomer() {
        CommentSaveRequest commentSaveRequest = TestDataGenerator.createCommentSaveRequest();
        CommentDTO commentDTO = TestDataGenerator.createCommentDTO();
        String customerName = TestConstants.TEST_CUSTOMER_NAME + " " + TestConstants.TEST_CUSTOMER_SURNAME;

        when(commentService.save(any())).thenReturn(commentDTO);
        CommentDTO result = commentService.save(commentSaveRequest);

        assertEquals(commentSaveRequest.getText(), result.getText());
        assertEquals(commentSaveRequest.getScore(), result.getScore());
        assertEquals(customerName, result.getCustomerName());
        assertEquals(commentSaveRequest.getRestaurantId(), result.getRestaurantId());
    }

    @Test
    void shouldGetAll() {
        List<CommentDTO> commentDTOList = TestDataGenerator.createCommentDTOList();

        when(commentService.getAll()).thenReturn(commentDTOList);
        List<CommentDTO> result = commentService.getAll();

        assertIterableEquals(commentDTOList, result);
    }

    @Test
    void shouldUpdateById() {
        CommentUpdateRequest commentUpdateRequest = TestDataGenerator.createCommentUpdateRequest();
        Long commentId = TestConstants.TEST_COMMENT_ID;
        CommentDTO commentDTO = TestDataGenerator.createCommentDTO();

        when(commentService.updateById(commentId, commentUpdateRequest)).thenReturn(commentDTO);
        CommentDTO result = commentService.updateById(commentId, commentUpdateRequest);

        assertEquals(commentDTO, result);
    }
}