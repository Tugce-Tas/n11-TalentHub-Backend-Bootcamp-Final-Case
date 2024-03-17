package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.service;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.RestaurantClientService;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao.CustomerRepository;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.InvalidCommentIdException;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.exception.InvalidCustomerIdException;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.exceptionhandling.message.EnumErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RestaurantSuggestionService {
    public static final double RADIUS_OF_EARTH = 6371;

    private final CustomerRepository customerRepository;
    private final RestaurantClientService restaurantClientService;

    public List<RestaurantDTO> suggestRestaurants(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (Objects.isNull(customer)) {
            throw new InvalidCommentIdException(EnumErrorMessage.INVALID_CUSTOMER_ID);
        }
        Map<RestaurantDTO, Double> restaurantsAndScores = new HashMap<>();

        getRestaurantsCloserThan(customerId, 10.0)
                .forEach(restaurant -> restaurantsAndScores.put(restaurant, getScore(customer, restaurant)));

        return restaurantsAndScores.entrySet().stream()
                .sorted(Map.Entry.<RestaurantDTO, Double>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    protected List<RestaurantDTO> getRestaurantsCloserThan(Long customerId, Double maxDistance) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (Objects.isNull(customer)) {
            throw new InvalidCustomerIdException(EnumErrorMessage.INVALID_CUSTOMER_ID);
        }
        List<RestaurantDTO> restaurantList = restaurantClientService.getAllRestaurants();

        return restaurantList.stream().filter(
                        restaurant -> calculateDistance(customer, restaurant) < maxDistance)
                .toList();
    }

    protected static Double calculateDistance(Customer customer, RestaurantDTO restaurant) {

        double latDistance = Math.toRadians(customer.getLatitude() - restaurant.getLatitude());
        double lonDistance = Math.toRadians(customer.getLongitude() - restaurant.getLongitude());

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(customer.getLatitude())) * Math.cos(restaurant.getLatitude())
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIUS_OF_EARTH * c;
    }

    protected Double getScore(Customer customer, RestaurantDTO restaurant) {
        double proximityScore = (10 - calculateDistance(customer, restaurant)) ;
        double commentScore = (restaurant.getAverageScore()) * 2;
        return (proximityScore * 0.3) + (commentScore * 0.7);
    }

}

