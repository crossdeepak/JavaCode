package com.cg.banking.daoservices;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;
import java.util.Random;

public class BankingDAOServicesImpl implements BankingDAOServices{
	private static Customer [] customerList=new Customer[10];
	private static int CUSTOMER_ID_COUNTER=101;
	private static int CUSTOMER_IDX_COUNTER=0;
	private static Account [] accountList=new Account[10];
	private static long ACCOUNT_NO_COUNTER=20000001l;
	private static int ACCOUNT_IDX_COUNTER=0;
	private static Transaction [] transactionList=new Transaction[10];
	private static int TRANSACTION_ID_COUNTER=1;
	private static int TRANSACTION_IDX_COUNTER=0;


	@Override
	public int insertCustomer(Customer customer) {
		customer.setCustomerId(CUSTOMER_ID_COUNTER++);
		customerList [CUSTOMER_IDX_COUNTER++]=customer;
		return customer.getCustomerId();
	}

	@Override
	public long insertAccount(int customerId, Account account) {
		for(int i=0;i<accountList.length;i++)
			if(customerList[i]!=null && customerList[i].getCustomerId()==customerId){
				account.setAccountNo(ACCOUNT_NO_COUNTER++);
				accountList [ACCOUNT_IDX_COUNTER++]=account;
			}
		return account.getAccountNo();
	}

	@Override
	public boolean updateAccount(int customerId, Account account) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<accountList.length;j++)
				if(customerList[i]!=null && customerList[i].getCustomerId()==customerId &&
				accountList[j]!=null && accountList[j].getAccountNo()==account.getAccountNo()){
					accountList[j]=account;
					return true;
				}
		return false;
	}

	@Override
	public int generatePin(int customerId, Account account) {
		Random generatePin=new Random();
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<accountList.length;j++)
				if(customerList[i]!=null && customerList[i].getCustomerId()==customerId &&
				accountList[j]!=null && accountList[j].getAccountNo()==account.getAccountNo())
		return generatePin.nextInt(9999) + 1;
	return 0;
	}

	@Override
	public boolean insertTransaction(int customerId, long accountNo, Transaction transaction) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<accountList.length;j++)
				if(customerList[i]!=null && customerList[i].getCustomerId()==customerId &&
				accountList[j]!=null && accountList[j].getAccountNo()==accountNo){
					transaction.setTransactionId(TRANSACTION_ID_COUNTER++);
					transactionList [TRANSACTION_IDX_COUNTER++]=transaction;
					return true;
				}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		for(int i=0;i<customerList.length;i++)
			if(customerList[i]!=null && customerList[i].getCustomerId()==customerId){
				customerList[i]=null;
				return true;
			}
		return false;
	}

	@Override
	public boolean deleteAccount(int customerId, long accountNo) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<accountList.length;i++)
				if(accountList[i]!=null && customerList[i]!=null && customerList[i].getCustomerId()==customerId	
				&& accountList[i].getAccountNo()==accountNo){
					accountList[i]=null;
					return true;
				}
		return false;
	}

	@Override
	public Customer getCustomer(int customerId) {
		for(int i=0;i<customerList.length;i++)
			if(customerList[i]!=null && customerList[i].getCustomerId()==customerId){
				return customerList[i];
			}
		return null;
	}

	@Override
	public Account getAccount(int customerId, long accountNo) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<accountList.length;j++)
				if(accountList[i]!=null && customerList[i]!=null && customerList[i].getCustomerId()==customerId	
				&& accountList[i].getAccountNo()==accountNo){
					return accountList[j];
				}
		return null;
	}

	@Override
	public Customer[] getCustomers() {
		return customerList;
	}

	@Override
	public Account[] getAccounts(int customerId) {
		for(int i=0;i<customerList.length;i++)
			if(customerList[i]!=null && customerList[i].getCustomerId()==customerId)
				return accountList;
		return null;
	}

	@Override
	public Transaction[] getTransactions(int customerId, long accountNo) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<accountList.length;j++)
				if(accountList[i]!=null && customerList[i]!=null && customerList[i].getCustomerId()==customerId	
				&& accountList[i].getAccountNo()==accountNo)
					return transactionList;
		return null;
	}

}
