package com.ikm.assessment.repository;

import com.ikm.assessment.model.ShopDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShopRepository extends JpaRepository<ShopDetails, UUID> {
    boolean existsByRegistrationNumber(String registrationNumber);


}
