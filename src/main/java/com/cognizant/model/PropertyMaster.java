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
@Table(name="property_master")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ApiModel(description = "Model Class for the Property Master")
public class PropertyMaster {
	public PropertyMaster() {}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@ApiModelProperty(value = "property Master Id of Property Master")  //CHANGED TO Integer from Long
	private Integer propertyMasterId;
	
	@Column(name="property_type")
	@ApiModelProperty(value = "property type of Property Master")
	private String propertytype;
	
	@Column(name="building_type")
	@ApiModelProperty(value = "building Type of Property Master")
	private String buildingType;
	
	@Column(name="building_age")
	@ApiModelProperty(value = "property Master Id building Age of Property Master") //CHANGED TO Integer from Long
	private Integer buildingAge;
	
	@Column(name="property_value")
	@ApiModelProperty(value = "property Value of Property Master") //CHANGED TO Integer from Long
	private Integer propertyValue;
	
	@Column(name="annual_deprrciation")
	@ApiModelProperty(value = "annual Depreciation of Property Master")
	private Long annualDepreciation;

}
