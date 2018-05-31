package com.cg.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.exception.InValidNoRangeException;
import com.cg.services.MathServices;
import com.cg.services.MathServicesImpl;



public class MathServicesTest {
	private static MathServices services;
	private int validNum1,validNum2,inValidNum1,inValidNum2,expectedAns;
	
	@BeforeClass
	public static void setUpTestEnv(){
		services=new MathServicesImpl();
	}
	@Before
	public void setUpMockData(){
		validNum1=10;
		validNum2=20;
		inValidNum1=-10;
		inValidNum2=-15;
	}
	
	@Test(expected=InValidNoRangeException.class)
	public void testAddFirstInvalidNo()throws InValidNoRangeException{
		services.add(inValidNum1, validNum2);
	}
	
	@Test(expected=InValidNoRangeException.class)
	public void testAddSecondInvalidNo()throws InValidNoRangeException{
		services.add(inValidNum1, inValidNum2);
	}
	
	@Test
	public void testAddForValidNo()throws InValidNoRangeException{
		int actualAns=services.add(validNum1, validNum2);
		expectedAns=30;
		Assert.assertEquals(expectedAns, actualAns);
	}
	
	@Test(expected=InValidNoRangeException.class)
	public void testSubFirstInvalidNo()throws InValidNoRangeException{
		services.subs(inValidNum1, validNum2);
	}
	
	@Test(expected=InValidNoRangeException.class)
	public void testSubSecondInvalidNo()throws InValidNoRangeException{
		services.subs(inValidNum1, inValidNum2);
	}
	
	@Test
	public void testSubForValidNo()throws InValidNoRangeException{
		int actualAns=services.subs(validNum1, validNum2);
		expectedAns=-10;
		Assert.assertEquals(expectedAns, actualAns);
	}
	
	@Test(expected=InValidNoRangeException.class)
	public void testDivFirstInvalidNo()throws InValidNoRangeException{
		services.div(inValidNum1, validNum2);
	}
	
	@Test(expected=InValidNoRangeException.class)
	public void testDivSecondInvalidNo()throws InValidNoRangeException{
		services.div(validNum1, inValidNum2);
	}
	
	@Test
	public void testDivForValidNo()throws InValidNoRangeException{
		int actualAns=services.div(validNum1, validNum2);
		expectedAns=0;
		Assert.assertEquals(expectedAns, actualAns);
	}
	
	
	@After
	public void tearDownMockData(){
		validNum1=10;
		validNum2=20;
		inValidNum1=-10;
		inValidNum2=-15;
		expectedAns=0;
	}
	@AfterClass
	public static void tearDownTestEnv(){
		services=null;
	}
}
