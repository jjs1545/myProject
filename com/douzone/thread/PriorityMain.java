package com.douzone.day07.thread;


class MyThread extends Thread {
	String msg;
	
	public MyThread(String msg, int prio) {
		this.msg = msg;
		//Thread 클래스의 Setter
		setPriority(prio);
	}
	
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(msg + " 우선순위: " + getPriority());
			try {
				sleep(5); //CPU를 양보! 다른 쓰레드가 실행될 확률이 높다.
			}catch (Exception e) {
				
			}
		}
	}
}

public class PriorityMain {
	public static void main(String[] args) {
		/*MyThread mt = new MyThread("A Thread", Thread.MAX_PRIORITY);
		MyThread mt2 = new MyThread("B Thread", Thread.NORM_PRIORITY);
		MyThread mt3 = new MyThread("C Thread", Thread.MIN_PRIORITY);
		*/
		
		MyThread mt = new MyThread("A Thread", Thread.NORM_PRIORITY);
		MyThread mt2 = new MyThread("B Thread", Thread.NORM_PRIORITY);
		MyThread mt3 = new MyThread("C Thread", Thread.NORM_PRIORITY);
		
		
		
		/*
		 * 
		 *	Thread.MIN_PRIORITY: 1   //우선순위 1
		 *	Thread.NORM_PRIORITY: 5 
		 *	Thread.MAX_PRIORITY: 10 
		 *		
		 */
		//항상 1이 마지막으로 호출되는 것이 아니라,
		//확률적으로 마지막일 가능성이 높다.
		
		mt.start();
		mt2.start();
		mt3.start();
	}
}
