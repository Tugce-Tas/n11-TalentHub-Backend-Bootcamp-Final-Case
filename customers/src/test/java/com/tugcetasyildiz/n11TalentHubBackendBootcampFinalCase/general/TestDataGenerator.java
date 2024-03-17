package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CommentSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CommentUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {
    public static CustomerDTO createCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(TestConstants.TEST_CUSTOMER_ID);
        customerDTO.setFullName(TestConstants.TEST_CUSTOMER_NAME + " " + TestConstants.TEST_CUSTOMER_SURNAME);
        customerDTO.setLongitude(TestConstants.TEST_CUSTOMER_LONGITUDE);
        customerDTO.setLatitude(TestConstants.TEST_CUSTOMER_LATITUDE);
        return customerDTO;
    }

    public static List<CustomerDTO> createCustomerDTOList() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        CustomerDTO customerDTO = createCustomerDTO();
        CustomerDTO customerDTO2 = createCustomerDTO();

        customerDTOList.add(customerDTO);
        customerDTOList.add(customerDTO2);

        return customerDTOList;
    }

    public static Customer createCustomer() {
        Customer customer = new Customer();
        customer.setId(TestConstants.TEST_CUSTOMER_ID);
        customer.setName(TestConstants.TEST_CUSTOMER_NAME);
        customer.setSurname(TestConstants.TEST_CUSTOMER_SURNAME);
        customer.setLongitude(TestConstants.TEST_CUSTOMER_LONGITUDE);
        customer.setLatitude(TestConstants.TEST_CUSTOMER_LATITUDE);
        return customer;
    }

    public static List<Customer> createCustomerList() {
        List<Customer> customerList = new ArrayList<>();

        Customer customer = createCustomer();
        Customer customer2 = createCustomer();

        customerList.add(customer);
        customerList.add(customer2);

        return customerList;
    }

    public static CustomerSaveRequest createCustomerSaveRequest() {
        CustomerSaveRequest customerSaveRequest = new CustomerSaveRequest();
        customerSaveRequest.setName(TestConstants.TEST_CUSTOMER_NAME);
        customerSaveRequest.setSurname(TestConstants.TEST_CUSTOMER_SURNAME);
        customerSaveRequest.setLongitude(TestConstants.TEST_CUSTOMER_LONGITUDE);
        customerSaveRequest.setLatitude(TestConstants.TEST_CUSTOMER_LATITUDE);
        return customerSaveRequest;
    }

    public static CustomerUpdateRequest customerUpdateRequest(){
        CustomerUpdateRequest customerUpdateRequest = new CustomerUpdateRequest();
        customerUpdateRequest.setName(TestConstants.TEST_CUSTOMER_NAME);
        customerUpdateRequest.setSurname(TestConstants.TEST_CUSTOMER_SURNAME);
        customerUpdateRequest.setLongitude(TestConstants.TEST_CUSTOMER_LONGITUDE);
        customerUpdateRequest.setLatitude(TestConstants.TEST_CUSTOMER_LATITUDE);
        return customerUpdateRequest;
    }

    public static RestaurantDTO createRestaurantDTO() {
        RestaurantDTO restaurantDTO = RestaurantDTO.builder().build();
        restaurantDTO.setId(TestConstants.TEST_RESTAURANT_ID);
        restaurantDTO.setName(TestConstants.TEST_RESTAURANT_NAME);
        restaurantDTO.setLongitude(TestConstants.TEST_RESTAURANT_LONGITUDE);
        restaurantDTO.setLatitude(TestConstants.TEST_RESTAURANT_LATITUDE);
        return restaurantDTO;
    }

    public static List<RestaurantDTO> createRestaurantDTOList() {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();

        RestaurantDTO restaurantDTO = createRestaurantDTO();
        RestaurantDTO restaurantDTO2 = createRestaurantDTO();
        RestaurantDTO restaurantDTO3 = createRestaurantDTO();

        restaurantDTOList.add(restaurantDTO);
        restaurantDTOList.add(restaurantDTO2);
        restaurantDTOList.add(restaurantDTO3);

        return restaurantDTOList;
    }

    public static CommentSaveRequest createCommentSaveRequest() {
        CommentSaveRequest commentSaveRequest = new CommentSaveRequest();
        commentSaveRequest.setScore(TestConstants.TEST_COMMENT_SCORE);
        commentSaveRequest.setText(TestConstants.TEST_COMMENT_TEXT);
        commentSaveRequest.setCustomerId(TestConstants.TEST_CUSTOMER_ID);
        commentSaveRequest.setRestaurantId(TestConstants.TEST_RESTAURANT_ID);
        return commentSaveRequest;
    }

    public static CommentUpdateRequest createCommentUpdateRequest() {
        CommentUpdateRequest commentUpdateRequest = new CommentUpdateRequest();
        commentUpdateRequest.setScore(TestConstants.TEST_COMMENT_SCORE);
        commentUpdateRequest.setText(TestConstants.TEST_COMMENT_TEXT);
        return commentUpdateRequest;
    }

    public static CommentDTO createCommentDTO() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(TestConstants.TEST_COMMENT_ID);
        commentDTO.setCustomerId(TestConstants.TEST_CUSTOMER_ID);
        commentDTO.setScore(TestConstants.TEST_COMMENT_SCORE);
        commentDTO.setText(TestConstants.TEST_COMMENT_TEXT);
        commentDTO.setCustomerName(TestConstants.TEST_CUSTOMER_NAME + " " + TestConstants.TEST_CUSTOMER_SURNAME);
        commentDTO.setRestaurantId(TestConstants.TEST_RESTAURANT_ID);
        return commentDTO;
    }

    public static List<CommentDTO> createCommentDTOList() {
        List<CommentDTO> commentDTOList = new ArrayList<>();

        CommentDTO commentDTO = createCommentDTO();
        CommentDTO commentDTO2 = createCommentDTO();
        CommentDTO commentDTO3 = createCommentDTO();

        commentDTOList.add(commentDTO);
        commentDTOList.add(commentDTO2);
        commentDTOList.add(commentDTO3);

        return commentDTOList;
    }

    public static Comment createComment() {
        Comment comment = new Comment();
        comment.setId(TestConstants.TEST_COMMENT_ID);
        comment.setText(TestConstants.TEST_COMMENT_TEXT);
        comment.setScore(TestConstants.TEST_COMMENT_SCORE);
        comment.setRestaurantId(TestConstants.TEST_RESTAURANT_ID);
        comment.setCustomer(createCustomer());
        return comment;
    }

    public static List<Comment> createCommentList() {
        List<Comment> commentList = new ArrayList<>();

        Comment comment = createComment();
        Comment comment2 = createComment();
        Comment comment3 = createComment();

        commentList.add(comment);
        commentList.add(comment2);
        commentList.add(comment3);

        return commentList;
    }
}
