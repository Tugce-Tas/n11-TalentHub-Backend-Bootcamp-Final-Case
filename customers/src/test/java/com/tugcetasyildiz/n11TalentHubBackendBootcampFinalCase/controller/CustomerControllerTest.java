package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.controller;


import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestConstants;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestDataGenerator;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service.CustomerService;
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
class CustomerControllerTest {
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;

    @Test
    void shouldSaveCustomer() {
        CustomerSaveRequest customerSaveRequest = TestDataGenerator.createCustomerSaveRequest();
        CustomerDTO customerDTO = TestDataGenerator.createCustomerDTO();

        when(customerService.save(any())).thenReturn(customerDTO);
        CustomerDTO result = customerService.save(customerSaveRequest);

        assertEquals(customerSaveRequest.getName() + " " + customerSaveRequest.getSurname(), result.getFullName());
        assertEquals(customerSaveRequest.getLongitude(), result.getLongitude());
        assertEquals(customerSaveRequest.getLatitude(), result.getLatitude());
    }

    @Test
    void shouldGetAll() {
        List<CustomerDTO> customerDTOList = TestDataGenerator.createCustomerDTOList();

        when(customerService.getAll()).thenReturn(customerDTOList);
        List<CustomerDTO> result = customerService.getAll();

        assertIterableEquals(customerDTOList, result);
    }

    @Test
    void shouldUpdateById() {
        CustomerUpdateRequest customerUpdateRequest = TestDataGenerator.customerUpdateRequest();
        Long customerId = TestConstants.TEST_CUSTOMER_ID;
        CustomerDTO customerDTO = TestDataGenerator.createCustomerDTO();

        when(customerService.updateById(customerId, customerUpdateRequest)).thenReturn(customerDTO);
        CustomerDTO result = customerService.updateById(customerId, customerUpdateRequest);

        assertEquals(customerDTO, result);
    }
}