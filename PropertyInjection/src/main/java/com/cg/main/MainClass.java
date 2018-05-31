package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.beans.Associate;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
		Associate associate1=(Associate) applicationContext.getBean("associate");
		Associate associate2=(Associate) applicationContext.getBean("associate");
		System.out.println(associate1);
		if(associate1==associate2)
			System.out.println("Same Ref");
		else
			System.out.println("Not Same");
		
		if(associate1.equals(associate2))
			System.out.println("Same Data");
		else
			System.out.println("Not Same Data");
	}

}
