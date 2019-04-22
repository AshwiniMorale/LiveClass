package com.dao;

import com.bean.UserEducationalDetails;
import com.bean.UserPersonalDetails;
import com.bean.UserProfessionalDetails;

public interface CompleteProfileDao {
   
	 public void savePersonalDetails(UserPersonalDetails userPersonalDetails);
	 public void saveEducationalDetails(UserEducationalDetails userEducationalDetails);
	 public void saveProfessionalDetails(UserProfessionalDetails userProfessionalDetails);
}
