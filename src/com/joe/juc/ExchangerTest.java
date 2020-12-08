package com.joe.juc;

import java.util.concurrent.Exchanger;

/**
 * �߳̽�������
 */
public class ExchangerTest {

	static Exchanger<String> changer = new Exchanger<>();

	public static void main(String[] args) {

		new Thread(() -> {
			String val = "�߳�1";
			try {
				val = changer.exchange(val);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + val);
		}, "T1").start();

		new Thread(() -> {
			String val = "�߳�2";
			try {
				val = changer.exchange(val);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + val);
		}, "T2").start();
	}
}
