package com.dao;

import com.bean.LogDetails;

public interface LogDao {

	void saveLogDetails(LogDetails logDetails);

	boolean returnLogDetails(int userId);
}
