package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentRestaurantResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name ="restaurant", url = "http://localhost:8089/api/v1/restaurants")
public interface RestaurantClient {

    @GetMapping
    ResponseEntity<Iterable<RestaurantDTO>> getAllRestaurants();

    @GetMapping("/{restaurantId}")
    RestaurantDTO getRestaurantById(@PathVariable String restaurantId);

    @PostMapping("/{restaurantId}/score-and-comments")
    void updateCommentsAndScore(@PathVariable String restaurantId, @RequestBody ArrayList<CommentRestaurantResponseDTO> commentDTOList);
}
