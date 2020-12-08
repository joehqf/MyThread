package com.joe.thread.juc;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadWriteLockTest {

	ReentrantLock rlock = new ReentrantLock();

	static ReadWriteLock rwl = new ReentrantReadWriteLock();

	static Lock readLock = rwl.readLock();
	static Lock writeLock = rwl.writeLock();

	static int count = 0;

	private static void read(Lock lock) {
		try {
			lock.lock();
			try {
				Thread.sleep(3000);
				System.out.println("读数据: " + count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			lock.unlock();
		}
	}

	private static void write(Lock lock, int val) {
		try {
			lock.lock();
			try {
				Thread.sleep(1000);
				System.out.println("写数据: " + val);
				count = val;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				write(writeLock, new Random().nextInt());
			}).start();
		}
		for (int i = 0; i < 25; i++) {
			new Thread(() -> {
				read(readLock);
			}).start();
		}
	}
}
