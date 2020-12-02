package com.joe.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程变量不共享
 * 
 * @author hqf12
 *
 */
public class Way3Callable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		double random = Math.random() * 10;
		System.out.println(Thread.currentThread().getName() + "!" + random);
		return (int) random;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Way3Callable call = new Way3Callable();
		// 1.创建线程池
		ExecutorService es = Executors.newFixedThreadPool(2);
		// 2.提交执行
		Future<Integer> submit = es.submit(call);
		Future<Integer> submit2 = es.submit(call);
		// 3.获取结果
		Integer integer = submit.get();
		Integer integer2 = submit2.get();
		System.out.println(integer);
		System.out.println(integer2);
		// 4.关闭服务
		es.shutdown();
	}

}
