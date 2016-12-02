package com.org.knightriders.threads;

public class InterprocessCommunication {

	public static void main(String[] args) throws InterruptedException {
		ThreadB t = new ThreadB();
		t.start();
		//ThreadB.sleep(0,1);
		//t.join();
		synchronized (t) {
			t.wait();
		}

		System.out.println(t.total);
	}
}

class ThreadB extends Thread {
	int total = 0;
	
	public void run() {
		synchronized (this) {
			for(int i = 0 ; i <= 100; i++) {
				total = total + i;
			}
			this.notify();
		}
	}
}