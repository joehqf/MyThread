package com.joe.thread.communication;

/**
 * ������/������,���û��������:�̷ܳ�
 *
 */
public class �̷ܳ� {

	public static void main(String[] args) {
		������ hcq = new ������();
		new ������(hcq).start();
		new ������(hcq).start();

	}
}

class ������ extends Thread {
	������ hcq;

	public ������(������ hcq) {
		this.hcq = hcq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			int pop = hcq.pop();
			System.out.println("����ֵ:" + pop);
		}
	}
}

class ������ extends Thread {
	������ hcq;

	public ������(������ hcq) {
		this.hcq = hcq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("����");
			hcq.push();
		}
	}
}

class ������ {
	int count = 0;// ����������

	// ������ ��Ӳ�Ʒ
	synchronized public void push() {
		if (count == 10) {
			// �����������,��֪ͨ����������, �����ȴ�
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

//	���������Ѳ�Ʒ
	synchronized public int pop() {
		if (count == 0) {
			// ֪ͨ����,�����ߵȴ�,
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
