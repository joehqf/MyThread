package com.joe.designmode.behavior.strategy;

public class Context {
	private Strategy strategy;// 持有算法族的引用

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	// 打印价钱
	public void printPrice(double price) {
		System.out.println("应付金额：" + Math.round(strategy.getPrice(price)));
	}
}
