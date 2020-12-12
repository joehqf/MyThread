package com.joe.designmode.behavior.cor;

/**
 * 1、接受者和发送者都没有对方的明确信息，且链中的对象也并不知道链的结构，结果是责任链可简化对象的相互连接，它们仅需保持一个指向其
 * 后继者的引用，而不需要保持它所有的候选继承者，大大的降低了耦合度。 请求者不用管具体哪个对象会处理，反正该请求肯定会被处理就行了
 * 2、可以随时增加或者修改处理一个请求的结构，增加了给对象指派职责的灵活性
 *
 */
public class Client {

	public static void main(String[] args) {
		// 构建各个领导人
		Leader a = new Director("张三");// 主任
		Leader b = new Manager("李四");// 经理
		Leader c = new GeneralManager("王五");// 总经理
		// 设置各个责任链上的关系
		a.setNextLeader(b);// 主任的下一个审批人为经理
		b.setNextLeader(c);// 经理的下一个审批人为总经理

		// 开始请假
		LeaveRequest request = new LeaveRequest("小明", 4, "旅游");
		a.handleRequest(request);// 小明提交了请假申请给主任
	}

}
