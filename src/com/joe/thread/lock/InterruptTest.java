package com.joe.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lockInterruptibly 可以强占的锁
 */
public class InterruptTest {

	final ReentrantLock lock = new ReentrantLock();

	private void m() {
		try {
			lock.lock();
			System.out.println("m方法开始...");
			try {
				Thread.sleep(Integer.MAX_VALUE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("m方法结束...");
		} finally {
			lock.unlock();
		}
	}

	private void m2() {
		try {
			try {
				lock.lockInterruptibly();// 对Interrupt()方法做出响应
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("m2方法开始...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("m2方法结束...");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		InterruptTest c = new InterruptTest();
		new Thread(c::m).start();
		Thread t2 = new Thread(c::m2);
		t2.start();

		t2.interrupt();// 打断线程2的等待
	}
}
