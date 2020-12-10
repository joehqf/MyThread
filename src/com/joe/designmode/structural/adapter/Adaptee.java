package com.joe.designmode.structural.adapter;

/**
 * 需要被适配的类（各个球员）
 */
public class Adaptee {
	public void request() {
		System.out.println("我输入220V");
	}
}
