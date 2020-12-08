package com.joe.thread.syn;

/**
 * 异常会导致锁释放
 * 
 */
public class 异常情况 {

	static Integer count = 10;

	synchronized private void m() {
		while (true) {
			count--;
			System.out.println(Thread.currentThread().getName() + "~" + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count == 5) {
				int jg = 1 / 0;
				System.out.println(jg);
			}
		}
	}

	public static void main(String[] args) {
		异常情况 c = new 异常情况();
		new Thread(c::m, "线程1").start();
		new Thread(c::m, "线程2").start();
	}
}
