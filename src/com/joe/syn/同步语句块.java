package com.joe.syn;

/**
 * ͬ������, ��ס��Ҫ��ɾ�ĵĶ���
 * 
 * @author hqf12
 *
 */
public class ͬ������ implements Runnable {

	Integer count = 10;

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			String name = Thread.currentThread().getName();
			System.out.println(name + "  ��ǰֵ:" + count);
			synchronized (count) {
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

		t1.start();
		t2.start();

	}

}
