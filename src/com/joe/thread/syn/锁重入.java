package com.joe.thread.syn;

/**
 * �ؼ���synchronizedӵ��������Ĺ��ܣ�
 * Ҳ������ʹ��synchronizedʱ����һ���̵߳õ�һ�����������ٴ�����˶�����ʱ�ǿ����ٴεõ��ö�������ġ�
 * ��Ҳ֤����һ��synchronized����/����ڲ����ñ��������synchronized����/��ʱ������Զ���Եõ����ġ�
 * �����ڸ�����̳й�ϵʱ����������ȫ����ͨ�����������������ø����ͬ�������ġ�
 * 
 * �����쳣,���Զ��ͷ�
 */
public class ������ implements Runnable {

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
		������ runa = new ������();
		Thread t1 = new Thread(runa, "������");
		Thread t2 = new Thread(runa, "������2");
		t1.start();
		t2.start();
	}
}
