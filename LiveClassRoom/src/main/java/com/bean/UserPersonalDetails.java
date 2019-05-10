package com.bean;

import javax.persistence.*;

@Entity
@Table
public class UserPersonalDetails {

	@Id
	@GeneratedValue
	private int userPersonalId;
	@Column
	private String dob;
	@Column
	private String gender;
	@Column
	private String hometown;
	@Column
	private String areaPinCode;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getAreaPinCode() {
		return areaPinCode;
	}

	public void setAreaPinCode(String areaPinCode) {
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
