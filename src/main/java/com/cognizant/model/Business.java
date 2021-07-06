package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="business")
//@Getter
//@Setter
//@NoArgsConstructor
@ApiModel(description = "Model Class for the consumer's Business Details")
public class Business {
	public Business() {}
	public Business(Integer consumerId,Integer businessId,String businessCategory,Long businessTurnOver,
			Long capitalInvested, Integer totalEmployees,Integer businessValue, Integer businessAge) {
		super();
		this.consumerId=consumerId;
		this.businessId=businessId;
		this.businessCategory = businessCategory;
		this.businessTurnOver = businessTurnOver;
		this.capitalInvested = capitalInvested;
		this.totalEmployees = totalEmployees;
		this.businessValue=businessValue;
		this.businessAge = businessAge;
	}

	@Id
	@Column(name="businessId")
	@ApiModelProperty(value = "business Id of consumer")  //CHANGED TO Integer from Long
	private Integer businessId;
	
	@Column(name="consumerId")
	@ApiModelProperty(value = "consumer Id of consumer")  //CHANGED TO Integer from Long
	private Integer consumerId;
	
	@Column(name="business_category")
	@ApiModelProperty(value = "business Category of consumer's business")
	private String businessCategory;
	
	// REMOVED bussiness Type
	
	@Column(name="business_turnover")
	@ApiModelProperty(value = "business TurnOver of consumer's business")
	private Long businessTurnOver;
	
	@Column(name="capital_invested")
	@ApiModelProperty(value = "capital Invested of consumer's business")
	private Long capitalInvested;
	
	@Column(name="total_employees")
	@ApiModelProperty(value = "total Employees of consumer's business")  //CHANGED TO Integer from Long 
	private Integer totalEmployees;
		
	@Column(name="business_value")
	@ApiModelProperty(value = "business Value consumer's business") //CHANGED TO Integer from Long
	private Integer businessValue;
	
	@Column(name="business_age")
	@ApiModelProperty(value = "business Age of consumer's business")  //CHANGED TO Integer from Long 
	private Integer businessAge;

	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public Integer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public Long getBusinessTurnOver() {
		return businessTurnOver;
	}
	public void setBusinessTurnOver(Long businessTurnOver) {
		this.businessTurnOver = businessTurnOver;
	}
	public Long getCapitalInvested() {
		return capitalInvested;
	}
	public void setCapitalInvested(Long capitalInvested) {
		this.capitalInvested = capitalInvested;
	}
	public Integer getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(Integer totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	public Integer getBusinessValue() {
		return businessValue;
	}
	public void setBusinessValue(Integer businessValue) {
		this.businessValue = businessValue;
	}
	public Integer getBusinessAge() {
		return businessAge;
	}
	public void setBusinessAge(Integer businessAge) {
		this.businessAge = businessAge;
	}
	
}
