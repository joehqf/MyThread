package com.joe.designmode.behavior.template;

/**
 * 实现一些操作时，整体步骤很固定，但是呢。 就是其中一小部分容易变，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现。
 */
public class Test {
	public static void main(String[] args) {
		// 定义子类方式实现模板方法
		BankTemplateMethod template = new DrawMoney();
		template.process();

		// 匿名内部类的方式来实现这种模板方法
		BankTemplateMethod template1 = new BankTemplateMethod() {
			// 这里使用匿名内部类实现:只需实现具体业务部分，其他部分则使用模板方法定义好的骨架
			@Override
			public void transact() {
				System.out.println("我要存钱");
			}
		};
		template1.process();

	}
}
