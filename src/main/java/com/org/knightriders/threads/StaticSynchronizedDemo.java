package com.org.knightriders.threads;

public class StaticSynchronizedDemo {

	public static void main(String[] args) {
		Display1 d = new Display1();
		ThreadSynchronization1 t = new ThreadSynchronization1(d);
		ThreadSynchronization2 t1 = new ThreadSynchronization2(d);
		
		t.start();
		t1.start();
	}

}

class Display1 {
	public synchronized void displayn() {
		for(int i = 0; i < 10; i++) {
			System.out.print(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void displayc() {
		for(int i = 65; i <= 75; i++) {
			System.out.print((char) i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadSynchronization1 extends Thread {
	Display1 d;
	
	public ThreadSynchronization1(Display1 d) {
		this.d = d;
	}
	
	public void run() {
		d.displayn();
	}
}

class ThreadSynchronization2 extends Thread {
	Display1 d;
	
	public ThreadSynchronization2(Display1 d) {
		this.d = d;
	}
	
	public void run() {
		d.displayc();
	}
}