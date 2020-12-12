package com.joe.designmode.behavior.strategy;

/**
 * 具体的算法:普通用户，不打折
 */
public class GeneralUser implements Strategy {
	@Override
	public double getPrice(double price) {
		System.out.println("普通用户，不打折");
		return price;
	}
}
