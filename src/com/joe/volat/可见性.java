package com.joe.volat;

/**
 * volatile 1.保证线程可见性(原理:MESI,缓存一致性协议) ,
 * 2.禁止指令重排序(单例模式的双重非空检查,instance需要加volatile)
 */
public class 可见性 {

	volatile boolean flag = true;

	private void m() {
		System.out.println(Thread.currentThread().getName() + "开始....");
		while (flag) {
//			System.out.println("11");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println(Thread.currentThread().getName() + "结束....");
	}

	public static void main(String[] args) {
		可见性 c = new 可见性();
		new Thread(c::m, "线程1").start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.flag = false;
	}
}
