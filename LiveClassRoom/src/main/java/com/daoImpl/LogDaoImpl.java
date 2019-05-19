package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.bean.LogDetails;
import com.dao.LogDao;

@Service
public class LogDaoImpl implements LogDao {

	SessionFactory factory;
	Session session;
	Transaction tx;

	public void getTransection() {
		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		System.out.println("Transection Begin:-->LogDaoImpl");
	}

	@Override
	public int saveLogDetails(LogDetails logDetails) {
		System.out.println("LogDaoImpl::saveLogDtails() called.");
		int logId = 0;

		getTransection();
		logId = (int) session.save(logDetails);
		System.out.println("Object saved successfully...");

		tx.commit();
		session.close();
		return logId;
	}

	@Override
	public void updateLog(int logId) {
		System.out.println("LogDaoImpl::updateLog() called.");
		LogDetails logDetails = new LogDetails();

		logDetails.setLogId(logId);
		getTransection();
		session.update(logDetails);
		System.out.println("Object saved successfully...");

		tx.commit();
		session.close();	
	}
}
