package com.bean;

import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@Table
public class UserPersonalDetails {

	@Id
	@GeneratedValue
	private int userPersonalId;
	@Column
	private Date dob;
	@Column
	private String gender;
	@Column
	private String category;
	@Column
	private String physicallyChallenged;
	@Column
	private String hometown;
	@Column
	private double areaPinCode;
	@Column
	private String maritalStatus;
	@Column
	private String permanentAddress;
	@Column
	private int userId;
	
	public int getUserPersonalId() {
		return userPersonalId;
	}

	public void setUserPersonalId(int userPersonalId) {
		this.userPersonalId = userPersonalId;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhysicallyChallenged() {
		return physicallyChallenged;
	}

	public void setPhysicallyChallenged(String physicallyChallenged) {
		this.physicallyChallenged = physicallyChallenged;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public double getAreaPinCode() {
		return areaPinCode;
	}

	public void setAreaPinCode(double areaPinCode) {
		this.areaPinCode = areaPinCode;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

}
