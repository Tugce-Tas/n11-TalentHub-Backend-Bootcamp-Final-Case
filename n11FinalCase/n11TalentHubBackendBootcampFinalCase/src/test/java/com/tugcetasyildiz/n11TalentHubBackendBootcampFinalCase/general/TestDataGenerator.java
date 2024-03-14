package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CustomerDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.saverequest.CustomerSaveRequest;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.request.updaterequest.CustomerUpdateRequest;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {
    public static List<CustomerDTO> createCustomerDTOList() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        CustomerDTO customerDTO = createCustomerDTO();
        CustomerDTO customerDTO2 = createCustomerDTO();

        customerDTOList.add(customerDTO);
        customerDTOList.add(customerDTO2);

        return customerDTOList;
    }
    public static CustomerDTO createCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFullName(TestConstants.TEST_CUSTOMER_NAME + " " + TestConstants.TEST_CUSTOMER_SURNAME);
        customerDTO.setLongitude(TestConstants.TEST_CUSTOMER_LONGITUDE);
        customerDTO.setLatitude(TestConstants.TEST_CUSTOMER_LATITUDE);
        return customerDTO;
    }

    public static Customer createCustomer() {
        Customer customer = new Customer();
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

//    public static List<RestaurantDTO> createRestaurantDTOList() {
//        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
//
//        RestaurantDTO restaurantDTO = createRestaurantDTO();
//        RestaurantDTO restaurantDTO2 = createRestaurantDTO();
//        RestaurantDTO restaurantDTO3 = createRestaurantDTO();
//
//        restaurantDTOList.add(restaurantDTO);
//        restaurantDTOList.add(restaurantDTO2);
//        restaurantDTOList.add(restaurantDTO3);
//
//        return restaurantDTOList;
//    }

////////////////////////////////////////////////////////////////////////////////////

//    public static RestaurantDTO createRestaurantDTO() {
//        RestaurantDTO restaurantDTO = new RestaurantDTO();
//        restaurantDTO.setName(TestConstants.TEST_RESTAURANT_NAME);
//        restaurantDTO.setLongitude(TestConstants.TEST_RESTAURANT_LONGITUDE);
//        restaurantDTO.setLatitude(TestConstants.TEST_RESTAURANT_LATITUDE);
//        return restaurantDTO;
//    }
}
