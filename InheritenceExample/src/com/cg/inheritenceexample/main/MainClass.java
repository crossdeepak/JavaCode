package com.cg.inheritenceexample.main;

import com.cg.inheritenceexample.beans.CEmployee;
import com.cg.inheritenceexample.beans.Developer;
import com.cg.inheritenceexample.beans.Employee;
import com.cg.inheritenceexample.beans.PEmployee;
import com.cg.inheritenceexample.beans.SalesManager;

public class MainClass {
	public static void main(String[] args) {
	 Employee employee;
/*	 employee =new Employee(4123, 18000, "Deepak", "Muraree");
	 employee.calculateSalary();
	 System.out.println(employee);
*/	 
	 employee =new CEmployee(123123, "Cross", "Fire", 10);
	 CEmployee cemp=(CEmployee)employee;
	 employee.calculateSalary();
	 cemp.signContract();
	 System.out.println(employee);
	 
	 employee =new SalesManager(45234, 16000, "Faze", "Karrigan", 10000);
	 SalesManager sm=(SalesManager)employee;
	 employee.calculateSalary();
	 sm.doSales();
	 System.out.println(employee);
	 
	 employee =new Developer(534, 15000, "SK", "Fer", 7);
	 Developer de=(Developer)employee;
	 employee.calculateSalary();
	 de.developProject();;
	 System.out.println(employee);
	
	}

}




/*public static void main(String[] args) {
	Employee employee=new Employee(123, 15000, "Deepak", "Muraree");
	employee.calculateSalary();
	System.out.println(employee.toString());
	PEmployee pe=new PEmployee(345, 16000, "Cross", "Fire");
	pe.calculateSalary();
	System.out.println(pe.toString());
	CEmployee ce=new CEmployee(453, "SK", "Fallen", 20);
	ce.calculateSalary();
	System.out.println(ce.toString());
	SalesManager sm=new SalesManager(7456, 18000, "VP", "Taz", 10000);
	sm.calculateSalary();
	System.out.println(sm.toString());
	Developer dev=new Developer(234, 20000, "Faze", "Karrigan", 5);
	dev.calculateSalary();
	System.out.println(dev.toString());*/