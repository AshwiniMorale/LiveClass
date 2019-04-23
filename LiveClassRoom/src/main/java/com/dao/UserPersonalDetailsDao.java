package com.dao;

import com.bean.UserPersonalDetails;
import java.util.List;

public interface UserPersonalDetailsDao {

	public void saveUserPersonalDetails(UserPersonalDetails userPersonalDetails);
	
	public List<UserPersonalDetails> readUserPersonalDetails(int userId);
	
	public void updateUserPersonalDetails(UserPersonalDetails userPersonalDetails, int userId);
	
	public void deleteUserPersonalDetails(UserPersonalDetails userPersonalDetails, int userId);
	
}
