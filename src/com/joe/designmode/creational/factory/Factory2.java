package com.joe.designmode.creational.factory;

public class Factory2 implements IFactory {

	@Override
	public IProduct createProduct() {
		return new Product2();
	}

}
