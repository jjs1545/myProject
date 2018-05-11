package com.douzone.day07.thread;

import java.util.Date;

class TimerThread extends Thread {
	@Override
	public void run() {
		for(int i=1; i<=10000; i++) {
			try {
				//현재 쓰레드를 1초간 재우겠다.
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("현재 시간: " + new Date().toLocaleString());
		}
		
	}
}

public class SleepMain {
	public static void main(String[] args) {
		TimerThread tt = new TimerThread();
		tt.start();
		//연산을 수행하는 시간도 존재하기에,
		//정확한 1초 카운트가 되지 않는다.
		
		System.out.println("main아 2초간 자라!");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		System.out.println("hi");
	}
}
