package com.joe.thread.lock;

/**
 * 锁的显式调用
 */
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	static int count = 10;

	public static void main(String[] args) {
		final ReentrantLock lock = new ReentrantLock();
		Runnable run = () -> {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					count--;
					System.out.println(Thread.currentThread().getName() + "~" + count);
				}
			} finally {
				lock.unlock();
			}
		};
		new Thread(run, "线程1").start();
		new Thread(run, "线程2").start();
	}
}
