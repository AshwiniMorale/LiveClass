package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.bean.QueryAnswer;
import com.dao.QueryAnswerDao;

@Service
public class QueryAnswerImpl implements QueryAnswerDao{


	public void saveQueryAnswer(QueryAnswer queryAnswer) {
		
		System.out.println("QueryAnswerImpl::saveQueryAnswer() called.");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");

		session.save(queryAnswer);
		System.out.println("Object saved successfully...");
		
		tx.commit();
		session.close();
		
	}

}
