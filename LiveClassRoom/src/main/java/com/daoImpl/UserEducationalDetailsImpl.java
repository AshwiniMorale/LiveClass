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

	SessionFactory factory;
	Session session;
	Transaction tx;
	static final String HQL = "FROM UserEducationalDetails WHERE userId=?";
	
	public void getTransection() {
		factory=HibernateUtil.getSessionFactory();
		session=factory.openSession();
		tx=session.beginTransaction();
		System.out.println("Transection Begin:-->UserProfessionalDetailsImpl");
	}
	
	public void saveUserEducationalDetails(UserEducationalDetails userEducationalDetails) {
		System.out.println("CompleteProfileImpl::saveUserEducationalDetails() called.");

		getTransection();
		session.save(userEducationalDetails);
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<UserEducationalDetails> readUserEducationalDetails(int userId) {
		System.out.println("CompleteProfileImpl::saveUserEducationalDetails() called.");
		List<UserEducationalDetails> list=new ArrayList<UserEducationalDetails>();

		getTransection();
		Query query = session.createQuery(HQL);
		query.setParameter(0, userId);
		list = query.list();
		for(UserEducationalDetails userEducationalDetailsob:list)
		System.out.println(userEducationalDetailsob.getUserId());
		tx.commit();
		return list;
	}

	public void updateUserEducationalDetails(UserEducationalDetails userEducationalDetails) {
		System.out.println("CompleteProfileImpl::updateUserEducationalDetails() called.");

		getTransection();
		session.update(userEducationalDetails);
		tx.commit();
		session.close();
	}

	public void deleteUserEducationalDetails(UserEducationalDetails userEducationalDetails) {
		System.out.println("CompleteProfileImpl::deleteUserEducationalDetails() called.");

		getTransection();
		session.delete(userEducationalDetails);
		tx.commit();
		session.close();
	}
}
