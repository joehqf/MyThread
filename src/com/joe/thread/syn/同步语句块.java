package com.joe.thread.syn;

/**
 * 同步语句块, 锁住需要增删改的对象
 * 
 * @author hqf12
 *
 */
public class 同步语句块 implements Runnable {

	Integer count = 10;

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			String name = Thread.currentThread().getName();
			System.out.println(name + "  当前值:" + count);
			synchronized (count) {
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

		t1.start();
		t2.start();

	}

}
