package com.cognizant.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.ConsumerBusinessNotfoundException;
import com.cognizant.exception.ConsumerPropertyException;
import com.cognizant.model.Business;
import com.cognizant.model.Consumer;
import com.cognizant.model.Property;
import com.cognizant.pojo.ConsumerPojo;
import com.cognizant.repository.BusinessRepository;
import com.cognizant.repository.ConsumerRepository;
import com.cognizant.repository.PropertyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerMicroservicesImpl implements ConsumerMicroservice {
	
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	
	/* TO CREATE AND ADD A CONSUMER - BUSSINESS DETAILS */
	public String createConsumerBusiness(ConsumerPojo consumerPojo) {
//		System.out.println("turnover:"+consumerPojo.getBusinessTurnOver());
		Integer businessValue=getBusinessValue(consumerPojo.getBusinessTurnOver(),consumerPojo.getCapitalInvested());
		log.info("start of createConsumerBusiness() of service class");
		log.debug("businessValue: {}", businessValue);
		
		Consumer consumer=new Consumer(consumerPojo.getFirstName(),consumerPojo.getLastName(),consumerPojo.getDob(),consumerPojo.getBusinessName(),consumerPojo.getPanDetails(),consumerPojo.getEmail(),consumerPojo.getPhone(),consumerPojo.getAddress(),consumerPojo.getAgentName(),consumerPojo.getAgentId());
		consumerRepository.save(consumer);

		Business business=new Business(consumer.getConsumerId(), consumerPojo.getBusinessId(),consumerPojo.getBusinessCategory(),consumerPojo.getBusinessTurnOver(),consumerPojo.getCapitalInvested(),consumerPojo.getTotalEmployees(),businessValue,consumerPojo.getBusinessAge());
		businessRepository.save(business);
		
		consumerPojo.setBusinessValue(businessValue);
		consumerPojo.setConsumerId(consumer.getConsumerId());
		log.info("END of createConsumerBusiness()");
		return "Data has been Saved!";
	}
	
	public Integer getBusinessValue(Long BusinessTurnOver,Long CapitalInvested) {
		if(BusinessTurnOver==0 || CapitalInvested==0 || (BusinessTurnOver==CapitalInvested)) {
			throw new NullPointerException("value is null in getBusinessValue");
		}
		int businessValue=(int) (BusinessTurnOver/CapitalInvested);
		return (int) Math.abs(Math.round(businessValue));
	}
	
	
	/* TO UPDATE THE CONSUMER BUSSINESS DETAILS */
	public String updateConsumerBusiness(ConsumerPojo consumerPojo){
		log.info("start of updateConsumerBusiness() of service class");
		Optional<Consumer> consumer=consumerRepository.findById(consumerPojo.getConsumerId());
		log.debug("consumer data before update: {}", consumer);
		
		Business business=businessRepository.findByConsumerId(consumerPojo.getConsumerId());
		log.debug("business data before update: {}", business);
		Integer businessValue=getBusinessValue(consumerPojo.getBusinessTurnOver(),consumerPojo.getCapitalInvested());
		consumerPojo.setBusinessValue(businessValue);
		
		consumer.get().setFirstName(consumerPojo.getFirstName());
		consumer.get().setLastName(consumerPojo.getLastName());
		consumer.get().setDob(consumerPojo.getDob());
		consumer.get().setBusinessName(consumerPojo.getBusinessName());
		consumer.get().setPanDetails(consumerPojo.getPanDetails());
		consumer.get().setEmail(consumerPojo.getEmail());
		consumer.get().setPhone(consumerPojo.getPhone());
		consumer.get().setAddress(consumerPojo.getAddress());
		consumer.get().setAgentName(consumerPojo.getAgentName());
		consumer.get().setAgentId(consumerPojo.getAgentId());
		
		consumerRepository.save(consumer.get());
		log.debug("consumer data after update: {}", consumer);
		
		business.setBusinessCategory(consumerPojo.getBusinessCategory());
		business.setBusinessTurnOver(consumerPojo.getBusinessTurnOver());
		business.setCapitalInvested(consumerPojo.getCapitalInvested());
		business.setTotalEmployees(consumerPojo.getTotalEmployees());
		business.setBusinessAge(consumerPojo.getBusinessAge());
		business.setBusinessValue(businessValue);
		
		businessRepository.save(business);
		log.debug("consumer data after update: {}", business);
		
		return "Updated for Consumer ID ";
	}
	
	/* CREATE BUSSINESS PROPERTY*/
	@Override
	public String createBusinessProperty(Property property) {
		log.info("start of createBusinessProperty() of service class");

		Long annualDepreciatonValue=getAnnualDepreciatonValue(property.getCostOfAsset(),property.getSalvageValue(),property.getUsefulLifeOfAsset());
		log.debug("annualDepreciatonValue: {}",annualDepreciatonValue);
		
		int propertyValue=getpropertyValue(annualDepreciatonValue);
		property.setAnnualDepreciationValue(annualDepreciatonValue);
		property.setPropertyValue(propertyValue);
//		System.out.println("PropertyValue: "+propertyValue);
		Property property1=new 
				  Property( property.getBusinessId(),
			    		   property.getInsuranceType(),
			    		   property.getPropertyType(),
			    		   annualDepreciatonValue,
			    		   propertyValue,
			    		   property.getBuildingsqft(),
			    		   property.getBuildingType(),
			    		   property.getBuildingAge(),
			    		   property.getCostOfAsset(),
			    		   property.getSalvageValue(),
			    		   property.getUsefulLifeOfAsset()
		    		   );
		
		propertyRepository.save(property1);
		
		return "Business Propert Data Saved!";
	}
	
	public Long getAnnualDepreciatonValue(Long costOfAsset,Long salvageValue,Integer usefulLifeOfAsset) {
		if(costOfAsset==0 || salvageValue==0 || usefulLifeOfAsset==0 || (costOfAsset==salvageValue)) {
			throw new NullPointerException("value is null in getPropertyValue()");
		}
		
		double annualDepreciatonValue=(double)((costOfAsset-salvageValue)/(usefulLifeOfAsset));
		
		return (Long) Math.abs(Math.round(annualDepreciatonValue));
	}
	
	
	public int getpropertyValue(Long annualDepreciatonValue) {
		int propertyValue=0;
		if(annualDepreciatonValue<40000)
			propertyValue=0;
		else if(annualDepreciatonValue>=40000 && annualDepreciatonValue<60000)
			propertyValue=1;
		else if(annualDepreciatonValue>=60000 && annualDepreciatonValue<80000)
			propertyValue=2;
		else if(annualDepreciatonValue>=80000 && annualDepreciatonValue<100000)
			propertyValue=3;
		else if(annualDepreciatonValue>=100000 && annualDepreciatonValue<120000)
			propertyValue=4;
		else if(annualDepreciatonValue>=120000 && annualDepreciatonValue<140000)
			propertyValue=5;
		else if(annualDepreciatonValue>=140000 && annualDepreciatonValue<160000)
			propertyValue=6;
		else if(annualDepreciatonValue>=160000 && annualDepreciatonValue<180000)
			propertyValue=7;
		else if(annualDepreciatonValue>=180000 && annualDepreciatonValue<200000)
			propertyValue=8;
		else if(annualDepreciatonValue>=200000 && annualDepreciatonValue<220000)
			propertyValue=9;
		else if(annualDepreciatonValue>=220000 && annualDepreciatonValue<240000)
			propertyValue=10;
		
		return propertyValue;
	}
	
	/* TO UPDATE THE PROPERTY DETAILS */
	
	@Override
	public String updateBusinessProperty(Property propertyPojo) {
		log.info("start of updateBusinessProperty() of service class");
		
		Property property=propertyRepository.findByBusinessId(propertyPojo.getBusinessId());
		log.debug("consumer data before update: {}", property);
		Long annualDepreciatonValue=getAnnualDepreciatonValue(propertyPojo.getCostOfAsset(),propertyPojo.getSalvageValue(),propertyPojo.getUsefulLifeOfAsset());
		int propertyValue=getpropertyValue(annualDepreciatonValue);
		
		property.setInsuranceType(propertyPojo.getInsuranceType());
		property.setPropertyType(propertyPojo.getPropertyType());
		property.setBuildingsqft(propertyPojo.getBuildingsqft());
		property.setBuildingType(propertyPojo.getBuildingType());
		property.setBuildingAge(propertyPojo.getBuildingAge());
		property.setCostOfAsset(propertyPojo.getCostOfAsset());
		property.setSalvageValue(propertyPojo.getSalvageValue());
		property.setAnnualDepreciationValue(annualDepreciatonValue);
		property.setPropertyValue(propertyValue);
		
		propertyPojo.setAnnualDepreciationValue(annualDepreciatonValue);
		propertyPojo.setPropertyValue(propertyValue);
		propertyRepository.save(property);
		log.debug("consumer data after update: {}", property);
		
		return "Updated for Business Property";
	}

	
	@Override
	public ConsumerPojo viewConsumerBusiness(Integer consumerId) throws ConsumerBusinessNotfoundException {
		// TODO Auto-generated method stub
		log.info("start of viewConsumerBusiness() of service class");
		
		Optional<Consumer> consumer=consumerRepository.findById(consumerId);	
		log.debug("consumer data: {}", consumer);
		
		if(consumer.isEmpty()) {
			throw new ConsumerBusinessNotfoundException("CS2- Consumer Not Found");
		}
		
		Business business=businessRepository.findByConsumerId(consumerId);
		log.debug("business data: {}", business);
		
		ConsumerPojo consumerPojo=new ConsumerPojo(consumer.get().getConsumerId(),
				consumer.get().getFirstName(),consumer.get().getLastName(),consumer.get().getDob(),consumer.get().getBusinessName(),
				consumer.get().getPanDetails(),consumer.get().getEmail(),consumer.get().getPhone(),consumer.get().getAddress(),consumer.get().getAgentName(),
				consumer.get().getAgentId(),business.getBusinessId(),business.getBusinessCategory(),business.getBusinessTurnOver(),
				business.getCapitalInvested(),business.getTotalEmployees(),business.getBusinessValue(),business.getBusinessAge());
		
		log.debug("consumerPojo data: {}", consumerPojo);
		
		return consumerPojo;
	}


	 /*
	  * Below code is created for policy
	  */ 
	//already done----policy need
	@Override
	public Property viewBusinessProperty(Integer businessId) throws ConsumerPropertyException {
		if(businessId==null) {
			throw new ConsumerPropertyException("CSP1-  Please Enter Valid Consumer ID.");
		}
		Property property=propertyRepository.findByBusinessId(businessId);
		if(property==null) {
			throw new ConsumerPropertyException("CSP2- property Not Found.");
		}
		return property;
	}
	
	
	//policy-----need
	@Override
	public Business viewBusiness(Integer businessId) throws ConsumerBusinessNotfoundException {
		if(businessId==null) {
			throw new ConsumerBusinessNotfoundException("CSP3- Please Enter Valid Business ID.");
		}
		Business business= businessRepository.findByBusinessId(businessId);	
		if(business==null) {
			throw new ConsumerBusinessNotfoundException("CSP4- Consumer's Business Not Found.");
		}
		return business;
	}
	
	//policy-----need
	@Override
		public Consumer viewConsumer(Integer consumerId) throws ConsumerBusinessNotfoundException {
		if(consumerId==null) {
			throw new ConsumerBusinessNotfoundException("CSP5- Please Enter Valid Consumer ID.");
		}
		Consumer consumer=consumerRepository.findByConsumerId(consumerId);	
			if(consumer==null) {
				throw new ConsumerBusinessNotfoundException("CSP6- Consumer Not Found.");
			}
			return consumer;
		}
	}