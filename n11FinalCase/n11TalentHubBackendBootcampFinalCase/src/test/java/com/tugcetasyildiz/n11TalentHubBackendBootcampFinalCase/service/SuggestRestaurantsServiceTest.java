package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SuggestRestaurantsServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    RestaurantSuggestionService restaurantSuggestionService;

//    @Test
//    void shouldSuggestRestaurantById() {
//
//    }
}