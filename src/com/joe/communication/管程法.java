package com.joe.communication;

/**
 * 消费者/生产者,利用缓冲区解决:管程法
 *
 */
public class 管程法 {

}

class 消费者 {

}

class 生产者 {

}

class 缓冲区 {
	产品[] cps = new 产品[10];
	int count = 0;// 容器计数器

	// 生产者 添加产品
	public void push(产品 cp) {
		if (count == cps.length) {
			// 如果容器满了,则通知消费者消费等待, 生产等待
		}
		cps[count] = cp;
		count++;
	}
}

class 产品 {

}