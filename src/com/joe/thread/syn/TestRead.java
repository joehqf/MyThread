package com.joe.thread.syn;

/**
 * ������� ��д��������,�Զ�����������,�᲻��������
 *
 */
public class TestRead {
	public static void main(String[] args) {
		Bank bank = new Bank();
		new Thread(() -> {
			bank.savings("С��", 130.0);
		}, "д�߳�").start();

		new Thread(() -> {
			Double read = bank.read("С��");
			System.out.println(read);
		}, "���߳�").start();
	}
}

/**
 * ����
 */
class Bank {

	Account account = new Account("С��", 100.0);

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
 * �˻�
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