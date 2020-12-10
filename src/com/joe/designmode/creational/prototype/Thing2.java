package com.joe.designmode.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * 万物
 */
public class Thing2 implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	// 定义一个私有变量
	private ArrayList<String> arrayList = new ArrayList<String>();

	private String name;

	private Date birthday;

	@Override
	public Thing2 clone() {
		Thing2 thing = null;
		Thing2 proto = null;
		try {
			proto = (Thing2) super.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		try {
			// 1、将s1对象序列化为一个数组
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// 通过ObjectOutputStream流将s1对象读出来给ByteArrayOutputStream流
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(proto);
			// ByteArrayOutputStream流将对象信息转成byte数组，这样byte数组里就包含了对象的数据
			byte[] bytes = bos.toByteArray();

			// 2、将字节数组中的内容反序列化为一个Joe对象
			// 通过ByteArrayInputStream流读入bytes字节数组中数据，然后传给ObjectInputStream对象输入流
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			// 通过ObjectInputStream返回一个对象
			thing = (Thing2) ois.readObject();
		} catch (Exception e) {
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
