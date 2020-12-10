package com.joe.designmode.creational.builder;

/**
 * 具体的构件类
 * 
 */
public class ConcreteBuilder implements IBuilder {

	@Override
	public Part1 builderPart1() {
		return new Part1("品牌1的零件1");
	}

	@Override
	public Part2 builderPart2() {
		return new Part2("品牌2的零件2");
	}

}
