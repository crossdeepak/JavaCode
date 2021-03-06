package com.cg.banking.beans;

import java.util.Arrays;

public class Customer {
	private int customerId;
	private String firstName,lastName,emailId,panCard;
	private Address localAddress,homeAddress; 
	private int accountIdxCounter=0;
	private Account [] accounts ;
	public Customer() {}
	public Customer(int customerId, String firstName, String lastName, String emailId, String panCard,
			Address localAddress, Address homeAddress, int accountIdxCounter, Account[] accounts) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.panCard = panCard;
		this.localAddress = localAddress;
		this.homeAddress = homeAddress;
		this.accountIdxCounter = accountIdxCounter;
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", panCard=" + panCard + ", localAddress=" + localAddress + ", homeAddress="
				+ homeAddress + ", accountIdxCounter=" + accountIdxCounter + ", accounts=" + Arrays.toString(accounts)
				+ "]";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public Address getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(Address localAddress) {
		this.localAddress = localAddress;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public int getAccountIdxCounter() {
		return accountIdxCounter;
	}
	public void setAccountIdxCounter(int accountIdxCounter) {
		this.accountIdxCounter = accountIdxCounter;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountIdxCounter;
		result = prime * result + Arrays.hashCode(accounts);
		result = prime * result + customerId;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homeAddress == null) ? 0 : homeAddress.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((localAddress == null) ? 0 : localAddress.hashCode());
		result = prime * result + ((panCard == null) ? 0 : panCard.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (accountIdxCounter != other.accountIdxCounter)
			return false;
		if (!Arrays.equals(accounts, other.accounts))
			return false;
		if (customerId != other.customerId)
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homeAddress == null) {
			if (other.homeAddress != null)
				return false;
		} else if (!homeAddress.equals(other.homeAddress))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (localAddress == null) {
			if (other.localAddress != null)
				return false;
		} else if (!localAddress.equals(other.localAddress))
			return false;
		if (panCard == null) {
			if (other.panCard != null)
				return false;
		} else if (!panCard.equals(other.panCard))
			return false;
		return true;
	}
	public Customer(String firstName, String lastName, String emailId, String panCard, Address localAddress,
			Address homeAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.panCard = panCard;
		this.localAddress = localAddress;
		this.homeAddress = homeAddress;
	}
	
}