package com.joe.communication;

public class 信号灯法 {

	public static void main(String[] args) {
		产品 cp = new 产品();
		new 生产者2(cp).start();
		new 消费者2(cp).start();
	}
}

class 生产者2 extends Thread {
	产品 hcq;

	public 生产者2(产品 hcq) {
		this.hcq = hcq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			hcq.push("节目" + i);
		}
	}
}

class 消费者2 extends Thread {
	产品 hcq;

	public 消费者2(产品 hcq) {
		this.hcq = hcq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			hcq.pop();
		}
	}
}

class 产品 {

	boolean flag = true;// 信号灯
	String pro;

	// 生产者 添加产品
	synchronized public void push(String str) {
		if (!flag) {
			// 如果容器满了,则通知消费者消费, 生产等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = !flag;
		System.out.println("生产:" + str);
		pro = str;
//			this.notifyAll();
		this.notify();
	}

//	消费者消费产品
	synchronized public void pop() {
		if (flag) {
			// 通知生产,消费者等待,
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费:" + pro);
		flag = !flag;
		// this.notifyAll();
		this.notify();// 唤醒别的线程,但不释放锁
	}

}