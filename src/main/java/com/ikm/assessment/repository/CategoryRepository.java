package com.ikm.assessment.repository;

import com.ikm.assessment.model.CategoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDetails, UUID> {

}
