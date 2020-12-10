package com.joe.designmode.creational.builder;

/**
 * 具体的导演
 */
public class ConcreteDirector implements IDirector {

	private IBuilder builder;// 创建构建者的引用

	public ConcreteDirector(IBuilder builder) {
		this.builder = builder;
	}

	@Override
	public Product directorProduct() {

		Product pro = new Product();
		pro.setPart1(builder.builderPart1());
		pro.setPart2(builder.builderPart2());

		return pro;
	}

}
