package com.joe.create;

public class LamdaTest {

	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("ÄãºÃ");
		Thread t1 = new Thread(r1, "Ïß³Ì1");
		t1.start();
	}
}
