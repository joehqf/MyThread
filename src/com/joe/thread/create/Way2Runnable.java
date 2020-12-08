package com.joe.thread.create;

public class Way2Runnable implements Runnable {
	int i = 10;

	@Override
	public void run() {
		while (true) {
			if (i < 1) {
				break;
			}
			System.out.println(Thread.currentThread().getName() + "剩下" + i + "票");
			i--;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Way2Runnable ra = new Way2Runnable();
		Thread t1 = new Thread(ra, "线程1");
		System.out.println("线程1是否存活:" + t1.isAlive());
		System.out.println("线程1状态:" + t1.getState());
		t1.start();
		System.out.println("线程1状态:" + t1.getState());
		Thread.sleep(1000);
		System.out.println("线程1是否存活:" + t1.isAlive());
		System.out.println("线程1状态:" + t1.getState());
		Thread t3 = new Thread(ra, "线程3");
		t3.start();
//		Thread t2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 10; i++) {
//					System.out.println(Thread.currentThread().getName() + "~" + i);
//				}
//			}
//		});
//		t2.start();

	}
}
