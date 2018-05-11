package com.douzone.day02;

public class Hanoi {
	static int cnt = 0;
	
	public static void Move(char a, char b, char c, int n) {
		if(n<=0) {
			return;
		}
		cnt++;
		Move(a, c, b, n-1);
		System.out.printf("Move %s -> %s\n", a , c);
		Move(b, a, c, n-1);
	}
	
	public static void main(String[] args) {
		Move('a','b','c',3); 
		System.out.println("이동 수 : " + cnt);
	}
}
