package com.joe.designmode.creational.builder;

/**
 * 产品类,由很多零件组成
 */
public class Product {

	private Part1 part1;
	private Part2 part2;

	public Part1 getPart1() {
		return part1;
	}

	public void setPart1(Part1 part1) {
		this.part1 = part1;
	}

	public Part2 getPart2() {
		return part2;
	}

	public void setPart2(Part2 part2) {
		this.part2 = part2;
	}

	@Override
	public String toString() {
		return "Product [part1=" + part1.getName() + ", part2=" + part2.getName() + "]";
	}
}

/**
 * 零件1
 */
class Part1 {

	public Part1(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

/**
 * 零件2
 */
class Part2 {
	public Part2(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}