package com.joe.volat;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile�������sync
 *
 */
public class ���ܱ�֤ԭ���� {

	volatile int count = 0;

	private void m() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public static void main(String[] args) {

		���ܱ�֤ԭ���� c = new ���ܱ�֤ԭ����();
		List<Thread> ts = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			ts.add(new Thread(c::m, "�߳�" + i));
		}

		ts.forEach((item) -> item.start());
		ts.forEach((item) -> {
			try {
				item.join();// ��ִ֤���������߳�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println(c.count);
	}
}
