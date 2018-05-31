package com.cg.banking.daoservices;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;
import com.cg.banking.utilities.BankingUtility;

@Component("daoServices")
public class BankingDOAOServicesImpl implements BankingDAOServices {
	
	@Autowired	
	private SessionFactory sessionFactory;
	private Map<Integer, Customer> customers;
	
	@Override
	public int insertCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = null;
		Integer customerId = null;
		try {
			tx =session.beginTransaction();
			customerId = (Integer) session.save(customer); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close(); 
		}
		return customerId;
	}

	@Override
	public long insertAccount(int customerId, Account account) {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = null;
		Long accountNo = null;
		if(getCustomer(customerId)!=null){
		try {
			Customer customer=getCustomer(customerId);
			account.setCustomer(customer);
			tx =session.beginTransaction();
			accountNo = (Long) session.save(account); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close(); 
		}
		return accountNo;
		}
		return 0;
	}

	@Override
	public boolean updateAccount(int customerId, Account account) {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = null;
		if(getCustomer(customerId)!=null){
		try {
			Customer customer=getCustomer(customerId);
			account.setCustomer(customer);
			tx =session.beginTransaction();
			session.update(account); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close(); 
		}
		return true;
		}
		return false;
	}

	@Override
	public int generatePin(int customerId, Account account) {
		Random generatePin=new Random();
		int pinNum=generatePin.nextInt(9999) + 1000;
		customers.get(customerId).getAccounts().get(account.getAccountNo()).setPinNumber(pinNum);
		return pinNum;
	}

	@Override
	public boolean insertTransaction(int customerId, long accountNo, Transaction transaction) {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = null;
		Integer transactionId=null;
		if(getAccount(customerId, accountNo)!=null){
		try {
			Account account=getAccount(customerId, accountNo);
			transaction.setAccount(account);
			tx =session.beginTransaction();
			transactionId = (Integer) session.save(transaction); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			session.close(); 
		}
		return true;
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Customer customer=(Customer) session.get(Customer.class, customerId);
			session.delete(customer); 
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
	public boolean deleteAccount(int customerId, long accountNo) {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Account account=getAccount(customerId, accountNo);
			session.delete(account);
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
	public Customer getCustomer(int customerId) {
		return (Customer) sessionFactory.openSession().get(Customer.class, customerId);
	}

	@Override
	public Account getAccount(int customerId, long accountNo) {
		Session session=sessionFactory.openSession();
		Account account=(Account) session.get(Account.class, accountNo);
		if(account.getCustomer().getCustomerId()==customerId){
		session.close();
			return account;
		}
		else
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		return sessionFactory.openSession().createQuery("FROM Customer").list();
	}

	@Override
	public List<Account> getAccounts(int customerId) {
		return sessionFactory.openSession().createQuery("FROM Account").list();
	}

	@Override
	public List<Transaction> getTransactions(int customerId, long accountNo) {
		return sessionFactory.openSession().createQuery("FROM Transaction").list();
	}
}
