package com.cg.thread;

public class MyThread extends Thread{

	public MyThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for(int i=1;i<=100;i++){
		if(this.getName().equals("thread-1")){
				if(i%2==0)
					System.out.println(i);
		}
		else if(this.getName().equals("thread-2")){
				if(i%2!=0)
					System.out.println(i);
		}
		}
	}
	
	
}
