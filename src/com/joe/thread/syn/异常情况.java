package com.joe.thread.syn;

/**
 * �쳣�ᵼ�����ͷ�
 * 
 */
public class �쳣��� {

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
		�쳣��� c = new �쳣���();
		new Thread(c::m, "�߳�1").start();
		new Thread(c::m, "�߳�2").start();
	}
}
