package com.cg.inheritenceexample.beans;

public class PEmployee extends Employee {
	private int hra,da,ta;

	public PEmployee() {
		super();
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getDa() {
		return da;
	}

	public void setDa(int da) {
		this.da = da;
	}

	public int getTa() {
		return ta;
	}

	public void setTa(int ta) {
		this.ta = ta;
	}
	public PEmployee(int employeeId, int basicSalary, String firstName, String lastName) {
		super(employeeId, basicSalary, firstName, lastName);
	}

	public PEmployee(int employeeId, int basicSalary, String firstName, String lastName,int hra, int da, int ta) {
		super();
		this.hra = hra;
		this.da = da;
		this.ta = ta;
	}
	
	public void calculateSalary(){
		this.hra=(int) (this.getBasicSalary()*0.2);
		this.da=(int) (this.getBasicSalary()*0.3);
		this.ta=(int) (this.getBasicSalary()*0.1);
		this.setTotalSalary((this.getBasicSalary()+this.getDa()+this.getHra()+this.getTa()));
	}
	

	
	
}
