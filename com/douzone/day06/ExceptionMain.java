package com.douzone.day06;

import java.io.FileReader;
import java.util.Random;

/*
 * 
 * 
 * try {
 * 	//예외가 발생할 수 있는 구문
 * } catch () {
 * 	//예외 발생시 실행 구문
 * }
 * 
 * 
 */

public class ExceptionMain {
	public static void main(String[] args) {
		System.out.println("main start");
		
/*		Random r= new Random();
		int num = r.nextInt(2);
		System.out.println("생성된 난수 : " + num);
		
		try{			
			System.out.println(10/num);
		}catch(ArithmeticException ae){	//발생 예외를 처리할 수 있는 예외(Exception) 클래스
										//ae가 예외를 기억!
			ae.printStackTrace();		//예외 정보 출력
		}finally{
		}*/
		
		//try~catch~fianlly
		
		try {
			
			System.out.println(1);
			System.out.println(1/0);	//Exception 발생
			System.out.println("HI");
			System.out.println(2);
		
		} catch(Exception e ) { 
			
			e.printStackTrace();
			System.out.println(3);
		
		} finally { //try 영역에 진입하면 무조건 실행되는 영역!
			
			System.out.println(4);
		}
		
		System.out.println(5);

		
		//ExceptionMultiCatch
		
		/*try {
			
			String str = "abc";
			System.out.println(str.charAt(1));
			
			String[] strArr = { "a" };
			System.out.println(strArr[1]);
			
			FileReader fr = new FileReader("abc.txt");
			
		} catch (Exception e) { //묵시적 형변환
			e.printStackTrace();
		} */
		//전부 외울 수 없으니까, 하나로 묵시적 형변환 제공
		//맨 마지막에 써줘라! why? 프로그램이 무거워질 수 있다.
		System.out.println("main end");
	}
}
