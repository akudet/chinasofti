package test.controller.service;

import demo.controller.service.impl.UserServiceImpl;

public class UserServiceTest {
	
	public static void main(String[] args) {
		UserServiceImpl us = new UserServiceImpl();
		System.out.println(us.login("jtwu", ""));
	}

}
