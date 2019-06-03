package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.Query;
import com.dao.QueryDao;


public class QueryImpl implements QueryDao{

	public void saveQuery(Query query) {
		
		System.out.println("QueryImpl::saveQuery() called.");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");

		session.save(query);
		System.out.println("Object saved successfully...");
		
		tx.commit();
		session.close();
	
	}

}
