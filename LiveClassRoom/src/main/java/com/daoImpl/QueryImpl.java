package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.bean.Query1;
import com.dao.QueryDao;

@Service
public class QueryImpl implements QueryDao{

	public void saveQuery1(Query1 query1) {
		
		System.out.println("QueryImpl::saveQuery() called.");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");
		
		session.save(query1);
		System.out.println("Object saved successfully...");
		
		tx.commit();
		session.close();
	
	}

}
