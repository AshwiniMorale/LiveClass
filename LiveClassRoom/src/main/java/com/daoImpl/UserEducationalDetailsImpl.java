package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.bean.UserEducationalDetails;
import com.dao.UserEducationalDetailsDao;

@Service
public class UserEducationalDetailsImpl implements UserEducationalDetailsDao{

	public void saveUserEducationalDetails(UserEducationalDetails userEducationalDetails) {
		System.out.println("CompleteProfileImpl::saveUserEducationalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		session.save(userEducationalDetails);
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<UserEducationalDetails> readUserEducationalDetails(int userId) {

		System.out.println("CompleteProfileImpl::saveUserEducationalDetails() called.");
		List<UserEducationalDetails> list=new ArrayList<UserEducationalDetails>();
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		String hql = "FROM UserEducationalDetails WHERE userId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userId);
		list = query.list();
		for(UserEducationalDetails userEducationalDetailsob:list)
		System.out.println(userEducationalDetailsob.getUserId());
		tx.commit();
		return list;
	}

	public void updateUserEducationalDetails(UserEducationalDetails userEducationalDetails, int userId) {
		
		System.out.println("CompleteProfileImpl::updateUserEducationalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");
		userEducationalDetails.setUserId(userId);
		session.update(userEducationalDetails);
		tx.commit();
		session.close();
		
	}

	public void deleteUserEducationalDetails(UserEducationalDetails userEducationalDetails, int userId) {
		
		System.out.println("CompleteProfileImpl::deleteUserEducationalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");
		userEducationalDetails.setUserId(userId);
		session.delete(userEducationalDetails);
		tx.commit();
		session.close();
		
	}

}
