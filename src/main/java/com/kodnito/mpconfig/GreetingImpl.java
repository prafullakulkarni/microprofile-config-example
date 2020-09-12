package com.kodnito.mpconfig;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GreetingImpl implements Greeting {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello from Greeting 1234567891011";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
