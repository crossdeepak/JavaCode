package com.cg.Synchro.beans;

public class Customer implements Runnable{
	private static Account account;
	static{
		account=new Account(10000);
		System.out.println("Initial Balance : " +account.getBalance()
		+"\n\n---------------------");
	}
	@Override
	public void run() {
		Thread customerThread=Thread.currentThread();
		if(customerThread.getName().equals("rahul")){
			for(int i=1;i<=10;i++){
				try{
					Thread.sleep(0);
					System.out.println("\nRahul has called withdraw() "+ i
							+" time balance : "+account.withdraw(3000));
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		if(customerThread.getName().equals("anil")){
			for(int i=1;i<=10;i++){
				try{
					Thread.sleep(0);
					System.out.println("\nAnil has called deposit() "+ i
							+" time balance : "+account.deposit(2000));
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		if(customerThread.getName().equals("satish")){
			for(int i=1;i<=3;i++){
				try{
					Thread.sleep(0);
					System.out.println("\nSatish has called check balance "+ i
							+" time balance : "+account.getBalance());
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
}
