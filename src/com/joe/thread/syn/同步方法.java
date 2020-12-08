package com.joe.thread.syn;

/**
 * synchronized���η���,Ĭ����סthis����
 * 
 * @author hqf12
 *
 */
public class ͬ������ implements Runnable {
	int count = 10;

//	@Override
//	synchronized public void run() {
//		for (int i = 0; i < 10; i++) {
//			String name = Thread.currentThread().getName();
//			System.out.println(name + "  ��ǰֵ:" + count);
//			if ("���߳�".equals(name)) {
//				count--;
//			} else {
//				count++;
//			}
//
//		}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				String name = Thread.currentThread().getName();
				System.out.println(name + "  ��ǰֵ:" + count);
				if ("���߳�".equals(name)) {
					count--;
				} else {
					count++;
				}

			}
		}

	}

	public static void main(String[] args) {

		ͬ������ target = new ͬ������();

		Thread t1 = new Thread(target, "���߳�");
		Thread t2 = new Thread(target, "���߳�");

		ͬ������ target2 = new ͬ������();
		Thread t3 = new Thread(target2, "���߳�");

		t1.start();
		t2.start();
//		t3.start();

	}

}
