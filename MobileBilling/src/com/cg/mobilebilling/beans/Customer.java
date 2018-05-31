package com.cg.mobilebilling.beans;

public class Customer {
	private int customerID;
	private long mobileNo, aadharNo;
	private String firstName, lastName, emailID, pancardNo, dateOfBirth;
	private PostPaidAccount [] postPaidAccount;
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PostPaidAccount[] getPostPaidAccount() {
		return postPaidAccount;
	}
	public void setPostPaidAccount(PostPaidAccount[] postPaidAccount) {
		this.postPaidAccount = postPaidAccount;
	}
	public Customer(){}
	public Customer(int customerID, long mobileNo, long aadharNo, String firstName, String lastName, String emailID,
			String pancardNo, String dateOfBirth,PostPaidAccount [] postPaidAccount,Address address) {
		super();
		this.customerID = customerID;
		this.mobileNo = mobileNo;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.pancardNo = pancardNo;
		this.dateOfBirth = dateOfBirth;
		this.postPaidAccount=postPaidAccount;
		this.address=address;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
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
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPancardNo() {
		return pancardNo;
	}
	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
