package com.douzone.day09;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue
 * FIFO (First In First Out)
 * public void offer(Element data)	: 데이터 보관
 * public Element poll()			: 값을 반환(데이터를 꺼낸다)
 * public Element peek()			: 값을 참조(참조만하고 꺼내지 않음)
 * public boolean empty()			: 비어있는지 체크
 */

public class QueueMain {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		q.offer("권지용");
		q.offer("아이유");
		q.offer("레골라스");
		
		System.out.println(q.peek());	//참조
		System.out.println(q.poll());	//꺼낸다
		System.out.println(q.poll());	//꺼낸다
		
		q.offer("리설주");
		
		System.out.println("전부 꺼내라!");
		
		while(q.isEmpty() == false) { 
			System.out.println(q.poll());
		}
	}
}
