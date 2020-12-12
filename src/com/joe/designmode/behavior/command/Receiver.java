package com.joe.designmode.behavior.command;

/**
 * 接收者：真正执行命令的对象
 */
public class Receiver {
	public void action() {
		System.out.println("命令执行了.......");
	}
}
