package com.joe.designmode.structural.proxy;

public class Client {

	/**
	 * 静态代理
	 */
	static void 一场演出(Star proxy) {
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing();// 真实对象的操作（明星唱歌）
		proxy.collectMoney();
	}

	public static void main(String[] args) {
		Star real = new RealStar();
		Star proxy = new ProxyStar(real);

		一场演出(proxy);
	}
}
