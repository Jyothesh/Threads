package com.org.knightriders.threads;

public class ThreadJoin1 {

	public static void main(String[] args) throws InterruptedException {
		MyThread2 t = new MyThread2();
		t.start();
		t.join(10000);
		for(int i=0; i < 10; i++) {
			System.out.println("main thread");
		}
	}
}


class MyThread2 extends Thread {
	public void run() {
		for(int i = 0; i < 10 ; i++) {
			System.out.println("child Thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}