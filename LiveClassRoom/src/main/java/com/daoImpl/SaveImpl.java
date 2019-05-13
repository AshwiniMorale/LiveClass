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

	public void register(UserDetails userDetails) {
		System.out.println("SaveImpl::register() called.");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");

		session.save(userDetails);
		System.out.println("Object saved successfully...");

		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public boolean checkUser(String emailId, String mobileNo) {
		System.out.println("SaveImpl::checkUser() called.");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");

		// System.out.println(userDetails.getEmailId());
		String hql = "FROM UserDetails WHERE EMAILID=? OR MOBILENO=?";
		Query q = session.createQuery(hql);
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
	public List<UserDetails> login(String emailId, String password) {

		System.out.println("SaveImpl::login() called.");
		List<UserDetails> list = null;

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Transection Begin");

		String hql = "FROM UserDetails " + " WHERE emailId = ? " + "AND password = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, emailId);
		query.setParameter(1, password);
		list = query.list();
		tx.commit();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> forgetPassword(String emailId) {
		System.out.println("SaveImpl::forgetPassword() called.");
		List<UserDetails> list = null;

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("SaveImpl::forgetPassword()::Transection Begin");

		String hql = "FROM UserDetails " + " WHERE emailId = ? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, emailId);
		list = query.list();
		tx.commit();
		session.close();
		return list;
	}
}
