package com.tugcetasyildiz.n11logger.request;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RequestLog {

    @Id
    @GeneratedValue(generator = "requestLog", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "requestLog", sequenceName = "REQUEST_LOG_ID_SEQ")
    private Long id;

    private LocalDateTime date;

    private String message;

    private String description;
}