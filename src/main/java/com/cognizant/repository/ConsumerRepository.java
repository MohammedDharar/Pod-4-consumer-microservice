package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Integer>{ //CHANGED TO Integer from Long
	public Consumer findByConsumerId(Integer consumerId);	//CHANGED TO Integer from Long
}
