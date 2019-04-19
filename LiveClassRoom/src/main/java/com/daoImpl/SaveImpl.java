package com.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.UserDetails;
import com.dao.SaveDao;

public class SaveImpl implements SaveDao
{
    
    public void register(UserDetails userDeatails)
	{
	     System.out.println("SaveImpl::register() called.");
	     SessionFactory factory = HibernateUtil.getSessionFactory();
	     Session session = factory.openSession();
	     Transaction tx = session.beginTransaction();
	     System.out.println("Transection Begin");
	     session.save(userDeatails);  
	     System.out.println("Object saved successfully.....!!");
	     tx.commit();
	     session.close();
	}

    public boolean checkUser(String emailId, String mobileNo)
    {
    	System.out.println("SaveImpl::checkUser() called.");
	 	SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
	     Transaction tx = session.beginTransaction();
	     System.out.println("Transection Begin");
	     //System.out.println(userDetails.getEmailId());
	     String hql = "FROM UserDetails WHERE EMAILID=? OR MOBILENO=?";
	     Query q = session.createQuery(hql);
	     q.setParameter(0, emailId);
	     q.setParameter(1, mobileNo);
	     tx.commit();
	     List list = q.list();
	     session.close();
	     Iterator itr = list.iterator();
	     if(itr.hasNext())
	    	 return true;
	     else
	    	 return false;
    }
	public List<Object> login(String emailId, String password)
	{			
		List<Object> list = null;
	    System.out.println("login() calles");
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
}
