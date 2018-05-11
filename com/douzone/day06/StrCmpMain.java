package com.douzone.day06;

public class StrCmpMain {
	public static void main(String[] args) {
		String str = new String("Hello");
		
		if(str == "Hello") {
			System.out.println("str == Hello");
		} else {
			System.out.println("str != Hello");
		}
		
		//문자열 (value)를 비교
		boolean bool = str.equals("Hello");
		if(bool) {
			System.out.println("같은 문자열 입니다.");
		} else { 
			System.out.println("다른 문자열 입니다.");
		}
	}
}
