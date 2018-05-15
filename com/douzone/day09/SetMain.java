package com.douzone.day09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Set 주요 메소드
 * 	- add	   : 데이터 입력
 *  - remove   : 특정 데이터 삭제
 *  - clear	   : 모든 데이터 삭제
 *  - size 	   : 입력된 데이터의 크기 반환
 *  - contains : 특정 객체의 존재 여부 확인
 *  - isEmpty  : 비어있는지 체크
 *  - toArray  : 배열로 반환
 *  
 *  - Iterator : 반복자
 * 
 * Set에서 요소를 출력하는 3가지 방식
 *  - foreach
 *  - iterator()
 *  - toArray()
 */

public class SetMain {	//데이터의 중복저장을 허용하지 않는다. 즉, Set<E>를 구현하는 클래스는 '집합'의 성격
	public static void main(String[] args) {
		//Set<String> set = new HashSet<>();
		
		//자바 메모리 추가 내용
		String str = new String("Hello");	
		//JVM이 상수풀에 해당 데이터가 존재하는지 확인,
		//존재한다면 이미 있는 데이터를 참조!
		//즉, "Hello" <- 요놈은 전부다 같은 놈!
		
		System.out.println("Hello" == "Hello"); 	//주소
		System.out.println(str == "Hello");			//주소 false
		System.out.println(str.equals("Hello"));	//값
		
		Set<String> set = new HashSet<>();
		set.add("One");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		
		//set.add("two");	//중복을 허용 하지 않는다.
		System.out.println("입력 여부 판단: " + set.add("two"));
		System.out.println("입력 여부 판단: " + set.add("six"));
		
		System.out.println("삭제 전 데이터의 개수: " + set.size());
		set.remove("two");
		System.out.println("삭제 후 데이터의 개수: " + set.size());
		
		//저장 순서가 없기에 마구잡이로 출력
		//foreach은 참조 목적이므로, 사용 가능! (인덱스x)
		System.out.println("Set 컬렉션 출력: ");
		for(String s : set) {	//데이터의 참조의 목적 foreach문
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println(" ");
		
		set = new TreeSet<>(); //사전식 정렬 set
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		
		System.out.println("TreeSet 사전식 정렬");
		System.out.println("Iterator 출력: ");
		
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			System.out.print(ite.next() + " ");
		}
		System.out.println(" ");
		
		System.out.println("toArray()를 이용한 출력");
		//toArray(): Object 배열로 반환! 
		Object[] obj = set.toArray();
		System.out.println(Arrays.toString(obj));
		
		//Object가 가르키는 것을 String으로 바꾼다해도 Exception! Set 형변환
		String[] strArr = (String[])set.toArray();		//Object형식을 String으로 강제 형변환 불가
		System.out.println(Arrays.toString(strArr));
	}
}
