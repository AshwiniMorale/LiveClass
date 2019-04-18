package com.daoImpl;

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

	public void register(UserDetails st)
	{
	     System.out.println("Save() calles");
	     Configuration cfg = new Configuration();
	     cfg.configure();
	     SessionFactory factory =null;
	     Session session=null;
	     try
	     {
	    	 factory = cfg.buildSessionFactory();
	    	 session = factory.openSession();
	     }catch (Exception e) {
	    	 System.out.println(e);
	     }
	     Transaction tx = session.beginTransaction();
	     System.out.println("Transection Begin");
	     session.save(st);  
	     System.out.println("Object saved successfully.....!!");
	     tx.commit();
	     session.close();
	     factory.close();


	}


	public List<Object> login(String email, String password)
	{			
		 List<Object> list = null;
	     System.out.println("login() calles");
	     Configuration cfg = new Configuration();
	     cfg.configure();
	     SessionFactory factory =null;
	     Session session=null;
	     try
	     {
	    	 factory = cfg.buildSessionFactory();
	    	 session = factory.openSession();
	     }catch (Exception e) {
	    	 System.out.println(e);
	     }
	     Transaction tx = session.beginTransaction();
	     System.out.println("Transection Begin");
	     
	     String hql = "FROM UserDetails " + " WHERE email = ? " + "AND password = ?";
	     Query query = session.createQuery(hql);
	     query.setParameter(0, email);
	     query.setParameter(1, password);
	     list = query.list();
	     tx.commit();
	     session.close();
	     factory.close();

		return list;
	}


}
