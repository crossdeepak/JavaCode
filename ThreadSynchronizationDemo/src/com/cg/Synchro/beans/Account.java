package com.cg.Synchro.beans;

public class Account {
	private static int SUCCESS, FAIL=0;
	private volatile int balance;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account(int balance) {
		super();
		this.balance = balance;
	}
	public synchronized int deposit(int amount){
		balance=balance+amount;
		this.notify();
		this.notifyAll();
		return balance;
	}
	public synchronized int withdraw(int amount) throws InterruptedException{
		if(balance<0||(getBalance()-amount)<0){
			this.wait(8000);
		}
		else{
			balance=balance-amount;
		}
		return balance;
	}
}
