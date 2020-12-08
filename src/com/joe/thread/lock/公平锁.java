package com.joe.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class 公平锁 {

	final ReentrantLock lock = new ReentrantLock(true);// 设为公平锁

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
		公平锁 c = new 公平锁();
		new Thread(c::m, "线程1").start();
		new Thread(c::m, "线程2").start();
	}
}
