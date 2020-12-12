package com.joe.designmode.behavior.mediator;

/**
 * 抽象同事类：部门
 */
public interface IDepartment {
	void selfAction();// 做本部门的事

	void outAction();// 向总经理发出申请
}
