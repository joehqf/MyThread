package com.joe.communication;

public class �źŵƷ� {

	public static void main(String[] args) {
		��Ʒ cp = new ��Ʒ();
		new ������2(cp).start();
		new ������2(cp).start();
	}
}

class ������2 extends Thread {
	��Ʒ hcq;

	public ������2(��Ʒ hcq) {
		this.hcq = hcq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			hcq.push("��Ŀ" + i);
		}
	}
}

class ������2 extends Thread {
	��Ʒ hcq;

	public ������2(��Ʒ hcq) {
		this.hcq = hcq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			hcq.pop();
		}
	}
}

class ��Ʒ {

	boolean flag = true;// �źŵ�
	String pro;

	// ������ ��Ӳ�Ʒ
	synchronized public void push(String str) {
		if (!flag) {
			// �����������,��֪ͨ����������, �����ȴ�
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
		System.out.println("����:" + str);
		pro = str;
//			this.notifyAll();
		this.notify();
	}

//	���������Ѳ�Ʒ
	synchronized public void pop() {
		if (flag) {
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
		System.out.println("����:" + pro);
		flag = !flag;
		// this.notifyAll();
		this.notify();// ���ѱ���߳�,�����ͷ���
	}

}