package com.bean;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table
public class UserProfessionalDetails {

	@Id
	 @GeneratedValue
	 private int userId;
	
	 @Column
	 private String ResumeHeadline;
	 
	 @Column
	 private String ProfileSummary;
	 
	 @Column
	 private String KeySkills;
	 
	 public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getResumeHeadline() {
		return ResumeHeadline;
	}

	public void setResumeHeadline(String resumeHeadline) {
		ResumeHeadline = resumeHeadline;
	}

	public String getProfileSummary() {
		return ProfileSummary;
	}

	public void setProfileSummary(String profileSummary) {
		ProfileSummary = profileSummary;
	}

	public String getKeySkills() {
		return KeySkills;
	}

	public void setKeySkills(String keySkills) {
		KeySkills = keySkills;
	}

	public String getEmployment() {
		return Employment;
	}

	public void setEmployment(String employment) {
		Employment = employment;
	}

	public String getProjects() {
		return Projects;
	}

	public void setProjects(String projects) {
		Projects = projects;
	}

	@Column
	 private String Employment;
	 
	 @Column
	 private String Projects;
}
