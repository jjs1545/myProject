package com.douzone.day07.thread;

//1.Thread 클래스를 상속
class ThreadA extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println("A Thread...");
		}
	}
}

class ThreadB extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("B Thread...");
		}
	}
}

//2. Runnable 인터페이스 상속
class ThreadC implements Runnable { 
	@Override
	public void run() {
		while(true) {
			System.out.println("C Thread...");
		}
	}
}

public class ThreadMain {
	// main 쓰레드
	public static void main(String[] args) {
		//1. 클래스 상속
		ThreadA ta = new ThreadA();
		ThreadB tb = new ThreadB();
		
		//2. 인터페이스 상속
		ThreadC tc = new ThreadC();
		Thread t = new Thread(tc);
		
		//인터페이스 상속? 기존 쓰레드 기능이 없다!
		//쓰레드를 생성시켜줘라.
		
		/*
			//단순히 메소드 호출
			//쓰레드 생성으로 이어지지 않는다!
			//즉, main 쓰레드 내의 run() 메소드 실행
			ta.run();
		*/
		
		ta.start();
		/*tb.start();
		t.start();*/
		
		while(true) {
			System.out.println("Main Thread...");
		}
	}
}
