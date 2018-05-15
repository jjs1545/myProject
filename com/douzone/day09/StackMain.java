package com.douzone.day09;

import java.util.Stack;

/*
 * Stack Class
 * LIFO (Last In First Out) 형태의 임시버퍼
 * 	: 버퍼에 임시로 데이터를 저장하였다가 필요할 때 꺼내 쓴다.
 *  : 요청 시 가장 최근에 보관한 데이터부터 꺼낸다.
 * 
 * public void push(Element data);	: 숫자보관
 * public Element pop();			: 값을 반환(최근 저장)
 * public Element peek(); 			: 값을 참조(최근 저장)
 * public boolean empty();			: 비어있는지 체크
 * public int search(Element data); : Data를 보관한 순서 반환
 * 
 */
public class StackMain {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(3);	//3
		stack.push(5);	//3, 5
		stack.push(7);	//3, 5, 7
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.push(9);
		stack.push(11);
		System.out.println(stack.peek());	//11
								// 단순 참조이므로, 꺼내지 않는다.
		System.out.println(stack.pop());	//11
		
		//search() 메소드도 최근 저장한 데이터의 위치를 반환
		System.out.println(stack.search(9));	//1번째
		
		System.out.println("Stack의 모든 데이터 pop()");
		
		//Stack의 자료를 전부 꺼낸다.
		while(stack.empty() == false) {
			System.out.println(stack.pop());
		}
	}
}
