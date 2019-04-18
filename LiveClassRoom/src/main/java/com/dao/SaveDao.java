package com.dao;

import java.util.List;

import com.bean.UserDetails;

public interface SaveDao 
{
	void register(UserDetails st);
	List<Object> login(String email, String password);
}
