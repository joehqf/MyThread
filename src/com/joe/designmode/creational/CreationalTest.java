package com.joe.designmode.creational;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.joe.designmode.creational.builder.ConcreteBuilder;
import com.joe.designmode.creational.builder.ConcreteDirector;
import com.joe.designmode.creational.builder.IBuilder;
import com.joe.designmode.creational.builder.IDirector;
import com.joe.designmode.creational.builder.Product;
import com.joe.designmode.creational.factory.Factory1;
import com.joe.designmode.creational.factory.Factory2;
import com.joe.designmode.creational.factory.IProduct;
import com.joe.designmode.creational.prototype.Thing;
import com.joe.designmode.creational.prototype.Thing2;
import com.joe.designmode.creational.singleton.SingletonTest;

/**
 * 1、测试方法必须使用@Test进行修饰 2、测试方法必须使用public void 进行修饰，不能带任何参数 3、新建一个源码目录来存放我们的测试代码
 * 4、测试类的包应该和被测试类保持一致 5、测试单元中的每个方法必须可以独立测试，测试方法间不能有任何依赖
 */
class CreationalTest {

	/**
	 * @Test:将一个普通的方法修饰成为一个测试方法
	 * @Test(expected=XX.class) @Test(timeout=毫秒) @BeforeClass：它会在所有方法运行前被执行，static修饰
	 * @AfterClass：它会在所有方法运行后被执行，static修饰
	 * @Before：会在每一个测试方法运行前被执行一次
	 * @After：会在每一个测试方法运行后被执行一次
	 * @Ignore：所修饰的测试方法会测试运行器被忽略
	 * @RunWiht：可以更改测试运行器 org.junit.runner.Runner
	 */

	/**
	 * 测试单例
	 */
	@Test
	void singletonTest() {
//		fail("Not yet implemented");
		SingletonTest instance = SingletonTest.getInstance();
		SingletonTest instance2 = SingletonTest.getInstance();
		assertTrue(instance == instance2);
//		assertEquals(6, 7);
	}

	/**
	 * 测试原型-浅拷贝
	 */
	@Test
	void protypeTest() {
		Date date = new Date(1274397294739L);

		Thing thing = new Thing();
		thing.setName("小力羊");
		thing.addValue("学咩咩");
		thing.setBirthday(date);// 改变原有date的值

		Thing clone = thing.clone();
		clone.setName("小李阳");
		clone.addValue("学喵喵");

		date.setTime(34732834827389L);// 改变原有date的值

		System.out.println(thing.getValue() + thing.getName() + thing.getBirthday());
		System.out.println(clone.getValue() + clone.getName() + clone.getBirthday());
	}

	/**
	 * 测试原型-深拷贝
	 */
	@Test
	void protypeTest2() {
		Date date = new Date(1274397294739L);

		Thing2 thing = new Thing2();
		thing.setName("小力羊");
		thing.addValue("学咩咩");
		thing.setBirthday(date);// 改变原有date的值

		Thing2 clone = thing.clone();
		clone.setName("小李阳");
		clone.addValue("学喵喵");

		date.setTime(34732834827389L);// 改变原有date的值

		System.out.println(thing.getValue() + thing.getName() + thing.getBirthday());
		System.out.println(clone.getValue() + clone.getName() + clone.getBirthday());
	}

	/**
	 * 测试建造者模式
	 */
	@Test
	void builderTest() {
		// new 一个具体的构件类和导演类
		IBuilder builder = new ConcreteBuilder();
		IDirector director = new ConcreteDirector(builder);

		Product directorProduct = director.directorProduct();
		System.out.println(directorProduct);
	}

	/**
	 * 测试工厂模式
	 */
	@Test
	void factoryTest() {
		// new 一个具体的构件类和导演类
		IProduct createProduct = new Factory1().createProduct();
		IProduct createProduct2 = new Factory2().createProduct();
		createProduct.run();
		createProduct2.run();
	}
}
