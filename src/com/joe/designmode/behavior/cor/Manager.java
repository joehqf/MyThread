package com.joe.designmode.behavior.cor;

/**
 * 经理对象：处理大于3天，小于等于10天的假期
 */
public class Manager extends Leader {
	public Manager(String name) {
		super(name);
	}

	/**
	 * 责任链上对象对请求的具体处理
	 */
	@Override
	public void handleRequest(LeaveRequest leader) {
		if (leader.getLeaveDays() <= 10) {
			System.out.println("审批人：" + this.name + " 经理，审批通过！");
		} else {
			System.out.println("同意,但是我没有权利批,请求上一级...");
			if (this.nextLeader != null) {// 如果有下一个继承者
				// 让下一个继承者处理请求
				this.nextLeader.handleRequest(leader);
			}
		}
	}

}
