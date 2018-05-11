package com.douzone.day06;

import java.io.FileReader;

public class ThrowsMain {
	
	static void a() /*throws Exception*/ {
		String str = null;
		System.out.println(str.charAt(0));
	}
	
	static void b() /*throws Exception*/ {
		//FileReader fr = new FileReader("abc.txt");
	}
	
	//throws : 나를 호출한 곳으로 예외를 넘겨라!
	//JVM에게 예외를 던져라!
	public static void main(String[] args) throws Exception {
//		a();
//		b();	//JVM 자체로 예외처리를 하는 문자를 가지고 있다.
		
		try {
			a();
			b();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("hi");
		}
	}
}
