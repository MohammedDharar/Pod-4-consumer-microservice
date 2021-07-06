package com.cognizant.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="consumer")
//@Getter
//@Setter
//@NoArgsConstructor
@ApiModel(description = "Model Class for Consumer Details")
public class Consumer {
	public Consumer() {}
	public Consumer(String firstName, String lastName, Date dob, String businessName, String panDetails,
			String email, String phone, String address, String agentName, Integer agentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.businessName = businessName;
		this.panDetails = panDetails;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.agentName = agentName;
		this.agentId = agentId;
	}

	@Id
	@Column(name="consumer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "consumer Id of Consumer")
	private Integer consumerId;  //CHANGED TO Integer from Long
	
	@Column(name="first_name")
	@ApiModelProperty(value = "first Name of Consumer")
	private String firstName;
	
	@Column(name="last_name")
	@ApiModelProperty(value = "last Name Id of Consumer")
	private String lastName;
	
	@Column(name="dob")
	@ApiModelProperty(value = "dob of Consumer")  //CHANGED TO Date from String
	private Date dob;
	
	@Column(name="business_name")
	@ApiModelProperty(value = "business Name of Consumer")
	private String businessName;
	
	@Column(name="pan_details")
	@ApiModelProperty(value = "pan Details  of Consumer")
	private String panDetails;
	
	@Column(name="email")
	@ApiModelProperty(value = "email of Consumer")
	private String email;
	
	@Column(name="phone")
	@ApiModelProperty(value = "phone of Consumer")
	private String phone;
	
	@Column(name="address")
	@ApiModelProperty(value = "address of Consumer") //CHANGED TO address from validity
	private String address;
	
	@Column(name="agent_name")
	@ApiModelProperty(value = "agent Name of Agent")
	private String agentName;
	
	@Column(name="agent_id")
	@ApiModelProperty(value = "agent Id of Agent")
	private Integer agentId; //CHANGED TO Integer from Long

	public Integer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getPanDetails() {
		return panDetails;
	}
	public void setPanDetails(String panDetails) {
		this.panDetails = panDetails;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	

}
