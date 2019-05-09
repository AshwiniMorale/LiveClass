package com.dao;

import java.util.List;

import com.bean.LogDetails;
import com.bean.UserDetails;

public interface SaveDao 
{
	void register(UserDetails userDetails);
	public boolean checkUser(String emailId, String mobileNo);
	public void logDetails(LogDetails logDetails);
	List<UserDetails> login(String email, String password);
	List<UserDetails> forgetPassword(String emailId);
	
	
}
