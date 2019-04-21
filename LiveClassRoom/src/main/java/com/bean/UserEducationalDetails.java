package com.bean;

import javax.persistence.*;

@Entity
@Table
public class UserEducationalDetails {

	@Id
	 @GeneratedValue
	 private int userId;
	@Column
	private int Xth;
	@Column
	private String XthBoard;
	@Column
	private int XIIth;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getXth() {
		return Xth;
	}
	public void setXth(int xth) {
		Xth = xth;
	}
	public String getXthBoard() {
		return XthBoard;
	}
	public void setXthBoard(String xthBoard) {
		XthBoard = xthBoard;
	}
	public int getXIIth() {
		return XIIth;
	}
	public void setXIIth(int xIIth) {
		XIIth = xIIth;
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
