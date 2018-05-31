package com.cg.services;

public class GreetingServicesImpl implements GreetingServices{

	@Override
	public void sayHello(String personName) {
		System.out.println("Hello "+personName);
	}
	@Override
	public void sayGoodBye(String personName) {
		System.out.println("Bye "+personName);
	}
}
