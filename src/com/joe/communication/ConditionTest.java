package com.joe.communication;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest<T> {

	final LinkedList<T> lists = new LinkedList<>();
	final int MAX = 10;
	int count = 0;

	Lock lock = new ReentrantLock();
	Condition producer = lock.newCondition();
	Condition consumer = lock.newCondition();

	public void put(T t) {
		try {
			lock.lock();
			while (lists.size() == MAX) {
				try {
					producer.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			lists.add(t);
			++count;
			System.out.println("������" + t);
			consumer.signalAll();// ֪ͨ����������
		} finally {
			lock.unlock();
		}
	}

	public T sub() {
		T remove = null;
		try {
			lock.lock();
			while (lists.size() == 0) {
				try {
					consumer.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			remove = lists.removeFirst();
			count--;
//			System.out.println("����" + remove);
			producer.signalAll();// ֪ͨ����������
		} finally {
			lock.unlock();
		}
		return remove;
	}

	public static void main(String[] args) {
		ConditionTest<String> c = new ConditionTest<String>();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int j = 0; j < 5; j++) {
					System.out.println("����" + c.sub());
				}
			}, "s" + i).start();
		}

		for (int i = 0; i < 2; i++) {
			new Thread(() -> {
				for (int j = 0; j < 25; j++) {
					c.put(Thread.currentThread().getName() + j);
				}
			}, "p" + i).start();
		}
	}
}
