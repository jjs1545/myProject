package com.douzone.override;

/*
 * 
 * 부모 클래스에 정의된 메소드의 
 * 메소드 명, 반환형, 매개변수의 형태와 갯수까지
 * 완전희 동일한 메소드를 다시 정의하는 것!
 * 
 */
public class Cat extends Animal{	
	@Override //재정의 됐음을 의미
	public void cry() {
		System.out.println("야옹~");
	}
}
