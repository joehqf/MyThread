package com.joe.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock���г�������,�����������,������������ִ��
 */
public class TryLockTest {
	final ReentrantLock lock = new ReentrantLock();

	private void m() {
		try {
			lock.lock();
			for (int i = 0; i < 6; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
		} finally {
			lock.unlock();
		}
	}

	private void m2() {
		boolean flag = false;
		try {
			try {
				flag = lock.tryLock(5, TimeUnit.SECONDS);// seconds-��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ִ��m2 " + flag);
		} finally {
			if (flag)
				lock.unlock();
		}
	}

	public static void main(String[] args) {
		TryLockTest c = new TryLockTest();

		new Thread(c::m).start();

		new Thread(c::m2).start();
	}
}
