package com.joe.thread.create;

public class Way2Runnable implements Runnable {
	int i = 10;

	@Override
	public void run() {
		while (true) {
			if (i < 1) {
				break;
			}
			System.out.println(Thread.currentThread().getName() + "ʣ��" + i + "Ʊ");
			i--;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Way2Runnable ra = new Way2Runnable();
		Thread t1 = new Thread(ra, "�߳�1");
		System.out.println("�߳�1�Ƿ���:" + t1.isAlive());
		System.out.println("�߳�1״̬:" + t1.getState());
		t1.start();
		System.out.println("�߳�1״̬:" + t1.getState());
		Thread.sleep(1000);
		System.out.println("�߳�1�Ƿ���:" + t1.isAlive());
		System.out.println("�߳�1״̬:" + t1.getState());
		Thread t3 = new Thread(ra, "�߳�3");
		t3.start();
//		Thread t2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 10; i++) {
//					System.out.println(Thread.currentThread().getName() + "~" + i);
//				}
//			}
//		});
//		t2.start();

	}
}
