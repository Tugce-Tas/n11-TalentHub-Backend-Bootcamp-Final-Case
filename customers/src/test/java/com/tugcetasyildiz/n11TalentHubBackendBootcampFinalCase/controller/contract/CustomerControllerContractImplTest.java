package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller.contract;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestConstants;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestDataGenerator;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CustomerService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.RestaurantSuggestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerContractImplTest {

    @Mock
    CustomerService customerService;
    @Mock
    RestaurantSuggestionService restaurantSuggestionService;

    @InjectMocks
    CustomerControllerContractImpl customerControllerContract;

    @Test
    void shouldSaveCustomer() {
        CustomerSaveRequest customerSaveRequest = TestDataGenerator.createCustomerSaveRequest();
        CustomerDTO customerDTO = TestDataGenerator.createCustomerDTO();

        when(customerService.save(any())).thenReturn(customerDTO);
        CustomerDTO result = customerControllerContract.save(customerSaveRequest);
        assertEquals(customerSaveRequest.getName() + " " + customerSaveRequest.getSurname(), result.getFullName());
        assertEquals(customerSaveRequest.getLongitude(), result.getLongitude());
        assertEquals(customerSaveRequest.getLatitude(), result.getLatitude());
    }

    @Test
    void shouldGetAll() {
        List<CustomerDTO> customerDTOList = TestDataGenerator.createCustomerDTOList();

        when(customerService.getAll()).thenReturn(customerDTOList);
        List<CustomerDTO> result = customerControllerContract.getAll();

        assertIterableEquals(customerDTOList, result);
    }

    @Test
    void shouldUpdateById() {
        CustomerUpdateRequest customerUpdateRequest =  TestDataGenerator.customerUpdateRequest();
        Long customerId = TestConstants.TEST_CUSTOMER_ID;
        CustomerDTO customerDTO = TestDataGenerator.createCustomerDTO();

        when(customerService.updateById(customerId,customerUpdateRequest)).thenReturn(customerDTO);
        CustomerDTO result = customerControllerContract.updateById(customerId, customerUpdateRequest );

        assertEquals(customerDTO, result);
    }

//    @Test
//    void shouldSuggestRestaurantsById() {
//        Long customerId = TestConstants.TEST_CUSTOMER_ID;
//        List<RestaurantDTO> restaurantDTOList = TestDataGenerator.createRestaurantDTOList();
//
//        when(restaurantSuggestionService.suggestRestaurants(customerId)).thenReturn(restaurantDTOList);
//        List<RestaurantDTO> result = customerControllerContract.suggestRestaurants(customerId);
//
//        assertIterableEquals(restaurantDTOList, result);
//    }

}
