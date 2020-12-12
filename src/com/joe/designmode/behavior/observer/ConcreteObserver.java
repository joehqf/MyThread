package com.joe.designmode.behavior.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体的观察者
 */
public class ConcreteObserver implements Observer {
	private int state;// 具体观察者中的状态和目标对象的状态保持一致

	@Override
	public void update(Observable o, Object arg) {
		state = ((ConcreteSubject) o).getState();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
