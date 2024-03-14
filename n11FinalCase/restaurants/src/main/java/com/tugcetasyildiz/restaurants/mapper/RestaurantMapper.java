package com.tugcetasyildiz.restaurants.mapper;

import com.tugcetasyildiz.restaurants.dto.RestaurantDTO;
import com.tugcetasyildiz.restaurants.entity.Restaurant;
import com.tugcetasyildiz.restaurants.request.RestaurantSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    RestaurantDTO convertToDTO(Restaurant restaurant);
    Iterable<RestaurantDTO> convertToDTOs(Iterable<Restaurant> restaurantList);
    Restaurant convertToEntity(RestaurantSaveRequest restaurantSaveRequest);

}
