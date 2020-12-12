package com.joe.designmode.behavior.cor;

/**
 * 总经理对象：处理大于等于10天，小于30天的请假信息
 */
public class GeneralManager extends Leader {
	public GeneralManager(String name) {
		super(name);
	}

	/**
	 * 责任链上对象对请求的具体处理
	 */
	@Override
	public void handleRequest(LeaveRequest leader) {
		if (leader.getLeaveDays() <= 30) {
			System.out.println("审批人：" + this.name + " 总经理，审批通过！");
		} else {
			// 总经理上面没人了，所以不往下发送请求。
			System.out.println("请假申请，最终不通过！最终审批人：" + this.name + "  总经理");
		}
	}

}
