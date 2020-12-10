package com.joe.designmode.structural.proxy;

/**
 * 真实角色（明星艺人）：
 */
public class RealStar implements Star {
	@Override
	public void confer() {
		System.out.println("我不想做");
	}

	@Override
	public void signContract() {
		System.out.println("我不想做");
	}

	@Override
	public void bookTicket() {
		System.out.println("我不想做");
	}

	@Override
	public void sing() {
		System.out.println("我只负责唱个歌");// 真实角色的操作：真正的业务逻辑
	}

	@Override
	public void collectMoney() {
		System.out.println("我不想做");
	}

}
