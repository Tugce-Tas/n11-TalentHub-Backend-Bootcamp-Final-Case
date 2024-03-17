package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.client.model.RestaurantDTO;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantClientService {
    private final RestaurantClient restaurantClient;

    public List<RestaurantDTO> getAllRestaurants() {
        try {
            ResponseEntity<Iterable<RestaurantDTO>> response = restaurantClient.getAllRestaurants();
            return StreamSupport.stream(Objects.requireNonNull(response.getBody()).spliterator(), false)
                    .toList();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public RestaurantDTO getRestaurantById(String restaurantId) {
        try {
            return restaurantClient.getRestaurantById(restaurantId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public void updateRestaurantByCommentsAndScore(String restaurantId, List<CommentDTO> commentDTOList) {
        try {
            restaurantClient.updateCommentsAndScore(restaurantId,commentDTOList);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
