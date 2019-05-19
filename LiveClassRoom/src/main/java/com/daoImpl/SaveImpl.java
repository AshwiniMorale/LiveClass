package com.daoImpl;

import java.util.Iterator;
import java.util.List;
import com.bean.UserDetails;
import com.dao.SaveDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class SaveImpl implements SaveDao {

	SessionFactory factory;
	Session session;
	Transaction tx;
	static final String HQLCHECK1 = "FROM UserDetails WHERE emailId = ? AND password = ?";
	static final String HQLCHECK2 = "FROM UserDetails WHERE emailId = ? OR mobileNo = ?";
	static final String HQLCHECKEMAIL = "FROM UserDetails WHERE emailId = ? ";

	public void startTransaction() {
		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		System.out.println("Transection Begin...");
	}

	public int register(UserDetails userDetails) {
		System.out.println("register() called:-->SaveImpl");
		startTransaction();
		int userId = (int) session.save(userDetails);
		System.out.println("Object saved successfully..." + userId);
		tx.commit();
		session.close();
		return userId;
	}

	@SuppressWarnings("unchecked")
	public boolean checkUser(String emailId, String mobileNo) {
		System.out.println("checkUser() called:-->SaveImpl");

		startTransaction();
		// System.out.println(userDetails.getEmailId());

		Query q = session.createQuery(HQLCHECK2);
		q.setParameter(0, emailId);
		q.setParameter(1, mobileNo);
		tx.commit();
		List<UserDetails> list = q.list();
		session.close();
		Iterator<UserDetails> itr = list.iterator();
		if (itr.hasNext())
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> login(String emailId, String password) {

		System.out.println("login() called:-->SaveImpl");
		List<UserDetails> list = null;

		startTransaction();
		Query query = session.createQuery(HQLCHECK1);
		query.setParameter(0, emailId);
		query.setParameter(1, password);
		list = query.list();
		tx.commit();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> forgetPassword(String emailId) {
		System.out.println("forgetPassword() called:-->SaveImpl");
		List<UserDetails> list = null;

		startTransaction();
		Query query = session.createQuery(HQLCHECKEMAIL);
		query.setParameter(0, emailId);
		list = query.list();
		tx.commit();
		session.close();
		return list;
	}
}
