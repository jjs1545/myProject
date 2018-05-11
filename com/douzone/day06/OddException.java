package com.douzone.day06;

//사용자 정의 예외 클래스
@SuppressWarnings("serial")
public class OddException extends Exception {
	public OddException() {
		super(); //부모 클래스의 기본 생성자 호출
	}
	
	public OddException(String msg) {	// \ by zero처럼 만들겠다.
		super(msg);
	}
}
