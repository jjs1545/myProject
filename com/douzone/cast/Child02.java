package com.douzone.day05.cast;

public class Child02 extends Parent {
	String name = "둘째 자식";
	
	void sports() {
		System.out.println("하나! 둘! 셋! 넷!");
	}
	
	void sleep() {
		System.out.println("zZzZzZzZzZZZzZzZZzzZ");
	}
	
	@Override
	public void info() {
		System.out.println("둘째 자식에서 오버라이딩된 메소드 호출..");
	}
}
