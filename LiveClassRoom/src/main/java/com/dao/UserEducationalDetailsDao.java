package com.dao;

import java.util.List;

import com.bean.UserEducationalDetails;

public interface UserEducationalDetailsDao {

public void saveUserEducationalDetails(UserEducationalDetails userEducationalDetails);
	
	public List<UserEducationalDetails> readUserEducationalDetails(int userId);
	
	public void updateUserEducationalDetails(UserEducationalDetails userEducationalDetails);
	
	public void deleteUserEducationalDetails(UserEducationalDetails userEducationalDetails);
		
}
