package com.joe.thread.juc;

import java.util.Random;
import java.util.concurrent.Phaser;

public class PhaserTest {
	static Random r = new Random();

	static Phaser phaser = new Phaser();

	public static void main(String[] args) {
		phaser.bulkRegister(5);
	}
}
