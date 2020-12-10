package com.joe.designmode.structural.adapter;

/**
 * 测试对象适配器模式,将一个类的接口转换成客户希望的另外一个接口。 Adapter模式使得原本由于接口不兼容而不能一起工作的类可以一起工作。
 */
public class Client {
	public void test1(Target t) {
		t.handleReq();
	}

	public static void main(String[] args) {
		Client c = new Client();
		Adaptee a = new Adaptee();
		Target t = new Adapter(a);// 需要传入适配器
		c.test1(t);
	}
}
