package com.dao;

import java.util.List;

import com.bean.LogDetails;
import com.bean.UserDetails;

public interface SaveDao 
{
	void register(UserDetails userDetails);
	public boolean checkUser(String emailId, String mobileNo);
	List<UserDetails> login(String email, String password);
	public void logDetails(LogDetails logDetails);
}
