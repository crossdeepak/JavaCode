package com.cg.pay.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.cg.pay.beans.Associate;
import com.cg.pay.beans.BankDetails;
import com.cg.pay.beans.Salary;
import com.cg.pay.daoservices.PayrollDAOServices;
import com.cg.pay.services.PayrollServices;
import com.cg.pay.services.PayrollServicesImpl;
import com.cg.pay.utility.PayrollUtility;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class PayrollTestMockito {
	private static PayrollServices payrollServices;
	private static PayrollDAOServices mockDAOServices;

	@BeforeClass
	public static void setUpTestEnv(){
		mockDAOServices=Mockito.mock(PayrollDAOServices.class);
		payrollServices=new PayrollServicesImpl(mockDAOServices);
	}
	@Before
	public void setUpMockData(){
		Associate associate1=new Associate(1001, 78000, "Deepak", "Muraree", "Trainee", "A4", "ABCD123", "deepakproo@gmail.com", new Salary(35000, 1800, 1800), new BankDetails(1234, "CITI", "CITI005"));
		Associate associate2=new Associate(1002, 88000, "Rahul", "Muraree", "Trainee", "A4", "ABGD123", "rahulproo@gmail.com", new Salary(39000, 1900, 1800), new BankDetails(1234, "CITI", "CITI005"));
		Associate associate3=new Associate(90000, "Alamel", "Mangai", "Trainee", "A4", "HGFD123", "chinnugopalan226@gmail.com", new Salary(40000, 2000, 4000), new BankDetails(4523, "HDFC", "HDFC12"));
		Associate associate4=new Associate(1001, 78000, "Deepak", "Muraree", "Trainee", "A4", "ABCD123", "deepakproo@gmail.com", new Salary(35000, 1800, 1800), new BankDetails(1234, "CITI", "CITI005"));
		
		ArrayList<Associate>associateList=new ArrayList<>();
		associateList.add(associate1);
		associateList.add(associate2);
		associateList.add(associate4);
		Mockito.when(mockDAOServices.getAssociate(1001)).thenReturn(associate1);
		Mockito.when(mockDAOServices.getAssociate(1002)).thenReturn(associate2);
		Mockito.when(mockDAOServices.getAssociate(1004)).thenReturn(associate4);
		Mockito.when(mockDAOServices.getAssociate(1045)).thenReturn(null);
		Mockito.when(mockDAOServices.insertAssociate(associate3)).thenReturn(1055);
		
	}

	@Test
	public void getAssociateDetailsForValidData() throws AssociateDetailsNotFoundException, PayrollServicesDownException{
		payrollServices.getAssociateDetails(1004);
		Mockito.verify(mockDAOServices.getAssociate(1004));
	}

	@Test
	public void getAssocateIdCounterForValidData(){
		
	}

	@Test(expected=AssociateDetailsNotFoundException.class)
	public void getAssociateDetailsForInvalidData()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		
	}

	@Test(expected=AssociateDetailsNotFoundException.class)
	public void calculateSalaryForInvalidId()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		
	}

	@Test
	public void calculateSalaryForValidData()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		
	}
	
	@Test
	public void calculateSalarForInvalidData()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		
	}

	@After
	public void tearDownMockData(){
		
		
	}
	@AfterClass
	public static void tearDownTestEnv(){
		payrollServices=null;
	}
}
