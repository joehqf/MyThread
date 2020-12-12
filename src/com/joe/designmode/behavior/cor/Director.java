package com.joe.designmode.behavior.cor;

/**
 * 主任对象：处理小于等于3天的假期
 */
public class Director extends Leader {
	public Director(String name) {
		super(name);
	}

	/**
	 * 责任链上对象对请求的具体处理
	 */
	@Override
	public void handleRequest(LeaveRequest leader) {
		System.out.println("请假人：" + leader.getEmpName() + ",天数：" + leader.getLeaveDays() + ",理由：" + leader.getReason());
		if (leader.getLeaveDays() <= 3) {
			System.out.println("审批人：" + this.name + " 主任，审批通过！");
		} else {
			System.out.println("同意,但是我没有权利批,请求上一级...");
			if (this.nextLeader != null) {// 如果有下一个继承者
				// 让下一个继承者处理请求
				this.nextLeader.handleRequest(leader);
			}
		}
	}

}
