package com.cg.inheritenceexample.beans;

public final class Developer extends PEmployee{
	private int noOfProjects,incentive;

	public Developer() {
		super();
	}

	@Override
	public String toString() {
		return super.toString()+", Developer noOfProjects=" + noOfProjects + ", incentive=" + incentive;
	}

	public Developer(int employeeId, int basicSalary, String firstName, String lastName, int noOfProjects) {
		super(employeeId, basicSalary, firstName, lastName);
		this.noOfProjects=noOfProjects;
	}

	public int getNoOfProjects() {
		return noOfProjects;
	}

	public void setNoOfProjects(int noOfProjects) {
		this.noOfProjects = noOfProjects;
	}

	public int getIncentive() {
		return incentive;
	}

	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}
	public void calculateSalary(){
		super.calculateSalary();
		incentive=noOfProjects*3000; 
	}
	public void developProject(){
		System.out.println("Develop a project");
	}
	
}
