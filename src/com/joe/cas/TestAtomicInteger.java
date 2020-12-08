package com.joe.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicXXX�౾����ԭ���Ե�,�����ܱ�֤�����������������ԭ���Ե�
 */
public class TestAtomicInteger {

	AtomicInteger count = new AtomicInteger(0);

	private void m() {
		for (int i = 0; i < 100; i++) {
			count.incrementAndGet();// �ۼӲ�����
		}
	}

	public static void main(String[] args) {
		TestAtomicInteger c = new TestAtomicInteger();

		List<Thread> ts = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ts.add(new Thread(c::m));
		}
		ts.forEach((item) -> item.start());
		ts.forEach((item) -> {
			try {
				item.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println(c.count);
	}
}
