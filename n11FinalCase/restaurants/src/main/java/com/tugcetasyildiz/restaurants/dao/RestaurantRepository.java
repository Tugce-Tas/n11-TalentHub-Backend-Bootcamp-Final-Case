package com.tugcetasyildiz.restaurants.dao;

import com.tugcetasyildiz.restaurants.entity.Restaurant;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends SolrCrudRepository<Restaurant, String> {

    Optional<Restaurant> findById(String id);
    @Query("NAME:*?0*")
    List<Restaurant> findAllByNameContaining(String name);
    @Query("id:*?0* OR NAME:*?0*")
    List<Restaurant> findAllByCustom(String searchItem);
    List<Restaurant> findAllByAverageScoreAfter(Double score);
    List<Restaurant> findAllByAverageScoreBetween(Double min, Double max);

}
