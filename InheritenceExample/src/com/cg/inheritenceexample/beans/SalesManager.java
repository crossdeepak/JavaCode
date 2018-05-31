package com.cg.inheritenceexample.beans;

public final class SalesManager extends PEmployee {
	private int salesAmt,commission;

	public SalesManager() {
		super();
	}

	public SalesManager(int employeeId, int basicSalary, String firstName, String lastName,int salesAmt) {
		super(employeeId, basicSalary, firstName, lastName);
		this.salesAmt=salesAmt;
	}

	public int getSalesAmt() {
		return salesAmt;
	}

	public void setSalesAmt(int salesAmt) {
		this.salesAmt = salesAmt;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}
	
	public void calculateSalary(){
		super.calculateSalary();
		commission=1*salesAmt/100;
		
	}
	public void doSales(){
		System.out.println("Do Sales");
	}

	@Override
	public String toString() {
		return super.toString()+", SalesManager salesAmt=" + salesAmt + ", commission=" + commission;
	}
	
}
