package com.joe.designmode.behavior.visitor;

/**
 */
public class KungFuRole implements Role {
	// 武功天子第一的角色
	public void accept(AbsActor actor) {
		actor.act(this);
	}
}
