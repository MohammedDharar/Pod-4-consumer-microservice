package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.ConsumerBusinessNotfoundException;
import com.cognizant.exception.ConsumerPropertyException;
import com.cognizant.feign.AuthorisationClient;
import com.cognizant.model.Business;
import com.cognizant.model.Consumer;
import com.cognizant.model.Property;
import com.cognizant.pojo.ConsumerPojo;
import com.cognizant.service.ConsumerMicroservicesImpl;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
@RestController
@Slf4j
@RequestMapping("/consumer")
@CrossOrigin(origins="http://localhost:4200")
public class ConsumerController {
	
	private ConsumerMicroservicesImpl consumerMicroservicesImpl;
	
	public ConsumerController(ConsumerMicroservicesImpl consumerMicroservicesImpl) {
	this.consumerMicroservicesImpl=consumerMicroservicesImpl;	
	}
	
	@Autowired
	private AuthorisationClient authorisationClient;

	/*
	 * need -----Exception change in post ones
	 */
	@PostMapping("/createConsumerbusiness")
	@ApiOperation(value = "createConsumerbusiness", notes = "Creates business and consumer", httpMethod = "POST", response = String.class)
	public ConsumerPojo createConsumerbusiness(@RequestHeader(name = "Authorization") String token,
			@RequestBody ConsumerPojo consumerPojo) throws ConsumerBusinessNotfoundException {
		log.info("start of createConsumerbusiness()");
		if (authorisationClient.validate(token)) {
			consumerMicroservicesImpl.createConsumerBusiness(consumerPojo);
			log.debug("consumerPojo: {}", consumerPojo);
			String s= "Consumer business Details Saved and Added!";
			return consumerPojo;
		} else {
			throw new ConsumerBusinessNotfoundException("C4-Consumer Business Not Created.");
		}
	}

	@PostMapping("/updateConsumerbusiness")
	@ApiOperation(value = "updateConsumerbusiness", notes = "updates the details of consumer business", httpMethod = "POST", response = String.class)
	public ConsumerPojo updateConsumerbusiness(@RequestHeader(name = "Authorization") String token,
			@RequestBody ConsumerPojo consumerPojo) throws ConsumerBusinessNotfoundException {
		log.info("start of updateConsumerbusiness()");
		if (authorisationClient.validate(token)) {
			consumerMicroservicesImpl.updateConsumerBusiness(consumerPojo);
			log.debug("updated consumerPojo: {}", consumerPojo);
			return consumerPojo;
		} else {
			throw new ConsumerBusinessNotfoundException("C5-Consumer Business Not Updated.");
		}
	}

	@PostMapping("/createbusinessProperty")
	@ApiOperation(value = "createbusinessProperty", notes = "adds the details of business property", httpMethod = "POST", response = String.class)
	public Property createbusinessProperty(@RequestHeader(name = "Authorization") String token,
			@RequestBody Property propertyPojo) throws ConsumerPropertyException {
		log.info("start of createbusinessProperty()");
		log.debug("propertyPojo: {}", propertyPojo);
		if (authorisationClient.validate(token)) {
			consumerMicroservicesImpl.createBusinessProperty(propertyPojo);
			return propertyPojo;
		} else {
			throw new ConsumerPropertyException("C6-Consumer Property Not Created.");
		}
	}

	@PostMapping("/updatebusinessProperty")
	@ApiOperation(value = "updatebusinessProperty", notes = "Updates the details of Consumer Business Property", httpMethod = "POST", response = String.class)
	public Property updatebusinessProperty(@RequestHeader(name = "Authorization") String token,
			@RequestBody Property propertyPojo) throws ConsumerPropertyException {
		log.info("start of updatebusinessProperty()");
		if (authorisationClient.validate(token)) {
			consumerMicroservicesImpl.updateBusinessProperty(propertyPojo);
			log.debug("updated propertyPojo: {}", propertyPojo);
			return propertyPojo;
		} else {
			throw new ConsumerPropertyException("C7-Consumer Property Not Updated.");
		}
	}

	@GetMapping("/viewConsumerBusiness/{consumerId}")
	@ApiOperation(value = "viewConsumerBusiness", notes = "get the details of Consumer and Consumer Business", httpMethod = "GET", response = ConsumerPojo.class)
	public ConsumerPojo viewConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@PathVariable Integer consumerId) throws ConsumerBusinessNotfoundException {
		log.info("start of viewConsumerBusiness()");
		if (authorisationClient.validate(token)) {
			ConsumerPojo consumerPojo = consumerMicroservicesImpl.viewConsumerBusiness(consumerId);
			return consumerPojo;
		} else {
			throw new ConsumerBusinessNotfoundException("C8-Consumer Business Not Found.");
		}
	}

	/*
	 * Below code is created for policy
	 */

	// policy---need
	@GetMapping("/viewbusinessProperty/{businessId}")
	@ApiOperation(value = "viewbusinessProperty", notes = "get the details of Business property and sends it to policy microservice", httpMethod = "GET", response = Property.class)
	public Property viewbusinessProperty(@RequestHeader(name = "Authorization") String token,
			@PathVariable Integer businessId) throws ConsumerPropertyException {
		log.info("start of viewbusinessProperty()");
		if (authorisationClient.validate(token)) {
			return consumerMicroservicesImpl.viewBusinessProperty(businessId);
		} else {
			throw new ConsumerPropertyException("C9-Consumer Business Property Not Found.");
		}

	}

	// policy---need
	@GetMapping("/viewbusiness/{businessId}")
	@ApiOperation(value = "viewbusiness", notes = "get the details of Consumer Business and sends it to Policy MicroService", httpMethod = "GET", response = Business.class)
	public Business viewbusiness(@RequestHeader(name = "Authorization") String token, @PathVariable Integer businessId)
			throws ConsumerBusinessNotfoundException {
		log.info("start of viewbusiness()");
		if (authorisationClient.validate(token)) {
			return consumerMicroservicesImpl.viewBusiness(businessId);
		} else {
			throw new ConsumerBusinessNotfoundException("C10-Consumer Business Not Found.");
		}

	}

	// policy---need
	@GetMapping("/viewConsumer/{consumerId}")
	@ApiOperation(value = "viewConsumer", notes = "get the details of Consumer and send it policy microservice", httpMethod = "GET", response = Consumer.class)
	public Consumer viewConsumer(@RequestHeader(name = "Authorization") String token, @PathVariable Integer consumerId)
			throws ConsumerBusinessNotfoundException {
		log.info("start of viewConsumer()");
		if (authorisationClient.validate(token)) {
			return consumerMicroservicesImpl.viewConsumer(consumerId);
		} else {
			throw new ConsumerBusinessNotfoundException("C11-Consumer Not Found.");
		}
	}
}
