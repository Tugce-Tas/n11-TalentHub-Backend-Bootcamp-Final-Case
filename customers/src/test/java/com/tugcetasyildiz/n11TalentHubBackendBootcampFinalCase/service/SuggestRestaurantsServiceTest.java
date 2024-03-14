package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.RestaurantClientService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.InvalidCommentIdException;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.message.EnumErrorMessage;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestConstants;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantSuggestionServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private RestaurantClientService restaurantClientService;

    @InjectMocks
    private RestaurantSuggestionService restaurantSuggestionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void suggestRestaurants_WhenValidCustomerId_ReturnsListOfRestaurants() {

        // Given
        Long customerId = TestConstants.TEST_CUSTOMER_ID;
        Customer customer = TestDataGenerator.createCustomer();
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        RestaurantDTO restaurant = TestDataGenerator.createRestaurantDTO();
        when(restaurantClientService.getAllRestaurants()).thenReturn(List.of(restaurant));

        // When
        List<RestaurantDTO> suggestedRestaurants = restaurantSuggestionService.suggestRestaurants(customerId);

        // Then
        //assertNotNull(suggestedRestaurants);
        //assertEquals(1, suggestedRestaurants.size());
        //assertEquals(restaurant, suggestedRestaurants.get(0));
    }

    @Test
    void suggestRestaurants_WhenInvalidCustomerId_ThrowsException() {
        Long invalidCustomerId = 999L;
        when(customerRepository.findById(invalidCustomerId)).thenReturn(Optional.empty());

        assertThrows(InvalidCommentIdException.class, () -> restaurantSuggestionService.suggestRestaurants(invalidCustomerId));
    }

    @Test
    void getRestaurantsCloserThan_WhenValidCustomerId_ReturnsListOfRestaurants() {
        // Given
        Long customerId = TestConstants.TEST_CUSTOMER_ID;
        Customer customer = TestDataGenerator.createCustomer();
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        RestaurantDTO restaurant = TestDataGenerator.createRestaurantDTO();
        List<RestaurantDTO> restaurantDTOList = TestDataGenerator.createRestaurantDTOList();
        when(restaurantClientService.getAllRestaurants()).thenReturn(List.of(restaurant));

        // When
        List<RestaurantDTO> restaurantsCloserThan = restaurantSuggestionService.getRestaurantsCloserThan(customerId, 10.0);


        // Then
        assertEquals(restaurantDTOList, restaurantsCloserThan);
        //assertNotNull(restaurantsCloserThan);
        //assertFalse(restaurantsCloserThan.isEmpty());
        assertEquals(1, restaurantsCloserThan.size());
        assertEquals(restaurant, restaurantsCloserThan.get(0));

    }

    @Test
    void getRestaurantsCloserThan_WhenInvalidCustomerId_ThrowsException() {
        // Given
        Long invalidCustomerId = 999L;
        when(customerRepository.findById(invalidCustomerId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> restaurantSuggestionService.getRestaurantsCloserThan(invalidCustomerId, 10.0));
    }
}



//@ExtendWith(MockitoExtension.class)
//public class SuggestRestaurantsServiceTest {
//    @Mock
//    CustomerRepository customerRepository;
//    @Mock
//    RestaurantClientService restaurantClientService;
//    @InjectMocks
//    RestaurantSuggestionService restaurantSuggestionService;
//
//    @BeforeEach
//    public void setUp() {
//        Long customerId = TestConstants.TEST_CUSTOMER_ID;
//        when(customerRepository.findById(eq(customerId))).thenReturn(Optional.of(TestDataGenerator.createCustomer()));
//    }
//    @Test
//    void shouldSuggestRestaurantById() {
//
//        List<RestaurantDTO> restaurantDTOList = TestDataGenerator.createRestaurantDTOList();
//
//        when(restaurantClientService.getAllRestaurants()).thenReturn(restaurantDTOList);
//        when(restaurantSuggestionService.getRestaurantsCloserThan(anyLong(), anyDouble())).thenReturn(restaurantDTOList);
//        List<RestaurantDTO> result = restaurantSuggestionService.suggestRestaurants(TestConstants.TEST_CUSTOMER_ID);
//
//        assertIterableEquals(restaurantDTOList, result);
//   }
//}