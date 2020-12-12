package com.joe.designmode.behavior.strategy;

/**
 * 具体的算法：老会员：打5折
 */
public class OldVip implements Strategy {
	@Override
	public double getPrice(double price) {
		System.out.println("老会员：打5折");
		return price * 0.5;
	}
}
