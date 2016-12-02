package com.org.knightriders.threads;

public class SlideRotator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			System.out.println("slide-" + i);
			Thread.sleep(5000);
		}
	}

}
