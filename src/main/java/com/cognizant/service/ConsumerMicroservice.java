package com.cognizant.service;

import com.cognizant.exception.ConsumerBusinessNotfoundException;
import com.cognizant.exception.ConsumerPropertyException;
import com.cognizant.model.Business;
import com.cognizant.model.Consumer;
import com.cognizant.model.Property;
import com.cognizant.pojo.ConsumerPojo;

public interface ConsumerMicroservice {
	public String createConsumerBusiness(ConsumerPojo consumerPojo);

	public String updateConsumerBusiness(ConsumerPojo consumerPojo);

	public String createBusinessProperty(Property property);

	public String updateBusinessProperty(Property propertyPojo);

	public ConsumerPojo viewConsumerBusiness(Integer consumerId) throws ConsumerBusinessNotfoundException;

	public Property viewBusinessProperty(Integer businessId) throws ConsumerPropertyException;

	public Business viewBusiness(Integer businessId) throws ConsumerBusinessNotfoundException;
//
	public Consumer viewConsumer(Integer consumerId) throws ConsumerBusinessNotfoundException;
}