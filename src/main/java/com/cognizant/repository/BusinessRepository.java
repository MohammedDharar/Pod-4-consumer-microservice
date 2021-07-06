package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Integer>{ //CHANGED TO Integer from Long
	public Business findByConsumerId(Integer consumerId); //CHANGED TO Integer from Long
	public Business findByBusinessId(Integer businessId); //CHANGED TO Integer from Long
}
