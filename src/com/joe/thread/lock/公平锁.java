package com.joe.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ��ƽ�� {

	final ReentrantLock lock = new ReentrantLock(true);// ��Ϊ��ƽ��

	private void m() {
		for (int i = 0; i < 100; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName());
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		��ƽ�� c = new ��ƽ��();
		new Thread(c::m, "�߳�1").start();
		new Thread(c::m, "�߳�2").start();
	}
}
