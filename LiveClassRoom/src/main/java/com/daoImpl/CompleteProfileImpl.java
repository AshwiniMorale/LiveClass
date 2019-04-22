package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.UserEducationalDetails;
import com.bean.UserPersonalDetails;
import com.bean.UserProfessionalDetails;
import com.dao.CompleteProfileDao;

public class CompleteProfileImpl implements CompleteProfileDao {

	public void savePersonalDetails(UserPersonalDetails userPersonalDetails) {
		System.out.println("CompleteProfileImpl::savePersonalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		session.save(userPersonalDetails);
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
		
	}

	public void saveEducationalDetails(UserEducationalDetails userEducationalDetails) {
		
		System.out.println("CompleteProfileImpl::saveEducationalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		session.save(userEducationalDetails);
		
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
	}

	public void saveProfessionalDetails(UserProfessionalDetails userProfessionalDetails) {
		
		System.out.println("CompleteProfileImpl::saveProfessionalDetails() called.");

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Transection Begin");
		
		session.save(userProfessionalDetails);
		
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
		
	}

}
