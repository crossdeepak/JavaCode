package com.cg.thread;

public class MainClass {

	public static void main(String[] args) {

        //Thread		
		
		/*		MyThread th1=new MyThread("thread-1");
		MyThread th2=new MyThread("thread-2");
		th1.start();
		th2.start();
*/


		//Runnable Interface		
		
	RunnableResource resource=new RunnableResource();
	Thread th1=new Thread(resource, "thread-1");
	Thread th2=new Thread(resource, "thread-2");
	th1.start();
	th2.start();
	}
		

}
