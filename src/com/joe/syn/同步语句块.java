package com.joe.syn;

public class 同步语句块 implements Runnable {

	@Override
	synchronized public void run() {
		System.out.println(Thread.currentThread().getName() + " 开始");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 结束");
	}

	public static void main(String[] args) {

		同步语句块 target = new 同步语句块();
		Thread t1 = new Thread(target, "线程1");
		Thread t2 = new Thread(target, "线程2");

		t1.start();
		t2.start();

	}

}
