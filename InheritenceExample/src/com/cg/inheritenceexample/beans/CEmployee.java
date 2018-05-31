package com.cg.inheritenceexample.beans;

public final class CEmployee extends Employee {
	private int hrs,variablePay;

	public CEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CEmployee(int employeeId, String firstName, String lastName,int hrs) {
		super(employeeId, firstName, lastName);
		this.hrs=hrs;
	}

	@Override
	public String toString() {
		return "CEmployee hrs=" + hrs + ", variablePay=" + variablePay;
	}

	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public int getVariablePay() {
		return variablePay;
	}

	public void setVariablePay(int variablePay) {
		this.variablePay = variablePay;
	}
	
	public void calculateSalary(){
		variablePay=hrs*2000;
	}
	public void signContract(){
		System.out.println("Sign Contract");
	}
	
}
