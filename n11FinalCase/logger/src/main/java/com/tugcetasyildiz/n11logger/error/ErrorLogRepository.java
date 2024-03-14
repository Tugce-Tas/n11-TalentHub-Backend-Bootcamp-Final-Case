package com.tugcetasyildiz.n11logger.error;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {

}