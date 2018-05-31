package com.cg.thread;

public class RunnableResource implements Runnable{

	@Override
	public void run() {
		Thread t=Thread.currentThread();
		for(int i=1;i<=100;i++){
			if(t.getName().equals("thread-1")){
					if(i%2==0)
						System.out.println("Even : "+i);
			}
			else if(t.getName().equals("thread-2")){
					if(i%2!=0)
						System.out.println("Odd : "+i);
			}
			}
	}
	
}
