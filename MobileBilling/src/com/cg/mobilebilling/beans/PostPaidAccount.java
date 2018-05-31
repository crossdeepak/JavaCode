package com.cg.mobilebilling.beans;

public class PostPaidAccount {
	private String mobileNo;
	private Plan plan;
	private Bill [] bill;
	
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Bill[] getBill() {
		return bill;
	}
	public void setBill(Bill[] bill) {
		this.bill = bill;
	}
	public PostPaidAccount(){}
	public PostPaidAccount(String mobileNo,Plan plan,Bill [] bill) {
		super();
		this.mobileNo = mobileNo;
		this.plan=plan;
		this.bill=bill;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
