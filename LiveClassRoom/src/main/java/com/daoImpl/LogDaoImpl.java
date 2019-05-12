package com.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.bean.LogDetails;
import com.dao.LogDao;

@Service
public class LogDaoImpl implements LogDao {

	private static final String hql = "FROM LogDetails WHERE userId=?";

	@Override
	public void saveLogDetails(LogDetails logDetails) {
		System.out.println("LogDaoImpl::saveLogDtails() called.");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin...In saveLogDetails().");
		session.save(logDetails);
		System.out.println("Object saved successfully...");

		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean returnLogDetails(int userId) {
		System.out.println("LogDaoImpl::returnLogDetails() called.");
		List<LogDetails> listLogDetails = new ArrayList<LogDetails>();

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin...In returnLogDetails().");

		Query q = session.createQuery(hql);
		q.setParameter(0, userId);
		tx.commit();
		listLogDetails = q.list();
		session.close();
		Iterator<LogDetails> itr = listLogDetails.iterator();
		if (itr.hasNext())
			return true;
		else
			return false;
	}
}
