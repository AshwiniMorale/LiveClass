package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "tbl_usr_edu_det")
public class UserEducationalDetails {

	@Id
	@GeneratedValue
	@Column
	private int usreduId;
	@Column
	private int userId;
	
	@Column
	private String XthStream;
	@Column
	private String XthBoard;
	@Column
	private int XthYear;
	@Column
	private int XthPercentage;
	
	@Column
	private String XIIthStream;
	@Column
	private String XIIthBoard;
	@Column
	private int XIIthYear;
	@Column
	private int XIIthPercentage;
	
	@Column
	private String ugStream;
	@Column
	private String university;
	@Column
	private int ugYear;
	@Column
	private int ugPercentage;
	
	public int getUsreduId() {
		return usreduId;
	}
	public void setUsreduId(int usreduId) {
		this.usreduId = usreduId;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getXthStream() {
		return XthStream;
	}
	public void setXthStream(String xthStream) {
		XthStream = xthStream;
	}
	public String getXthBoard() {
		return XthBoard;
	}
	public void setXthBoard(String xthBoard) {
		XthBoard = xthBoard;
	}
	public int getXthYear() {
		return XthYear;
	}
	public void setXthYear(int xthYear) {
		XthYear = xthYear;
	}
	public int getXthPercentage() {
		return XthPercentage;
	}
	public void setXthPercentage(int xthPercentage) {
		XthPercentage = xthPercentage;
	}
	public String getXIIthStream() {
		return XIIthStream;
	}
	public void setXIIthStream(String xIIthStream) {
		XIIthStream = xIIthStream;
	}
	public String getXIIthBoard() {
		return XIIthBoard;
	}
	public void setXIIthBoard(String xIIthBoard) {
		XIIthBoard = xIIthBoard;
	}
	public int getXIIthYear() {
		return XIIthYear;
	}
	public void setXIIthYear(int xIIthYear) {
		XIIthYear = xIIthYear;
	}
	public int getXIIthPercentage() {
		return XIIthPercentage;
	}
	public void setXIIthPercentage(int xIIthPercentage) {
		XIIthPercentage = xIIthPercentage;
	}
	public String getUgStream() {
		return ugStream;
	}
	public void setUgStream(String ugStream) {
		this.ugStream = ugStream;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public int getUgYear() {
		return ugYear;
	}
	public void setUgYear(int ugYear) {
		this.ugYear = ugYear;
	}
	public int getUgPercentage() {
		return ugPercentage;
	}
	public void setUgPercentage(int ugPercentage) {
		this.ugPercentage = ugPercentage;
	}
	
}
