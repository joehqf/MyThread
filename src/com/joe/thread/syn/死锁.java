package com.joe.thread.syn;

/**
 * ������Ҫ�����ĸ�����
 * 
 * @author hqf12
 *
 */
public class ���� {

	static String jz = "����";
	static String kh = "�ں�";

	public static void main(String[] args) {

		new Thread(() -> {
			synchronized (jz) {
				System.out.println("��þ�����");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (kh) {
					System.out.println("��ÿں���");
				}
			}
		}).start();

		new Thread(() -> {
			synchronized (kh) {
				System.out.println("��ÿں���");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (jz) {
					System.out.println("��þ�����");
				}
			}
		}).start();
	}
}
