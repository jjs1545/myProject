package com.douzone.day06;

import java.util.Random;

//사용자가 예외 생성 및 처리 사용 예
public class UserMain {
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(100) + 1; // 1~100
		
		if(num % 2 == 0) {
			System.out.println("난수" + num + "은 짝수입니다.");
		} else {
			
			try{
				String msg = "난수" + num + "은 홀수입니다.";
				throw new OddException(msg);
				//예외를 던져라, catch가 잡도록 throw로 예외를 발생시킨다.
			} catch(OddException oe) {	//사용자가 정의 Exception
				oe.printStackTrace();
			}
		}
	}
}
