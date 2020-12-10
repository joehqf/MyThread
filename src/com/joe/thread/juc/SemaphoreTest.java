package com.joe.thread.juc;

import java.util.concurrent.Semaphore;

/**
 * Semaphore 信号灯 限流
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		Semaphore sema = new Semaphore(3);// 允许n个线程同时执行
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					sema.acquire();
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					sema.release();
				}
			}).start();
		}
	}
}
