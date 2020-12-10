package com.joe.thread.syn;

public class Test1 {

	synchronized private void m1() {
		System.out.println(Thread.currentThread().getName() + "开始执行m1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "结束执行m1");
	}

	private void m2() {
		System.out.println(Thread.currentThread().getName() + "开始执行m2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "结束执行m2");
	}

	public static void main(String[] args) {
		Test1 t = new Test1();

		new Thread(t::m1, "线程1").start();
		new Thread(t::m2, "线程2").start();
	}
}
