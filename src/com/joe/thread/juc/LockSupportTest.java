package com.joe.thread.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport线程支持
 */
public class LockSupportTest {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
				if (i == 5) {
					LockSupport.park();
				}
			}
		});
		t.start();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LockSupport.unpark(t);
	}
}
