package com.joe.designmode.behavior.strategy;

/**
 * 定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化不会影响到使用算法的客户
 */
public class Test {

	public static void main(String[] args) {
		double price = 998;// 商品价格
		Strategy generalUser = new GeneralUser();// 普通用户
		Strategy registerUser = new RegisterUser();// 注册用户
		Strategy registerVip = new RegisterVip();// 普通会员
		Strategy oldVip = new OldVip();// 老会员

		// 根据不同的用户打不同的折扣
		Context c1 = new Context(generalUser);
		c1.printPrice(price);
		Context c2 = new Context(registerUser);
		c2.printPrice(price);
		Context c3 = new Context(registerVip);
		c3.printPrice(price);
		Context c4 = new Context(oldVip);
		c4.printPrice(price);
	}

}
