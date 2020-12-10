package com.joe.designmode.creational.builder;

/**
 * 组装接口:用于将产品组件组装起来
 */
public interface IDirector {
	/**
	 * 组装产品
	 * 
	 * @return
	 */
	Product directorProduct();
}
