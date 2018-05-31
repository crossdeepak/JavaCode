package com.cg.inheritenceexample.beans;

public abstract class Employee {
	private int employeeId,basicSalary,totalSalary;
	private String firstName,lastName;
	@Override
	public String toString() {
		return "Employee employeeId=" + employeeId + ", basicSalary=" + basicSalary + ", totalSalary=" + totalSalary
				+ ", firstName=" + firstName + ", lastName=" + lastName;
	}
	public Employee(){
		super();
	}
	
	public Employee(int employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee(int employeeId, int basicSalary, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
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
	public abstract void calculateSalary();

}
