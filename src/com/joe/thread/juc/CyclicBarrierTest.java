package com.joe.thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier դ��
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(20, () -> {
			System.out.println("��20���߳�,ִ�и÷���!");
		});

		for (int i = 0; i < 60; i++) {
			new Thread(() -> {
				try {
					cb.await();
					System.out.println(Thread.currentThread().getName());// ���������Ż�ִ�з���
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
