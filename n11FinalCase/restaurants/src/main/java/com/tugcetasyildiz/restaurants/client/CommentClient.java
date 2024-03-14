package com.tugcetasyildiz.restaurants.client;

import com.tugcetasyildiz.restaurants.client.model.CommentRestaurantResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="comment", url = "http://localhost:8080/api/v1/comments")
public interface CommentClient {

    @GetMapping
    List<CommentRestaurantResponseDTO> getAll();

    @GetMapping("/with-restaurant-id/{restaurantId}")
    List<CommentRestaurantResponseDTO> getAllByRestaurantId(@PathVariable String restaurantId);

}
