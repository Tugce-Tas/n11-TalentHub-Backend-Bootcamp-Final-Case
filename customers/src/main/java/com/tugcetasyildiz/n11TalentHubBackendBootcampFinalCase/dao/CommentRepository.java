package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByRestaurantId(String restaurantId);
}
