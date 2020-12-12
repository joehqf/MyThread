package com.joe.designmode.behavior.visitor;

/**
 */
public class IdiotRole implements Role {
	// 一个弱智角色,然谁来扮演
	public void accept(AbsActor actor) {
		actor.act(this);
	}
}
