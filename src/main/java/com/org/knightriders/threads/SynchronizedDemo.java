package com.org.knightriders.threads;

public class SynchronizedDemo {

	public static void main(String[] args) {
		Display d = new Display();
		ThreadSynchronization t = new ThreadSynchronization(d, "Dhoni");
		ThreadSynchronization t1 = new ThreadSynchronization(d, "Jyothesh");
		t.start();
		t1.start();
	}

}

class Display {
	public synchronized void wish(String name) {
		for(int i = 0; i < 10; i++) {
			System.out.print("Good Morning : ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}

class ThreadSynchronization extends Thread {
	Display d;
	String name;
	
	public ThreadSynchronization(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}
