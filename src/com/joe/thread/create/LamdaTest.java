package com.joe.thread.create;

public class LamdaTest {

	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("你好");
		Thread t1 = new Thread(r1, "线程1");
		t1.start();
	}
}
