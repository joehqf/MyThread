package com.joe.designmode.creational.singleton;

/**
 */
public class SingletonTest {

	private SingletonTest() {
	}

	private static final SingletonTest instance = new SingletonTest();

	public static SingletonTest getInstance() {
		return instance;
	}

}
