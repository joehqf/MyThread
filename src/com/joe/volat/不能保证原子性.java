package com.joe.volat;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile不能替代sync
 *
 */
public class 不能保证原子性 {

	volatile int count = 0;

	private void m() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public static void main(String[] args) {

		不能保证原子性 c = new 不能保证原子性();
		List<Thread> ts = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			ts.add(new Thread(c::m, "线程" + i));
		}

		ts.forEach((item) -> item.start());
		ts.forEach((item) -> {
			try {
				item.join();// 保证执行所有子线程
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println(c.count);
	}
}
