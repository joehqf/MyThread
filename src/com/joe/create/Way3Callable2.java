package com.joe.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author hqf12
 *
 */
public class Way3Callable2 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		double random = Math.random() * 10;
		System.out.println(Thread.currentThread().getName() + "!" + random);
		return (int) random;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Way3Callable2 call = new Way3Callable2();

		FutureTask<Integer> task = new FutureTask<>(call);
		new Thread(task).start();
		Integer integer = task.get();
		System.out.println(integer);
	}
}
