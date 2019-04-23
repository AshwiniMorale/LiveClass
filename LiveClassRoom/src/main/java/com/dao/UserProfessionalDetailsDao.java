package com.dao;

import java.util.List;

import com.bean.UserProfessionalDetails;
public interface UserProfessionalDetailsDao {

    public void saveUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails);
	
	public List<UserProfessionalDetails> readUserProfessionalDetails(int userId);
	
	public void updateUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails, int userId);
	
	public void deleteUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails, int userId);
	
	
}
