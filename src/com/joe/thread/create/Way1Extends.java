package com.joe.thread.create;

/**
 * �̱߳���������
 * 
 * @author hqf12
 *
 */
public class Way1Extends extends Thread {

	int i = 10;

	public Way1Extends(String name) {
		super.setName(name);
	}

	@Override
	public void run() {
		while (true) {
			if (i < 1) {
				break;
			}
			System.out.println(Thread.currentThread().getName() + "~" + i + "Ʊ");
			i--;
		}
	}

	public static void main(String[] args) {
		Way1Extends way = new Way1Extends("����1");
		Way1Extends way2 = new Way1Extends("����2");
		Way1Extends way3 = new Way1Extends("����3");
		way.start();
		way2.start();
		way3.start();
	}
}
