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
	private String UG;
	@Column
	private String Stream;
	@Column
	private int UGMarks;
	@Column
	private String University;

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

	public int getXth() {
		return XthPercentage;
	}

	public void setXth(int xthPercentage) {
		XthPercentage = xthPercentage;
	}

	public String getXthBoard() {
		return XthBoard;
	}

	public void setXthBoard(String xthBoard) {
		XthBoard = xthBoard;
	}

	public int getXIIth() {
		return XIIthPercentage;
	}

	public void setXIIth(int xIIthPercentage) {
		XIIthPercentage = xIIthPercentage;
	}

	public String getXIIthBoard() {
		return XIIthBoard;
	}

	public void setXIIthBoard(String xIIthBoard) {
		XIIthBoard = xIIthBoard;
	}

	public String getUG() {
		return UG;
	}

	public void setUG(String uG) {
		UG = uG;
	}

	public String getStream() {
		return Stream;
	}

	public void setStream(String stream) {
		Stream = stream;
	}

	public int getUGMarks() {
		return UGMarks;
	}

	public void setUGMarks(int uGMarks) {
		UGMarks = uGMarks;
	}

	public String getUniversity() {
		return University;
	}

	public void setUniversity(String university) {
		University = university;
	}
}
