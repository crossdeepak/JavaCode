package com.cg.mobilebilling.beans;

public class Bill {
	private int billID, noOfLocalSMS, noOfStdSMS, noOfLocalCalls, noOfStdCalls,billMonth;
	private float internetDataUsageUnits,internetDataUsageUnitsAmount, stateGST,centralGST,totalBillAmount, localSMSAmount, stdSMSAmount, localCallAmount; 
	public Bill(){}
	public Bill(int billID, int noOfLocalSMS, int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls, int billMonth,
			float internetDataUsageUnits, float internetDataUsageUnitsAmount, float stateGST, float centralGST,
			float totalBillAmount, float localSMSAmount, float stdSMSAmount, float localCallAmount) {
		super();
		this.billID = billID;
		this.noOfLocalSMS = noOfLocalSMS;
		this.noOfStdSMS = noOfStdSMS;
		this.noOfLocalCalls = noOfLocalCalls;
		this.noOfStdCalls = noOfStdCalls;
		this.billMonth = billMonth;
		this.internetDataUsageUnits = internetDataUsageUnits;
		this.internetDataUsageUnitsAmount = internetDataUsageUnitsAmount;
		this.stateGST = stateGST;
		this.centralGST = centralGST;
		this.totalBillAmount = totalBillAmount;
		this.localSMSAmount = localSMSAmount;
		this.stdSMSAmount = stdSMSAmount;
		this.localCallAmount = localCallAmount;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public int getNoOfLocalSMS() {
		return noOfLocalSMS;
	}
	public void setNoOfLocalSMS(int noOfLocalSMS) {
		this.noOfLocalSMS = noOfLocalSMS;
	}
	public int getNoOfStdSMS() {
		return noOfStdSMS;
	}
	public void setNoOfStdSMS(int noOfStdSMS) {
		this.noOfStdSMS = noOfStdSMS;
	}
	public int getNoOfLocalCalls() {
		return noOfLocalCalls;
	}
	public void setNoOfLocalCalls(int noOfLocalCalls) {
		this.noOfLocalCalls = noOfLocalCalls;
	}
	public int getNoOfStdCalls() {
		return noOfStdCalls;
	}
	public void setNoOfStdCalls(int noOfStdCalls) {
		this.noOfStdCalls = noOfStdCalls;
	}
	public int getBillMonth() {
		return billMonth;
	}
	public void setBillMonth(int billMonth) {
		this.billMonth = billMonth;
	}
	public float getInternetDataUsageUnits() {
		return internetDataUsageUnits;
	}
	public void setInternetDataUsageUnits(float internetDataUsageUnits) {
		this.internetDataUsageUnits = internetDataUsageUnits;
	}
	public float getInternetDataUsageUnitsAmount() {
		return internetDataUsageUnitsAmount;
	}
	public void setInternetDataUsageUnitsAmount(float internetDataUsageUnitsAmount) {
		this.internetDataUsageUnitsAmount = internetDataUsageUnitsAmount;
	}
	public float getStateGST() {
		return stateGST;
	}
	public void setStateGST(float stateGST) {
		this.stateGST = stateGST;
	}
	public float getCentralGST() {
		return centralGST;
	}
	public void setCentralGST(float centralGST) {
		this.centralGST = centralGST;
	}
	public float getTotalBillAmount() {
		return totalBillAmount;
	}
	public void setTotalBillAmount(float totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}
	public float getLocalSMSAmount() {
		return localSMSAmount;
	}
	public void setLocalSMSAmount(float localSMSAmount) {
		this.localSMSAmount = localSMSAmount;
	}
	public float getStdSMSAmount() {
		return stdSMSAmount;
	}
	public void setStdSMSAmount(float stdSMSAmount) {
		this.stdSMSAmount = stdSMSAmount;
	}
	public float getLocalCallAmount() {
		return localCallAmount;
	}
	public void setLocalCallAmount(float localCallAmount) {
		this.localCallAmount = localCallAmount;
	}

}
