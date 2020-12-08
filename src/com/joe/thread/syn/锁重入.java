package com.joe.thread.syn;

/**
 * 关键字synchronized拥有锁重入的功能，
 * 也就是在使用synchronized时，当一个线程得到一个对象锁后，再次请求此对象锁时是可以再次得到该对象的锁的。
 * 这也证明在一个synchronized方法/块的内部调用本类的其他synchronized方法/块时，是永远可以得到锁的。
 * 当存在父子类继承关系时，子类是完全可以通过“可重入锁”调用父类的同步方法的。
 * 
 * 出现异常,锁自动释放
 */
public class 锁重入 implements Runnable {

	synchronized public void sayA() {
		System.out.println("A");
		sayB();
	}

	synchronized public void sayB() {
		System.out.println("B");
	}

	@Override
	public void run() {
		sayA();
	}

	public static void main(String[] args) {
		锁重入 runa = new 锁重入();
		Thread t1 = new Thread(runa, "重入锁");
		Thread t2 = new Thread(runa, "重入锁2");
		t1.start();
		t2.start();
	}
}
