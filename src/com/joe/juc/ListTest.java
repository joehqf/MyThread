package com.joe.juc;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList �̰߳�ȫ��List����
 * 
 * @author hqf12
 *
 */
public class ListTest {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
}
