package com.joe.designmode.creational.builder;

/**
 * 构建接口:用来构建产品中组件的接口
 */
public interface IBuilder {
	Part1 builderPart1();// 构建零件1

	Part2 builderPart2();// 构建零件2

}
