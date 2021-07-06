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
@Table(name="business_master")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ApiModel(description = "Model Class for the Business Master")
public class BusinessMaster {
	public BusinessMaster() {}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@ApiModelProperty(value = "business Master Id of Business Master") //CHANGED TO Integer from Long
	private Integer businessMasterid;
	
	@Column(name="business_category")
	@ApiModelProperty(value = "business Category of Business Master")
	private String businessCategory;
	
	@Column(name="total_employees")
	@ApiModelProperty(value = "total Employees of Business Master") //CHANGED TO Integer from Long
	private Integer totalEmployees;
	
	@Column(name="business_age")
	@ApiModelProperty(value = "business Age of Business Master") //CHANGED TO Integer from Long
	private Integer businessAge;
	
	@Column(name="business_value")
	@ApiModelProperty(value = "business Value of Business Master") //CHANGED TO Integer from Long
	private Integer businessValue;

}
