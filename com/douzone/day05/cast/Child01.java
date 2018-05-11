package com.douzone.day05.cast;

public class Child01 extends Parent {
	String name = "첫째 자식";
	
	void song() { 
		System.out.println("랄랄라~");
	}
	
	void study() {
		System.out.println("자바란 무엇인가..");
	}
	
	@Override
	public void info() {
		System.out.println("첫째 자식에서 오버라이딩된 메소드 호출..");
	}
}
