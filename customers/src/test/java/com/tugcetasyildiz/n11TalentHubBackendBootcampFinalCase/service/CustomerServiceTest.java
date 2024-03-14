package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestConstants;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestDataGenerator;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;
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
class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test
    void shouldSaveCustomer() {
        CustomerSaveRequest customerSaveRequest = TestDataGenerator.createCustomerSaveRequest();

        CustomerDTO result = customerService.save(customerSaveRequest);

        assertEquals(customerSaveRequest.getName() + " " + customerSaveRequest.getSurname(), result.getFullName());
        assertEquals(customerSaveRequest.getLongitude(), result.getLongitude());
        assertEquals(customerSaveRequest.getLatitude(), result.getLatitude());
    }

    @Test
    void shouldGetAll() {
        List<CustomerDTO> customerDTOList = TestDataGenerator.createCustomerDTOList();
        List<Customer> customerList = TestDataGenerator.createCustomerList();

        when(customerRepository.findAll()).thenReturn(customerList);
        List<CustomerDTO> result = customerService.getAll();

        assertEquals(customerDTOList, result);
    }

    @Test
    void shouldUpdateById() {
        CustomerUpdateRequest customerUpdateRequest = TestDataGenerator.customerUpdateRequest();
        Long customerId = TestConstants.TEST_CUSTOMER_ID;
        Customer customer = TestDataGenerator.createCustomer();

        when(customerRepository.findById(any())).thenReturn(Optional.of(customer));
        CustomerDTO result = customerService.updateById(customerId, customerUpdateRequest);

        assertEquals(customerUpdateRequest.getName() + " " + customerUpdateRequest.getSurname(), result.getFullName());
        assertEquals(customerUpdateRequest.getLatitude(), result.getLatitude());
        assertEquals(customerUpdateRequest.getLongitude(), result.getLongitude());
    }
}