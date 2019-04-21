package com.bean;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table
public class UserPersonalDetails {

	
	@Id
	 @GeneratedValue
	 private int userId;
	 /*@Column
	 private String firstName;
	 @Column
	 private String lastName;*/
	 @Column
	 private Date dob;
	 @Column
	 private String gender;
	 @Column
	 private String category;
	 @Column
	 private String physically_Challenged; 
     @Column
	 private String hometown;
     @Column
	 private double area_Pincode;
     @Column
     private String marital_Status;
	 @Column
     private String permanent_Address;
     @Column
	 private int role=3;
	public int getUserId() {
		return userId;
	}
	/*public void setUserId(int userId) {
		this.userId = userId;
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
	}*/
	public Date getDOB() {
		return dob;
	}
	public void setDOB(Date dOB) {
		dob = dOB;
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
		category = category;
	}
	public String getPhysically_challenged() {
		return physically_Challenged;
	}
	public void setPhysically_challenged(String physically_challenged) {
		physically_Challenged = physically_Challenged;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		hometown = hometown;
	}
	public double getArea_Pincode() {
		return area_Pincode;
	}
	public void setArea_Pincode(double area_Pincode) {
		area_Pincode = area_Pincode;
	}
	public String getMarital_Status() {
		return marital_Status;
	}
	public void setMarital_Status(String marital_Status) {
		marital_Status = marital_Status;
	}
	public String getPermanent_Address() {
		return permanent_Address;
	}
	public void setPermanent_Address(String permanent_Address) {
		permanent_Address = permanent_Address;
	}
	public int getRole() {
		return role;
	}
	/*public void setRole(int role) {
		this.role = 3;
	}*/
		
	 
}
