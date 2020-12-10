package com.joe.thread.syn;

/**
 * 测试脏读 对写方法加锁,对读方法不加锁,会不会有问题
 *
 */
public class TestRead {
	public static void main(String[] args) {
		Bank bank = new Bank();
		new Thread(() -> {
			bank.savings("小何", 130.0);
		}, "写线程").start();

		new Thread(() -> {
			Double read = bank.read("小何");
			System.out.println(read);
		}, "读线程").start();
	}
}

/**
 * 银行
 */
class Bank {

	Account account = new Account("小何", 100.0);

	synchronized public void savings(String name, Double je) {
		if (name.equals(account.getName())) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.setJe(je);
		}
	}

	/* synchronized */ public Double read(String name) {
		if (name.equals(account.getName())) {
			return account.getJe();
		}
		return 0.0;
	}
}

/**
 * 账户
 */
class Account {

	String name;
	Double je;

	public Account(String name, Double je) {
		super();
		this.name = name;
		this.je = je;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getJe() {
		return je;
	}

	public void setJe(Double je) {
		this.je = je;
	}

}