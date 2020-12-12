package com.joe.designmode.behavior.command;

public class Invoker {
	private Command command;// 持有命令对象的引用

	public Invoker(Command command) {
		this.command = command;
	}

	public void call() {
		// 请求者调用命令对象执行命令的那个execute方法
		command.execute();
	}
}
