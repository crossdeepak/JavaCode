package com.cg.Synchro.main;

import com.cg.Synchro.beans.Customer;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		Thread th1=new Thread(new Customer(),"rahul");
		Thread th2=new Thread(new Customer(),"anil");
		Thread th3=new Thread(new Customer(),"satish");
		th1.start();
//		th1.join();
		th2.start();
		th3.start();
	}

}
