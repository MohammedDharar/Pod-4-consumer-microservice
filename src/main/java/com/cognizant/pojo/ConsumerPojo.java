package com.cognizant.pojo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

//@Getter
//@Setter
//@NoArgsConstructor
public class ConsumerPojo {
	public ConsumerPojo() {}
	public ConsumerPojo(Integer consumerId, String firstName, String lastName, Date dob, String businessName, String panDetails,
			String email, String phone, String address, String agentName, Integer agentId,Integer businessId, String businessCategory,
			Long businessTurnOver, Long capitalInvested, Integer totalEmployees,Integer businessValue,
			Integer businessAge) {
		super();
		this.consumerId = consumerId;
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
		this.businessId=businessId;
		this.businessCategory = businessCategory;
		this.businessTurnOver = businessTurnOver;
		this.capitalInvested = capitalInvested;
		this.totalEmployees = totalEmployees;
		this.businessValue=businessValue;
		this.businessAge = businessAge;
	}
	/* Consumer Details */
	private Integer consumerId; //CHANGED TO Integer from Long
	private String firstName;
	private String lastName;
	private Date dob;  // CHANGED TO DATE FROM STRING
	private String businessName;
	private String panDetails;
	private String email;
	private String phone;
	private String address;
	private String agentName;
	private Integer agentId; //CHANGED TO Integer from Long
	
	/* Bussines Details */
	private Integer businessId;
	private String businessCategory;
	//REMOVED business type
	private Long businessTurnOver;
	private Long capitalInvested;
	private Integer totalEmployees;
	private Integer businessValue;
	private Integer businessAge;
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
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
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
