package com.tugcetasyildiz.restaurants.controller;

import com.tugcetasyildiz.restaurants.client.model.CommentRestaurantResponseDTO;
import com.tugcetasyildiz.restaurants.dto.RestaurantDTO;
import com.tugcetasyildiz.restaurants.request.RestaurantSaveRequest;
import com.tugcetasyildiz.restaurants.request.RestaurantUpdateRequest;
import com.tugcetasyildiz.restaurants.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<Iterable<RestaurantDTO>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAll()) ;
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable String restaurantId) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(restaurantId));
    }

    @GetMapping("/by-score/greater-than/{score}")
    public ResponseEntity<Iterable<RestaurantDTO>> getRestaurantsByScoreGreaterThan(@PathVariable Double score) {
        return ResponseEntity.ok(restaurantService.getRestaurantByScoreGreaterThan(score));
    }


    @GetMapping("/name-containing/{name}")
    public ResponseEntity<Iterable<RestaurantDTO>> getRestaurantsByNameContaining(@PathVariable String name) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByNameContaining(name));
    }

    @GetMapping("/containing/{custom}")
    public ResponseEntity<Iterable<RestaurantDTO>> getRestaurantsByCustom(@PathVariable String custom) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByCustom(custom));
    }

    @GetMapping("/by-score/between/{min}-{max}")
    public ResponseEntity<Iterable<RestaurantDTO>> getRestaurantsByScoreBetween(@PathVariable Double min, @PathVariable Double max) {
        return ResponseEntity.ok(restaurantService.getRestaurantByScoreBetween(min, max));
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantSaveRequest restaurantSaveRequest) {
        RestaurantDTO saved = restaurantService.save(restaurantSaveRequest);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{restaurantId}/score-and-comments")
    public void updateCommentsAndScore(@PathVariable String restaurantId, @RequestBody ArrayList<CommentRestaurantResponseDTO> commentDTOList) {
        restaurantService.updateCommentsAndScore(restaurantId, commentDTOList);
    }

    @PutMapping ("/{restaurantId}")
    public ResponseEntity<RestaurantDTO> updateRestaurantById(@PathVariable String restaurantId, @RequestBody RestaurantUpdateRequest restaurantUpdateRequest) {
        return ResponseEntity.ok(restaurantService.updateById(restaurantId, restaurantUpdateRequest)) ;
    }

    @DeleteMapping("/{restaurantId}")
    public void deleteRestaurantById(@PathVariable String restaurantId) {
        restaurantService.deleteById(restaurantId);
    }



}
