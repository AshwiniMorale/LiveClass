package com.dao;

import com.bean.LogDetails;

public interface LogDao {

	int saveLogDetails(LogDetails logDetails);
	void updateLog (int logId);

}
