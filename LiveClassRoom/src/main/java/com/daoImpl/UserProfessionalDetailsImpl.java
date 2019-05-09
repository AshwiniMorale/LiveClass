package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.UserProfessionalDetails;
import com.dao.UserProfessionalDetailsDao;

public class UserProfessionalDetailsImpl implements UserProfessionalDetailsDao{

	public void saveUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails) {
		System.out.println("CompleteProfileImpl::saveUserProfessionalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		session.save(userProfessionalDetails);
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
		
		
		
	}

	@SuppressWarnings("unchecked")
	public List<UserProfessionalDetails> readUserProfessionalDetails(int userId) {
		
		System.out.println("CompleteProfileImpl::saveUserProfessionalDetails() called.");
		List<UserProfessionalDetails> list=new ArrayList<UserProfessionalDetails>();
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		String hql = "FROM UserProfessionalDetails WHERE userId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userId);
		list = query.list();
		for(UserProfessionalDetails userProfessionalDetailsob:list)
		System.out.println(userProfessionalDetailsob.getUserId());
		tx.commit();
		return list;
	}

	public void updateUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails, int userId) {
		
		System.out.println("CompleteProfileImpl::updateUserPersonalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");
		userProfessionalDetails.setUserId(userId);
		session.update(userProfessionalDetails);
		tx.commit();
		session.close();
		
	}

	public void deleteUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails, int userId) {
		
		System.out.println("CompleteProfileImpl::deleteUserProfessionalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");
		userProfessionalDetails.setUserId(userId);
		session.delete(userProfessionalDetails);
		tx.commit();
		session.close();
		
	}

}
