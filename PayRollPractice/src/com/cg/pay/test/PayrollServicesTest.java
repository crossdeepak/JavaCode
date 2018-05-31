package com.cg.pay.test;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.pay.beans.Associate;
import com.cg.pay.beans.BankDetails;
import com.cg.pay.beans.Salary;
import com.cg.pay.daoservices.PayrollDAOServicesImpl;
import com.cg.pay.services.PayrollServices;
import com.cg.pay.services.PayrollServicesImpl;
import com.cg.pay.utility.PayrollUtility;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class PayrollServicesTest {
	private static PayrollServices payrollServices;

	@BeforeClass
	public static void setUpTestEnv(){
		payrollServices=new PayrollServicesImpl();
	}
	@Before
	public void setUpMockData(){
		PayrollUtility.ASSOCIATE_ID_COUNTER=111;
		Associate associate1=new Associate(PayrollUtility.ASSOCIATE_ID_COUNTER++, 100000, "Deepak", "Muraree", "Trainee", "A4", "asdb123", "asb@asd.com", new Salary(10000, 1000, 2000), new BankDetails(20001, "CITI", "CITI123"));
		Associate associate2=new Associate(PayrollUtility.ASSOCIATE_ID_COUNTER++, 90000, "Rahul", "Muraree", "Trainee", "A4", "asdb123", "arb@asd.com", new Salary(20000, 1000, 2000), new BankDetails(20001, "CITI", "CITI123"));
		PayrollDAOServicesImpl.associates.put(associate1.getAssociateID(), associate1);
		PayrollDAOServicesImpl.associates.put(associate2.getAssociateID(), associate2);
	}

	@Test
	public void getAssociateDetailsForValidData(){
		Associate actualAssociate=PayrollDAOServicesImpl.associates.get(112);
		Associate expectedAssociate=new Associate(112, 90000, "Rahul", "Muraree", "Trainee", "A4", "asdb123", "arb@asd.com", new Salary(20000, 1000, 2000), new BankDetails(20001, "CITI", "CITI123"));
		assertEquals(expectedAssociate, actualAssociate);
	}

	@Test
	public void getAssocateIdCounterForValidData(){
		int expectedId=113;
		int actualId=PayrollUtility.ASSOCIATE_ID_COUNTER;
		assertEquals(expectedId, actualId);
	}

	@Test(expected=AssociateDetailsNotFoundException.class)
	public void getAssociateDetailsForInvalidData()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		payrollServices.getAssociateDetails(200);
	}

	@Test(expected=AssociateDetailsNotFoundException.class)
	public void calculateSalaryForInvalidId()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		payrollServices.calculateNetSalary(155);
	}

	@Test
	public void calculateSalaryForValidData()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		assertEquals(17500f, payrollServices.calculateNetSalary(111), 0.0002);
	}
	
	@Test
	public void calculateSalarForInvalidData()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		assertEquals(17500f, payrollServices.calculateNetSalary(111), 0.0002);
	}

	@After
	public void tearDownMockData(){
		PayrollDAOServicesImpl.associates.clear();
		PayrollUtility.ASSOCIATE_ID_COUNTER=111;
	}
	@AfterClass
	public static void tearDownTestEnv(){
		payrollServices=null;
	}
}
