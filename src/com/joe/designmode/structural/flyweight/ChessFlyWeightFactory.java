package com.joe.designmode.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessFlyWeightFactory {
	// 享元池：存放享元对象
	private static Map<String, ChessFlyWeight> map = new HashMap<String, ChessFlyWeight>();

	// 提供一个享元工厂:创建和管理棋子
	public static ChessFlyWeight getChess(String color) {
		if (map.get(color) != null) {
			return map.get(color);
		} else {
			ChessFlyWeight chess = new ConcreteFlyWeight(color);
			map.put(color, chess);
			return chess;
		}
	}
}
