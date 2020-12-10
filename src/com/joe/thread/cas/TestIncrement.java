package com.joe.thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 测试几种集中方式自增效率 LongAdder - 使用分段锁
 */
public class TestIncrement {

	int count = 0;
	AtomicInteger count2 = new AtomicInteger(0);
	LongAdder count3 = new LongAdder();

	private void m() {
		for (int i = 0; i < 1000; i++) {
			synchronized (this) {
				count++;
			}
		}
	}

	private void m2() {
		for (int i = 0; i < 1000; i++) {
			count2.incrementAndGet();
		}
	}

	private void m3() {
		for (int i = 0; i < 1000; i++) {
			count3.increment();
		}
	}

	public static void main(String[] args) {
		TestIncrement c = new TestIncrement();

		List<Thread> ts = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			ts.add(new Thread(c::m));
		}
		long begin = System.currentTimeMillis();
		ts.forEach((item) -> item.start());
		ts.forEach((item) -> {
			try {
				item.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end = System.currentTimeMillis();
		System.out.println("sync:" + c.count + " 耗时:" + (end - begin));

		List<Thread> ts2 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			ts2.add(new Thread(c::m2));
		}
		long begin2 = System.currentTimeMillis();
		ts2.forEach((item) -> item.start());
		ts2.forEach((item) -> {
			try {
				item.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end2 = System.currentTimeMillis();
		System.out.println("atomic:" + c.count2 + " 耗时:" + (end2 - begin2));

		List<Thread> ts3 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			ts3.add(new Thread(c::m3));
		}
		long begin3 = System.currentTimeMillis();
		ts3.forEach((item) -> item.start());
		ts3.forEach((item) -> {
			try {
				item.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end3 = System.currentTimeMillis();
		System.out.println("LongAdder:" + c.count3 + " 耗时:" + (end3 - begin3));

	}
}
