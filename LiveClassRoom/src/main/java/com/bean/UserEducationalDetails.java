package com.bean;

import javax.persistence.*;

@Entity
@Table
public class UserEducationalDetails {

	@Id
	@GeneratedValue
	private int educationId;
	@Column
	private int userId;
	@Column
	private int XthPercentage;
	@Column
	private int XthYear;
	@Column
	private String XthBoard;
	@Column
	private int XIIthPercentage;
	@Column
	private int XIIthYear;
	@Column
	private String XIIthBoard;
	@Column
	private String uG;
	@Column
	private String stream;
	@Column
	private int uGMarks;
	@Column
	private int uGYear;
	@Column
	private String university;
	public int getEducationId() {
		return educationId;
	}
	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getXthPercentage() {
		return XthPercentage;
	}
	public void setXthPercentage(int xthPercentage) {
		XthPercentage = xthPercentage;
	}
	public int getXthYear() {
		return XthYear;
	}
	public void setXthYear(int xthYear) {
		XthYear = xthYear;
	}
	public String getXthBoard() {
		return XthBoard;
	}
	public void setXthBoard(String xthBoard) {
		XthBoard = xthBoard;
	}
	public int getXIIthPercentage() {
		return XIIthPercentage;
	}
	public void setXIIthPercentage(int xIIthPercentage) {
		XIIthPercentage = xIIthPercentage;
	}
	public int getXIIthYear() {
		return XIIthYear;
	}
	public void setXIIthYear(int xIIthYear) {
		XIIthYear = xIIthYear;
	}
	public String getXIIthBoard() {
		return XIIthBoard;
	}
	public void setXIIthBoard(String xIIthBoard) {
		XIIthBoard = xIIthBoard;
	}
	public String getuG() {
		return uG;
	}
	public void setuG(String uG) {
		this.uG = uG;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public int getuGMarks() {
		return uGMarks;
	}
	public void setuGMarks(int uGMarks) {
		this.uGMarks = uGMarks;
	}
	public int getuGYear() {
		return uGYear;
	}
	public void setuGYear(int uGYear) {
		this.uGYear = uGYear;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	
	
}
