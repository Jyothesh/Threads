package com.org.knightriders.threads;

public class ThreadInterruption {

	public static void main(String[] args) {
		Interrupt t = new Interrupt();
		t.start();
		t.interrupt();
		System.out.println("End of Main");
	}

}

class Interrupt extends Thread {
	public void run() {
		for(int i =0; i < 10 ; i++) {
			System.out.println("I am lazy thread.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("I got interrupted");
			}
		}
	}
}