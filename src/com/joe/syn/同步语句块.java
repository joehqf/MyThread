package com.joe.syn;

public class ͬ������ implements Runnable {

	@Override
	synchronized public void run() {
		System.out.println(Thread.currentThread().getName() + " ��ʼ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " ����");
	}

	public static void main(String[] args) {

		ͬ������ target = new ͬ������();
		Thread t1 = new Thread(target, "�߳�1");
		Thread t2 = new Thread(target, "�߳�2");

		t1.start();
		t2.start();

	}

}
