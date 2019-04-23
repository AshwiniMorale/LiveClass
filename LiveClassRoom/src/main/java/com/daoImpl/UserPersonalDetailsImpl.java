package com.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.bean.UserPersonalDetails;
import com.dao.UserPersonalDetailsDao;

@Service
public class UserPersonalDetailsImpl implements UserPersonalDetailsDao {

	public void saveUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
		System.out.println("UserPersonalDetailsImpl::saveUserPersonalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		session.save(userPersonalDetails);
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
		
		
	}

	public List<UserPersonalDetails> readUserPersonalDetails(int userId) {
		
		System.out.println("UserPersonalDetailsImpl::saveUserPersonalDetails() called.");
		List<UserPersonalDetails> list=new ArrayList<UserPersonalDetails>();
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		String hql = "FROM UserPersonalDetails WHERE userId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userId);
		list = query.list();
		for(UserPersonalDetails userPersonalDetailsob:list)
		System.out.println(userPersonalDetailsob.getUserId());
		tx.commit();
		return list;
		
	}

	public void updateUserPersonalDetails(UserPersonalDetails userPersonalDetails, int userId) 
	{
		

		System.out.println("UserPersonalDetailsImpl::updateUserPersonalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");
		userPersonalDetails.setUserId(userId);
		session.update(userPersonalDetails);
		session.close();
		
		
	}

	public void deleteUserPersonalDetails(UserPersonalDetails userPersonalDetails, int userId) {
		
		System.out.println("UserPersonalDetailsImpl::deleteUserPersonalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");
		userPersonalDetails.setUserId(userId);
		session.delete(userPersonalDetails);
		session.close();
		
	}

}
