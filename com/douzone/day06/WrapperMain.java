package com.douzone.day06;

import java.math.BigDecimal;
import java.util.Random;

public class WrapperMain {
	public static void main(String[] args) {
		Integer iVal = new Integer(10);
		//int형 상수 10이라는 데이터 Boxing
		
		double dNum = 3.14;
		Double dVal = new Double(dNum);
		//double형 변수 dNum 데이터를 Boxing
		
		double subNum = dVal.doubleValue(); //UnBoxing
		System.out.println(subNum);
		
		System.out.println(iVal);
		iVal += 10;
		System.out.println(iVal);
		
		
		Integer num1 = 10;	//Auto-Boxing
		Integer num2 = 20;	//Auto-Boxing
		
		num1++; //1. UnBoxing - > 2. Boxing
		//num1 = new Integer(num1.intValue() + 1);
		num2++;
		
		System.out.println(num1);
		System.out.println(num2);
		
		int iNum = num1; //Auto-UnBoxing
		
		/*//실수는 오차가 존재
		double d1 = 1.6;
		double d2 = 0.1;
		
		System.out.println(d1 + d2);
		
		//실수형 double에는 표현 오차가 존재하므로,
		BigDecimal e1 = new BigDecimal(1.6);
		BigDecimal e2 = new BigDecimal(0.1);
		
		System.out.println(e1.add(e2));
		
		//문자열로 표현하여 BigDecimal 클래스에 오차 없이 전달한다.
		BigDecimal e3 = new BigDecimal("1.6");
		BigDecimal e4 = new BigDecimal("0.1");
		
		System.out.println(e3.add(e4));*/
		
		
		//동일 시드는 같은 패턴의 난수를 생성한다!
		//시드를 중복되지 않게 계속해서 바꾸어주면 된다.
		// ex) Time 
		Random r = new Random(10);
		for(int i=0; i<1000; i++) {
			System.out.println(r.nextInt(100));
		}
	}
	
	/*
	 * 
	 * //Object 파라미터 일떄 int가 아닌 Integer만 가능
	 * public static int hi(Object ob) {
	 * 		return 0;
	 * }
	 * 
	 */
}
