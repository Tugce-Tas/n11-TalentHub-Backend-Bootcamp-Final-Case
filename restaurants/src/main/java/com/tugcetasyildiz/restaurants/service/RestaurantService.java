package com.tugcetasyildiz.restaurants.service;

import com.tugcetasyildiz.restaurants.client.model.CommentRestaurantResponseDTO;
import com.tugcetasyildiz.restaurants.dao.RestaurantRepository;
import com.tugcetasyildiz.restaurants.dto.RestaurantDTO;
import com.tugcetasyildiz.restaurants.entity.Restaurant;
import com.tugcetasyildiz.restaurants.exceptionhandling.exception.InvalidRestaurantIdException;
import com.tugcetasyildiz.restaurants.exceptionhandling.message.EnumErrorMessage;
import com.tugcetasyildiz.restaurants.mapper.RestaurantMapper;
import com.tugcetasyildiz.restaurants.request.RestaurantSaveRequest;
import com.tugcetasyildiz.restaurants.request.RestaurantUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantDTO save(RestaurantSaveRequest saveRequest) {
        Restaurant entity = RestaurantMapper.INSTANCE.convertToEntity(saveRequest);
        restaurantRepository.save(entity);
        return RestaurantMapper.INSTANCE.convertToDTO(entity);
    }

    public Iterable<RestaurantDTO> getAll() {
        return RestaurantMapper.INSTANCE.convertToDTOs(restaurantRepository.findAll());
    }

    public RestaurantDTO updateById(String restaurantId, RestaurantUpdateRequest updateRequest) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (Objects.isNull(restaurant)) {
            throw new InvalidRestaurantIdException(EnumErrorMessage.INVALID_RESTAURANT_ID);
        }
        restaurant.setName(updateRequest.getName());
        restaurant.setLongitude(updateRequest.getLongitude());
        restaurant.setLatitude(updateRequest.getLatitude());
        restaurantRepository.save(restaurant);

        return  RestaurantMapper.INSTANCE.convertToDTO(restaurant);
    }

    public void deleteById(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (Objects.isNull(restaurant)) {
            throw new InvalidRestaurantIdException(EnumErrorMessage.INVALID_RESTAURANT_ID);
        }
        restaurantRepository.deleteById(restaurantId);
    }

    public void updateCommentsAndScore(String restaurantId, ArrayList<CommentRestaurantResponseDTO> commentDTOList) {

        double totalScore = commentDTOList.stream()
                .mapToDouble(comment -> comment.getScore().getValue())
                .sum();

        int commentCount = commentDTOList.size();
        double averageScore = commentCount > 0 ? totalScore / commentCount : 0.0;

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (Objects.nonNull(restaurant)) {
            restaurant.setAverageScore(averageScore);
            restaurant.setCommentList(commentDTOList);
            restaurantRepository.save(restaurant);
        }
    }

    public RestaurantDTO getRestaurantById(String restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        return RestaurantMapper.INSTANCE.convertToDTO(restaurant);
    }

    public Iterable<RestaurantDTO> getRestaurantByScoreGreaterThan(Double score) {
        Iterable<Restaurant> allByAverageScoreAfter = restaurantRepository.findAllByAverageScoreAfter(score);
        return RestaurantMapper.INSTANCE.convertToDTOs(allByAverageScoreAfter);
    }

    public Iterable<RestaurantDTO> getRestaurantByScoreBetween(Double min, Double max) {
        Iterable<Restaurant> allByAverageScoreBetween = restaurantRepository.findAllByAverageScoreBetween(min, max);
        return RestaurantMapper.INSTANCE.convertToDTOs(allByAverageScoreBetween);
    }

    public Iterable<RestaurantDTO> getRestaurantsByCustom(String custom) {
        Iterable<Restaurant> allByCustom = restaurantRepository.findAllByCustom(custom);
        return RestaurantMapper.INSTANCE.convertToDTOs(allByCustom);
    }

    public Iterable<RestaurantDTO> getRestaurantsByNameContaining(String name) {
        Iterable<Restaurant> allByNameContaining = restaurantRepository.findAllByNameContaining(name);
        return RestaurantMapper.INSTANCE.convertToDTOs(allByNameContaining);
    }
}
