package com.joe.volat;

/**
 * volatile 1.��֤�߳̿ɼ���(ԭ��:MESI,����һ����Э��) ,
 * 2.��ָֹ��������(����ģʽ��˫�طǿռ��,instance��Ҫ��volatile)
 */
public class �ɼ��� {

	volatile boolean flag = true;

	private void m() {
		System.out.println(Thread.currentThread().getName() + "��ʼ....");
		while (flag) {
//			System.out.println("11");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println(Thread.currentThread().getName() + "����....");
	}

	public static void main(String[] args) {
		�ɼ��� c = new �ɼ���();
		new Thread(c::m, "�߳�1").start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.flag = false;
	}
}
