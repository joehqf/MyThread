package com.joe.thread.syn;

/**
 * synchronized修饰方法,默认锁住this对象
 * 
 * @author hqf12
 *
 */
public class 同步方法 implements Runnable {
	int count = 10;

//	@Override
//	synchronized public void run() {
//		for (int i = 0; i < 10; i++) {
//			String name = Thread.currentThread().getName();
//			System.out.println(name + "  当前值:" + count);
//			if ("减线程".equals(name)) {
//				count--;
//			} else {
//				count++;
//			}
//
//		}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				String name = Thread.currentThread().getName();
				System.out.println(name + "  当前值:" + count);
				if ("减线程".equals(name)) {
					count--;
				} else {
					count++;
				}

			}
		}

	}

	public static void main(String[] args) {

		同步方法 target = new 同步方法();

		Thread t1 = new Thread(target, "减线程");
		Thread t2 = new Thread(target, "加线程");

		同步方法 target2 = new 同步方法();
		Thread t3 = new Thread(target2, "加线程");

		t1.start();
		t2.start();
//		t3.start();

	}

}
