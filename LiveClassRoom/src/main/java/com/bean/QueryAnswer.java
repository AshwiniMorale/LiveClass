package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "tbl_answer")
public class QueryAnswer {
	@Id
	@GeneratedValue
	private int qAid;

	@Column
	private String answer;

	@Column
	private String subject;

	@Column
	private int userId;

	public int getqAid() {
		return qAid;
	}

	public void setqAid(int qAid) {
		this.qAid = qAid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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
