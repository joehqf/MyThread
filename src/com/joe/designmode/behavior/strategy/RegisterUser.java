package com.joe.designmode.behavior.strategy;

/**
 * 具体的算法:注册用户：打9折
 */
public class RegisterUser implements Strategy {
	@Override
	public double getPrice(double price) {
		System.out.println("注册用户：打9折");
		return price * 0.9;
	}
}
