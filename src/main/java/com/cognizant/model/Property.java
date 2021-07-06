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
import lombok.ToString;

@Entity
@Table(name="property")
//@ToString
//@NoArgsConstructor
@ApiModel(description = "Model Class for Property of consumer")
public class Property {
	public Property() {}
	public Property(Integer businessId, String insuranceType, String propertyType,
			Long annualDepreciationValue,int propertyValue,String buildingsqft, String buildingType, Integer buildingAge, Long costOfAsset,
			Long salvageValue,Integer usefulLifeOfAsset) {
		super();
		this.businessId = businessId;
//		this.consumerId = consumerId;
		this.insuranceType = insuranceType;
		this.propertyType = propertyType;
		this.annualDepreciationValue = annualDepreciationValue; 
		this.propertyValue=propertyValue;
		this.buildingsqft = buildingsqft;
		this.buildingType = buildingType;
		this.buildingAge = buildingAge;
		this.costOfAsset = costOfAsset;
		this.salvageValue = salvageValue;
		this.usefulLifeOfAsset=usefulLifeOfAsset;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id of property")
	private Integer id;   //CHANGED TO Integer from Long
	
	@Column(name="business_id")
	@ApiModelProperty(value = "business Id of consumer's business")
	private Integer businessId;   //CHANGED TO Integer from Long

	
	@Column(name="insurance_type")
	@ApiModelProperty(value = "insurance Type of property")
	private String insuranceType;
	
	@Column(name="property_type")
	@ApiModelProperty(value = "property Type of property")
	private String propertyType;
	
	@Column(name="annual_depreciation_value")
	@ApiModelProperty(value = "annual Depreciation Value of property")
	private Long annualDepreciationValue;
	
	@Column(name="property_value")
	@ApiModelProperty(value = "property Value of property")
	private int propertyValue;
	
	@Column(name="building_ft")
	@ApiModelProperty(value = "building sqft of property")
	private String buildingsqft;
	
	@Column(name="building_type")
	@ApiModelProperty(value = "building Type of property")
	private String buildingType;
	
	@Column(name="age")
	@ApiModelProperty(value = "building Age of property")  //CHANGED TO Integer from Long
	private Integer buildingAge;
	
	@Column(name="asset_cost")
	@ApiModelProperty(value = "cost Of Asset of property")
	private Long costOfAsset;
	
	@Column(name="salvage")
	@ApiModelProperty(value = "salvage Value of property")
	private Long salvageValue;
	
	@Column(name="useful_life_of_asset")
	@ApiModelProperty(value = "useful Life Of Asset of property") //CHANGED TO Integer from Long
	private Integer usefulLifeOfAsset;


	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	public Long getAnnualDepreciationValue() {
		return annualDepreciationValue;
	}

	public void setAnnualDepreciationValue(Long annualDepreciationValue) {
		this.annualDepreciationValue = annualDepreciationValue;
	}
	
	public int getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(int propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	public String getBuildingsqft() {
		return buildingsqft;
	}

	public void setBuildingsqft(String buildingsqft) {
		this.buildingsqft = buildingsqft;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public Integer getBuildingAge() {
		return buildingAge;
	}

	public void setBuildingAge(Integer buildingAge) {
		this.buildingAge = buildingAge;
	}

	public Long getCostOfAsset() {
		return costOfAsset;
	}

	public void setCostOfAsset(Long costOfAsset) {
		this.costOfAsset = costOfAsset;
	}

	public Long getSalvageValue() {
		return salvageValue;
	}

	public void setSalvageValue(Long salvageValue) {
		this.salvageValue = salvageValue;
	}

	public Integer getUsefulLifeOfAsset() {
		return usefulLifeOfAsset;
	}

	public void setUsefulLifeOfAsset(Integer usefulLifeOfAsset) {
		this.usefulLifeOfAsset = usefulLifeOfAsset;
	}
	
}
