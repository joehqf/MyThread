package com.joe.designmode.creational.abstractFactory;

/**
 * all. 抽象的产品类
 */
public abstract class AbstractCreator {

	// 创建A产品家族
	public abstract AbstractProductA createProductA();

	// 创建B产品家族
	public abstract AbstractProductB createProductB();
}
