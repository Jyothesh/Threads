package com.org.knightriders.threads;

public class ThreadYield {

	public static void main(String args[]) {
		MyThread1 t = new MyThread1();
		t.start();
		for(int i= 0; i < 10; i++) {
			System.out.println("main process");
		}
	}
}

class MyThread1 extends Thread {
	public void run() {
		for(int i= 0; i < 10; i++) {
			System.out.println("child process");
			Thread.yield();
		}
	}
}