package com.cg.payroll.daoservices;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.payroll.beans.Associate;

@Component("payrollDAOServices")
public class PayrollDAOServicesImpl implements PayrollDAOServices {

	@Autowired	
	private SessionFactory sessionFactory;

	@Override
	public int insertAssociate(Associate associate) throws SQLException {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer associateId = null;
		try {
			tx = session.beginTransaction();
			associateId = (Integer) session.save(associate); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close(); 
		}
		return associateId;
	}

	@Override
	public boolean updateAssociate(Associate associate) throws SQLException {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			session.update(associate); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return true;
	}

	@Override
	public boolean deleteAssociate(int associateID) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Associate associate=(Associate) session.get(Associate.class, associateID);
			session.delete(associate); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return true;
	}

	@Override
	public Associate getAssociate(int associateID) {
		return (Associate) sessionFactory.openSession().get(Associate.class, associateID);
	}

	@Override
	public List<Associate> getAssociates() {
		return sessionFactory.openSession().createQuery("FROM Associate").list();
	}

}
