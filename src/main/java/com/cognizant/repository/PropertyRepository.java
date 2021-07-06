package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Integer>{
	public Property findByBusinessId(Integer businessId);
}
