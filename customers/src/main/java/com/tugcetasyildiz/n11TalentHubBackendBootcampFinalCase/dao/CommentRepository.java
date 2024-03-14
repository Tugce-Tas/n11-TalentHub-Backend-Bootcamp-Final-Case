package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByRestaurantId(String restaurantId);
}
