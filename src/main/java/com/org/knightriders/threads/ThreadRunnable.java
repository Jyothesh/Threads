package com.org.knightriders.threads;

public class ThreadRunnable {

	public static void main(String[] args) {
		MyRunnable t = new MyRunnable();
		Thread t1 = new Thread(t);
		t1.start();
		for(int i = 0; i  <10; i++) {
			System.out.println("main Process");
		}
	}
}

class MyRunnable implements Runnable {

	public void run() {
		for(int i = 0; i  <10; i++) {
			System.out.println("child Process");
		}
	}
}