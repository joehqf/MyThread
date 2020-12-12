package com.joe.designmode.behavior.command;

/**
 * 具体命令类需要持有真正执行命令的那个对象。
 */
public class ConcreteCommand implements Command {
	private Receiver receiver;// 持有真正执行命令对象的引用

	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// 调用接收者执行命令的方法
		receiver.action();
	}

}
