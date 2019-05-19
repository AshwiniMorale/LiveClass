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
	
	SessionFactory factory;
	Session session;
	Transaction tx;
	static final String HQL = "FROM UserPersonalDetails WHERE userId=?";
	
	public void getTransection() {
		factory=HibernateUtil.getSessionFactory();
		session=factory.openSession();
		tx=session.beginTransaction();
		System.out.println("Transection Begin:-->UserPersonalDetailsImpl");
	}

	public void saveUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
		System.out.println("UserPersonalDetailsImpl::saveUserPersonalDetails() called.");

		getTransection();
		session.save(userPersonalDetails);
		System.out.println("Object saved successfuly");
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<UserPersonalDetails> readUserPersonalDetails(int userId) {	
		System.out.println("UserPersonalDetailsImpl::saveUserPersonalDetails() called.");
		List<UserPersonalDetails> list=new ArrayList<UserPersonalDetails>();
		
		getTransection();
		Query query = session.createQuery(HQL);
		query.setParameter(0, userId);
		list = query.list();
		for(UserPersonalDetails userPersonalDetailsob:list)
		System.out.println(userPersonalDetailsob.getUserId());
		tx.commit();
		return list;
	}

	public void updateUserPersonalDetails(UserPersonalDetails userPersonalDetails) 
	{
		System.out.println("UserPersonalDetailsImpl::updateUserPersonalDetails() called.");

		getTransection();
		session.update(userPersonalDetails);
		tx.commit();
		session.close();
	}

	public void deleteUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
		System.out.println("UserPersonalDetailsImpl::deleteUserPersonalDetails() called.");

		getTransection();
		session.delete(userPersonalDetails);
		tx.commit();
		session.close();	
	}
}
