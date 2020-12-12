package com.joe.designmode.behavior.visitor;

/**
 */
public interface Role {
	// 演员要扮演的角色
	public void accept(AbsActor actor);
}
