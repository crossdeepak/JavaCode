package com.cg.services;

import org.springframework.stereotype.Component;

@Component("greetingServices")
public class GreetingServicesNewImpl implements GreetingServices{

	public GreetingServicesNewImpl() {
		System.out.println("GreetingServicesNewImpl");
	}
	
	@Override
	public void sayHello(String personName) {
		System.out.println("Hello "+personName);
	}

	@Override
	public void sayGoodBye(String personName) {
		System.out.println("Bye "+personName);
	}

}
