package com.joe.thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 栅栏
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(20, () -> {
			System.out.println("满20个线程,执行该方法!");
		});

		for (int i = 0; i < 60; i++) {
			new Thread(() -> {
				try {
					cb.await();
					System.out.println(Thread.currentThread().getName());// 满足条件才会执行方法
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
