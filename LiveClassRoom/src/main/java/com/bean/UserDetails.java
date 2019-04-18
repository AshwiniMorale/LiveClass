package com.bean;

import javax.persistence.*;

@Entity
@Table
public class UserDetails 
{
	 @Id
	 @GeneratedValue
	 @Column
	 private int id;
	 @Column
	 private String firstName;
	 @Column
	 private String lastName;
	 @Column
	 private String emailId;
	 @Column
	 private String password;
	 @Column
	 private int mobileNo;
	 @Column
	 private int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	//roleId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roleId")
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = 3;
	}
	 
	 
	 
	 


}
