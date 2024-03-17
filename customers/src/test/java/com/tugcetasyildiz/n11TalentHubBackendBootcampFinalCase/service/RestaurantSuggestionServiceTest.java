package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.RestaurantClientService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.InvalidCommentIdException;
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
    void shouldSuggestRestaurants_WhenValidCustomerId_ReturnsListOfRestaurants() {

        Long customerId = TestConstants.TEST_CUSTOMER_ID;
        Customer customer = TestDataGenerator.createCustomer();
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        RestaurantDTO restaurant = TestDataGenerator.createRestaurantDTO();
        when(restaurantClientService.getAllRestaurants()).thenReturn(List.of(restaurant));

        List<RestaurantDTO> suggestedRestaurants = restaurantSuggestionService.suggestRestaurants(customerId);

        assertNotNull(suggestedRestaurants);
    }

    @Test
    void suggestRestaurants_WhenInvalidCustomerId_ThrowsException() {
        Long invalidCustomerId = 999L;
        when(customerRepository.findById(invalidCustomerId)).thenReturn(Optional.empty());

        assertThrows(InvalidCommentIdException.class, () -> restaurantSuggestionService.suggestRestaurants(invalidCustomerId));
    }

    @Test
    void shouldGetRestaurantsCloserThan_WhenValidCustomerId_ReturnsEmptyList() {
        // Given
        Long customerId = TestConstants.TEST_CUSTOMER_ID;
        Customer customer = TestDataGenerator.createCustomer();
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        List<RestaurantDTO> restaurantDTOList = Collections.emptyList();
        when(restaurantClientService.getAllRestaurants()).thenReturn(restaurantDTOList);

        List<RestaurantDTO> restaurantsCloserThan = restaurantSuggestionService.getRestaurantsCloserThan(customerId, 10.0);

        assertEquals(restaurantDTOList, restaurantsCloserThan);
        assertEquals(0, restaurantsCloserThan.size());

    }

    @Test
    void shouldGetRestaurantsCloserThan_WhenInvalidCustomerId_ThrowsException() {
        // Given
        Long invalidCustomerId = 999L;
        when(customerRepository.findById(invalidCustomerId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> restaurantSuggestionService.getRestaurantsCloserThan(invalidCustomerId, 10.0));
    }
}

