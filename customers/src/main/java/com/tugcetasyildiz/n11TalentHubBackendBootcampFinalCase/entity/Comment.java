package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.enums.EnumScore;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "COMMENT")
public class Comment extends BaseEntity {

    @SequenceGenerator(name = "comment", sequenceName = "COMMENT_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment")
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 250)
    @Column(name = "TEXT", length = 250)
    private String text;

    @NotBlank
    @Column(name = "SCORE",  nullable = false)
    private EnumScore score;

    @NotBlank
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID",  nullable = false)
    private Customer customer;

    @Column(name = "RESTAURANT_ID",  nullable = false)
    private String restaurantId;

}
