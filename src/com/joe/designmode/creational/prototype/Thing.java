package com.joe.designmode.creational.prototype;

import java.util.ArrayList;
import java.util.Date;

/**
 * 万物
 */
public class Thing implements Cloneable {
	// 定义一个私有变量
	private ArrayList<String> arrayList = new ArrayList<String>();

	private String name;

	private Date birthday;

	@Override
	public Thing clone() {
		Thing thing = null;
		try {
			thing = (Thing) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return thing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	// 设置HashMap的值
	public void addValue(String value) {
		this.arrayList.add(value);
	}

	// 取得arrayList的值
	public ArrayList<String> getValue() {
		return this.arrayList;
	}

}
