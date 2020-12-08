package com.joe.thread.communication;

/**
 * 消费者/生产者,利用缓冲区解决:管程法
 *
 */
public class 管程法 {

	public static void main(String[] args) {
		缓冲区 hcq = new 缓冲区();
		new 生产者(hcq).start();
		new 消费者(hcq).start();

	}
}

class 消费者 extends Thread {
	缓冲区 hcq;

	public 消费者(缓冲区 hcq) {
		this.hcq = hcq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			int pop = hcq.pop();
			System.out.println("消费值:" + pop);
		}
	}
}

class 生产者 extends Thread {
	缓冲区 hcq;

	public 生产者(缓冲区 hcq) {
		this.hcq = hcq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("生产");
			hcq.push();
		}
	}
}

class 缓冲区 {
	int count = 0;// 容器计数器

	// 生产者 添加产品
	synchronized public void push() {
		if (count == 10) {
			// 如果容器满了,则通知消费者消费, 生产等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		count++;
//		this.notifyAll();
		this.notify();
	}

//	消费者消费产品
	synchronized public int pop() {
		if (count == 0) {
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
		count--;
//		this.notifyAll();
		this.notify();
		return count;
	}
}
