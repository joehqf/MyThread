package com.joe.designmode.behavior.mediator;

/**
 * 中介者模式的本质：解耦多个同事对象之间的交互关系，每个对象都持有中介者对象的引用。只跟中介者对象打交道。
 */
public class Client {

	public static void main(String[] args) {
		IMediator m = new President();// 构建中介者对象：总经理
		Market market = new Market(m);// 构建市场部
		Finacial finacial = new Finacial(m);// 构建财务部
		market.selfAction();
		market.outAction();// 市场部和财务部交互
		System.out.println("----");
		finacial.selfAction();
		finacial.outAction();
	}

}
