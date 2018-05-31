package com.cg.payroll.daoservices;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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
	private EntityManagerFactory entityManagerFactory;

	@Override
	public int insertAssociate(Associate associate) throws SQLException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate.getAssociateID();
	}

	@Override
	public boolean updateAssociate(Associate associate) throws SQLException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public boolean deleteAssociate(int associateID) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Associate associate=entityManager.find(Associate.class, associateID);
		entityManager.remove(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public Associate getAssociate(int associateID) {
		return entityManagerFactory.createEntityManager().getReference(Associate.class, associateID);
	}

	@Override
	public List<Associate> getAssociates() {
		TypedQuery<Associate> query =
			    entityManagerFactory.createEntityManager().createQuery("FROM Associate", Associate.class);
			  List<Associate> associates = query.getResultList();
		return associates;
	}

	
}
