package com.joe.thread.create;

public class LamdaTest {

	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("���");
		Thread t1 = new Thread(r1, "�߳�1");
		t1.start();
	}
}
