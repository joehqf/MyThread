package com.joe.designmode.behavior.template;

/**
 * 子类实现模板方法：取款
 */
public class DrawMoney extends BankTemplateMethod {
	@Override
	public void transact() {
		System.out.println("我要取款");
	}

}
