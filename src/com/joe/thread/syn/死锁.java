package com.joe.thread.syn;

/**
 * 死锁需要满足四个条件
 * 
 * @author hqf12
 *
 */
public class 死锁 {

	static String jz = "镜子";
	static String kh = "口红";

	public static void main(String[] args) {

		new Thread(() -> {
			synchronized (jz) {
				System.out.println("获得镜子锁");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (kh) {
					System.out.println("获得口红锁");
				}
			}
		}).start();

		new Thread(() -> {
			synchronized (kh) {
				System.out.println("获得口红锁");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (jz) {
					System.out.println("获得镜子锁");
				}
			}
		}).start();
	}
}
