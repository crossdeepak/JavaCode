package com.cg.banking.daoservices;

import java.util.Arrays;
import java.util.Random;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Customer;
import com.cg.banking.beans.Transaction;

public class BankingDOAOServicesImpl implements BankingDAOServices {
	private Customer [] customerList=new Customer[10];
	private static int CUSTOMER_ID_COUNTER=1;
	private static int CUSTOMER_IDX_COUNTER=0;
	private static long ACCOUNT_NO_COUNTER=20000001l;
	

	@Override
	public int insertCustomer(Customer customer) {
		if( CUSTOMER_IDX_COUNTER >70*customerList.length/100) {
			Customer[] tempList;
			tempList=Arrays.copyOf(customerList, 10+customerList.length );
			customerList=tempList;
		}
		customer.setCustomerId(CUSTOMER_ID_COUNTER++);
		customerList[CUSTOMER_IDX_COUNTER++]=customer;
		return customer.getCustomerId();
	}

	@Override
	public long insertAccount(int customerId, Account account) {
		for(int i=0;i<customerList.length;i++) {
			if( ACCOUNT_NO_COUNTER >70*customerList[i].getAccounts().length/100) {
				Account[] tempList;
				tempList=Arrays.copyOf(customerList[i].getAccounts(), 3+customerList[i].getAccounts().length);
				customerList[i].setAccounts(tempList);
			}
			if(customerList[i]!=null&&customerList[i].getCustomerId()==customerId) {
				long aIdCounter =ACCOUNT_NO_COUNTER;
				int aIdxCounter=customerList[i].getAccountIdxCounter();
				customerList[i].getAccounts()[aIdxCounter].setAccountNo(aIdCounter);
				customerList[i].getAccounts()[aIdxCounter]=account;
				aIdCounter++;aIdxCounter++;
				return account.getAccountNo();
			}
		}
		return 0;
	}

	@Override
	public boolean updateAccount(int customerId, Account account) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<customerList[i].getAccounts().length;j++)
			if(customerList[i]!=null&&customerList[i].getCustomerId()==customerId 
			&&customerList[i].getAccounts()[j]!=null 
					&& customerList[i].getAccounts()[j].getAccountNo()==account.getAccountNo()){
				customerList[i].getAccounts()[j]=account;
				return true;
			}
		return false;
	}

	@Override
	public int generatePin(int customerId, Account account) {
		Random generatePin=new Random();
		for(int i=0;i<customerList.length;i++) 
			for(int j=0;j<customerList[i].getAccounts().length;j++) 
			if(customerList[i]!=null&&customerList[i].getCustomerId()==customerId
					&&customerList[i].getAccounts()[j].getAccountNo()==account.getAccountNo()){
				customerList[i].getAccounts()[j].setPinNumber(generatePin.nextInt(9999) + 1000);
				return customerList[i].getAccounts()[j].getPinNumber();
			}
			return 0;
	}
		

	@Override
	public boolean insertTransaction(int customerId, long accountNo, Transaction transaction) {
		
		for(int i=0;i<customerList.length;i++) 
			for(int j=0;j<customerList[i].getAccounts().length;j++){
				if( customerList[i].getAccounts()[j].getTransactionIdxCounter() >70*customerList[i].getAccounts()[j].getTransactions().length/100) {
					Transaction[] tempList;
					tempList=Arrays.copyOf(customerList[i].getAccounts()[j].getTransactions(), 3+customerList[i].getAccounts()[j].getTransactions().length);
					customerList[i].getAccounts()[j].setTransactions(tempList);
				}
				if(customerList[i]!=null&&customerList[i].getCustomerId()==customerId
						&&customerList[i].getAccounts()[j].getAccountNo()==accountNo) {
					int tIdCounter=customerList[i].getAccounts()[j].getTransactionIdCounter();
					int tIdxCounter=customerList[i].getAccounts()[j].getTransactionIdxCounter();
					customerList[i].getAccounts()[j].getTransactions()[tIdxCounter]=transaction;
					customerList[i].getAccounts()[j].getTransactions()[tIdxCounter].setTransactionId(tIdCounter);
					tIdCounter++;
					tIdxCounter++;
					return true;
				}
			}
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		for(int i=0;i<customerList.length;i++) 
			if(customerList[i]!=null&&customerId==customerList[i].getCustomerId()) {
				customerList[i]=null;
				for(int j=i;j<customerList.length-1;j++){
					customerList[j]=customerList[j+1];
					customerList[j+1]=null;
				}
					CUSTOMER_IDX_COUNTER--;
				return true;	
			}
		return false;
	}
	

	@Override
	public boolean deleteAccount(int customerId, long accountNo) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<customerList[i].getAccounts().length;j++)
				if(customerList[i]!=null&&customerList[i].getCustomerId()==customerId
				&&customerList[i].getAccounts()[j]!=null&&customerList[i].getAccounts()[j].getAccountNo()==accountNo){
					customerList[i].getAccounts()[customerList[i].getAccountIdxCounter()]=null;
						for(int k=j;k<customerList[i].getAccounts().length-1;k++){
							customerList[i].getAccounts()[k]=customerList[i].getAccounts()[k+1];
							customerList[i].getAccounts()[k+1]=null;
						}
						int accountIdx=customerList[i].getAccountIdxCounter();
							accountIdx--;
					return true;
				}
		return false;
	}

	@Override
	public Customer getCustomer(int customerId) {
		for(int i=0;i<customerList.length;i++) 
			if(customerList[i]!=null&&customerList[i].getCustomerId()==customerId) 
				return customerList[i];
		return null;
	}

	@Override
	public Account getAccount(int customerId, long accountNo) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<customerList[i].getAccounts().length;j++)
				if(customerList[i]!=null&&customerList[i].getCustomerId()==customerId
				&&customerList[i].getAccounts()[j]!=null&&customerList[i].getAccounts()[j].getAccountNo()==accountNo)
					return customerList[i].getAccounts()[j];
		return null;
	}

	@Override
	public Customer[] getCustomers() {
		for(int i=0;i<customerList.length;i++) 
			if(customerList[i]!=null)
				return customerList;
		return null;
	}

	@Override
	public Account[] getAccounts(int customerId) {
		for(int i=0;i<customerList.length;i++) 
			for(int j=0;j<customerList[i].getAccounts().length;j++)
			if(customerList[i]!=null&&customerId==customerList[i].getCustomerId()
			&& customerList[i].getAccounts()[j]!=null) 
				return customerList[i].getAccounts();
		return null;
	}

	@Override
	public Transaction[] getTransactions(int customerId, long accountNo) {
		for(int i=0;i<customerList.length;i++)
			for(int j=0;j<customerList[i].getAccounts().length;j++)
				for(int k=0;k<customerList[i].getAccounts()[j].getTransactions().length;k++)
				if(customerList[i]!=null&&customerList[i].getCustomerId()==customerId
				&&customerList[i].getAccounts()[j]!=null&&customerList[i].getAccounts()[j].getAccountNo()==accountNo
				&& customerList[i].getAccounts()[j].getTransactions()[k]!=null)		
					return customerList[i].getAccounts()[j].getTransactions();
		return null;
	}

}
