package com.joe.juc;

import java.util.concurrent.Exchanger;

/**
 * 线程交换数据
 */
public class ExchangerTest {

	static Exchanger<String> changer = new Exchanger<>();

	public static void main(String[] args) {

		new Thread(() -> {
			String val = "线程1";
			try {
				val = changer.exchange(val);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + val);
		}, "T1").start();

		new Thread(() -> {
			String val = "线程2";
			try {
				val = changer.exchange(val);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + val);
		}, "T2").start();
	}
}
