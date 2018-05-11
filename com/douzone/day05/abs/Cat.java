package com.douzone.day05.abs;

public class Cat extends Animal{
	//부모 클래스의 추상 메소드는 자식에서 무조건 재정의!
	@Override
	public void cry() {
		
		//TODO
		System.out.println("야옹~");
	}
	
	/*
	// 추상화 메소드 실체화
	public void cry() {
		System.out.println("야옹~");
	}*/
}
