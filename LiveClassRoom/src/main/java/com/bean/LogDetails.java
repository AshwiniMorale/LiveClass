package com.bean;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class LogDetails {
	
	@Id
	@GeneratedValue
	@Column
	int logId;
	@Column
	int userId;
	@Column
	Date inTime;
	@Column
	Date outTime;
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	
	@OneToOne
	@JoinColumn(name = "userId")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

}
