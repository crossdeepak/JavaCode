package com.cg.mobilebilling.main;

import com.cg.mobilebilling.beans.*;

public class MainClass {

	public static void main(String[] args) {
		PostPaidAccount postPaidAccount[] =new PostPaidAccount[2];
		Plan plan=new Plan(123, 100, 1, 12, 23, 45, 45, 7, 2, 7, 7, "monthly","free");
		Bill bill[]=new Bill[2];
		bill[0]=new Bill(100, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		bill[1]=new Bill(500, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		postPaidAccount[0]=new PostPaidAccount("9876543210", plan, bill);
		postPaidAccount[1]=new PostPaidAccount("9823443210", plan, bill);
		 
		Address address=new Address(713205,"Kolkata","wb","india");
		Customer customer1=new Customer();
		customer1.setCustomerID(100);
		Customer customer2 = new Customer(1234, 9876543134l, 123312331233l, "Deepak", "Muraree", "emal@abc.com", "asdf12354", "18/08/1994", postPaidAccount, address);
		Customer customer3 = new Customer(1254, 9876543134l, 123312331233l, "Cross", "Fire", "etal@abc.com", "asdf12354", "18/08/1994", postPaidAccount, address);
		System.out.println(customer2.getPostPaidAccount()[0].getPlan().getPlanID());
		System.out.println(customer1.getCustomerID());
		System.out.println(customer2.getCustomerID());
		System.out.println(customer3.getPostPaidAccount()[0].getBill()[1].getBillID());
		
		
	}
}