package com.joe.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lockInterruptibly ����ǿռ����
 */
public class InterruptTest {

	final ReentrantLock lock = new ReentrantLock();

	private void m() {
		try {
			lock.lock();
			System.out.println("m������ʼ...");
			try {
				Thread.sleep(Integer.MAX_VALUE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("m��������...");
		} finally {
			lock.unlock();
		}
	}

	private void m2() {
		try {
			try {
				lock.lockInterruptibly();// ��Interrupt()����������Ӧ
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("m2������ʼ...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("m2��������...");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		InterruptTest c = new InterruptTest();
		new Thread(c::m).start();
		Thread t2 = new Thread(c::m2);
		t2.start();

		t2.interrupt();// ����߳�2�ĵȴ�
	}
}
