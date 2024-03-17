package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.entity.Comment;
import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "CUSTOMER")
@ToString(exclude = "commentList")
public class Customer extends BaseEntity {

    @SequenceGenerator(name = "customer", sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer")
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 50, min = 2)
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @NotBlank
    @Size(max = 50, min = 2)
    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;

    @NotBlank
    @Positive
    @Column(name = "LONGITUDE", nullable = false)
    private Double longitude;

    @NotBlank
    @Positive
    @Column(name = "LATITUDE", nullable = false)
    private Double latitude;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Comment> commentList;
}
