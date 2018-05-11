package com.douzone.day04.singleton;

/*
 * 
 * 싱글톤 패턴
 * 	: 객체를 단 하나만 생성하고 싶을 때 디자인 패턴
 * 
 */

public class Cat {
	String name;
	int age;
	
	//확정된 인스턴스를 갖도록 상수화
	static final private Cat obj = new Cat();
	
	private Cat() { }

	//싱글톤 패턴
	//getter의 성격
	public static Cat getInstance() {
//		if(obj == null) {
//			obj = new Cat();
//		}
		return obj;
	}
}
