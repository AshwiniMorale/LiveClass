package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.bean.UserProfessionalDetails;
import com.dao.UserProfessionalDetailsDao;

@Service
public class UserProfessionalDetailsImpl implements UserProfessionalDetailsDao{
	
	SessionFactory factory;
	Session session;
	Transaction tx;
	static final String HQL = "FROM UserProfessionalDetails WHERE userId=?";
	
	public void getTransection() {
		factory=HibernateUtil.getSessionFactory();
		session=factory.openSession();
		tx=session.beginTransaction();
		System.out.println("Transection Begin:-->UserProfessionalDetailsImpl");
	}
	public void saveUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails) {
		System.out.println("CompleteProfileImpl::saveUserProfessionalDetails() called.");

		getTransection();
		session.save(userProfessionalDetails);
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<UserProfessionalDetails> readUserProfessionalDetails(int userId) {
		System.out.println("CompleteProfileImpl::saveUserProfessionalDetails() called.");
		List<UserProfessionalDetails> list=new ArrayList<UserProfessionalDetails>();
		
		getTransection();
		Query query = session.createQuery(HQL);
		query.setParameter(0, userId);
		list = query.list();
		for(UserProfessionalDetails userProfessionalDetailsob:list)
		System.out.println(userProfessionalDetailsob.getUserId());
		tx.commit();
		return list;
	}

	public void updateUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails) {
		System.out.println("CompleteProfileImpl::updateUserPersonalDetails() called.");

		getTransection();
		session.update(userProfessionalDetails);
		tx.commit();
		session.close();
	}

	public void deleteUserProfessionalDetails(UserProfessionalDetails userProfessionalDetails) {	
		System.out.println("CompleteProfileImpl::deleteUserProfessionalDetails() called.");

		getTransection();
		session.delete(userProfessionalDetails);
		tx.commit();
		session.close();	
	}
}
