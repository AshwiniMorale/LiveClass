package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "tbl_usr_prof_det")
public class UserProfessionalDetails {

	@Id
	@GeneratedValue
	@Column
	private int usrProfId;
	
	@Column
	private int userId;
	
	@Column
	private String resumeHeadline;

	@Column
	private String profileSummary;

	@Column
	private String keySkills;
	
	@Column
	private String employment;

	@Column
	private String projects;

	public int getUsrProfId() {
		return usrProfId;
	}

	public void setUsrProfId(int usrProfId) {
		this.usrProfId = usrProfId;
	}

	public String getResumeHeadline() {
		return resumeHeadline;
	}

	public void setResumeHeadline(String resumeHeadline) {
		this.resumeHeadline = resumeHeadline;
	}

	public String getProfileSummary() {
		return profileSummary;
	}

	public void setProfileSummary(String profileSummary) {
		this.profileSummary = profileSummary;
	}

	public String getKeySkills() {
		return keySkills;
	}

	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
