package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dao;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
