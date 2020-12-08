package com.joe.syn;

public class Test1 {

	synchronized private void m1() {
		System.out.println(Thread.currentThread().getName() + "��ʼִ��m1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "����ִ��m1");
	}

	private void m2() {
		System.out.println(Thread.currentThread().getName() + "��ʼִ��m2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "����ִ��m2");
	}

	public static void main(String[] args) {
		Test1 t = new Test1();

		new Thread(t::m1, "�߳�1").start();
		new Thread(t::m2, "�߳�2").start();
	}
}
