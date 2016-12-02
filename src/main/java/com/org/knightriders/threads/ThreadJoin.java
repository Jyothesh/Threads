package com.org.knightriders.threads;

public class ThreadJoin {

	public static void main(String[] args) {
		MyThread3.mt = Thread.currentThread();
		MyThread3 t = new MyThread3();
		t.start();
		for(int i=0; i < 10; i++) {
			System.out.println("main thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class MyThread3 extends Thread {
	static Thread mt;
	public void run() {
		try {
			mt.join(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 10 ; i++) {
			System.out.println("child Thread");
		}
	}
}