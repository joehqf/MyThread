package com.joe.designmode.structural.flyweight;

/**
 * 运用共享技术有效的支持大量细粒度对象的重用。
 */
public class Client {

	public static void main(String[] args) {
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");// 黑1
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");// 黑2
		System.out.println(chess1 == chess2);// 结果为true，相同或相似对象内存中只存在一份

		// 使用享元的外部状态
		chess1.display(new Coordinate(10, 10));// 黑1在10,10的位置
		chess2.display(new Coordinate(20, 20));// 黑2在20,20的位置

		System.out.println(chess1 == chess2);// 结果为true，相同或相似对象内存中只存在一份

		String str1 = "和谐";
		String str2 = "社会";
		String str3 = "和谐社会";
		String str4;

		str4 = str1 + str2;
		System.out.println(str3 == str4);

		str4 = (str1 + str2).intern();
		System.out.println(str3 == str4);
	}

}
