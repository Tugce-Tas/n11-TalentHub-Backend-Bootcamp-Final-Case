package com.tugcetasyildiz.restaurants.client;

import com.tugcetasyildiz.restaurants.client.model.CommentDTO;
import com.tugcetasyildiz.restaurants.dao.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentClientService {
    private final CommentClient commentClient;
    private final RestaurantRepository restaurantRepository;

    public List<CommentDTO> getAllRestaurants() {
        try {
        return commentClient.getAll();

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
    public List<CommentDTO> getAllByRestaurantId(String restaurantId) {
        return commentClient.getAllByRestaurantId(restaurantId);
    }

}
