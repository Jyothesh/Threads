package com.org.knightriders.threads;

public class SampleDeadLock {

	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().join();
	}

}
