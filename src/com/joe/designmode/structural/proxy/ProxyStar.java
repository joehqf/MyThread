package com.joe.designmode.structural.proxy;

/**
 * 代理角色（明星经纪人）：
 */
public class ProxyStar implements Star {
	private Star star;// 真实对象的引用（明星）

	public ProxyStar(Star star) {// 通过构造器给真实角色赋值
		this.star = star;
	}

	@Override
	public void confer() {
		System.out.println("谈谈");
	}

	@Override
	public void signContract() {
		System.out.println("签合同la ");
	}

	@Override
	public void bookTicket() {
		System.out.println("订票");
	}

	@Override
	public void sing() {
		star.sing();// 真实对象的操作（明星唱歌）
	}

	@Override
	public void collectMoney() {
		System.out.println("收尾款");
	}
}
