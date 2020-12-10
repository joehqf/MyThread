package com.joe.thread.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {

		usingJoin();
		usingCountDownLatch();
	}

	private static void usingJoin() {

		Thread[] ts = new Thread[100];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new Thread(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		for (int j = 0; j < ts.length; j++) {
			ts[j].start();
		}
		for (int i = 0; i < ts.length; i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("join 结束");
	}

	private static void usingCountDownLatch() {

		Thread[] ts = new Thread[100];
		CountDownLatch latch = new CountDownLatch(ts.length);
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new Thread(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				latch.countDown();
			});
		}
		for (int j = 0; j < ts.length; j++) {
			ts[j].start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("latch 结束");
	}
}
