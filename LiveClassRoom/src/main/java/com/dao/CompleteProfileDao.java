package com.dao;

import com.bean.UserEducationalDetails;
import com.bean.UserPersonalDetails;

public interface CompleteProfileDao {
   
	 public void savePersonalDetails(UserPersonalDetails userPersonalDetails);
	 public void saveEducationalDetails(UserEducationalDetails userEducationalDetails);
	 public void saveProfessionalDetails(UserPersonalDetails userProfessionalDetails);
}
