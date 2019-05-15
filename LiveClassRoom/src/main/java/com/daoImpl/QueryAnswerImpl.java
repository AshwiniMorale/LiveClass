package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.QueryAnswerDao;

public class QueryAnswerImpl implements QueryAnswerDao{


	public void saveQueryAnswer() {
		
		System.out.println("QueryAnswerImpl::saveQueryAnswer() called.");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");

		session.save(tx);
		System.out.println("Object saved successfully...");
		
		tx.commit();
		session.close();
		
	}

}