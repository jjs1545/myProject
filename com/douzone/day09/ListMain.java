package com.douzone.day09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 컬렉션 클래스들은 Object형으로 요소를 저장한다.
 * ArrayList는 배열에 추가/삭제시 데이터를 추가/삭제하고 배열을 복사해야 하므로 시간이 오래걸린다. (데이터 참조시 index 값으로 찾을 수 있으므로 속도가 빠르다.)
 * LinkedList는 배열의 추가/삭제시 노드의 링크만 연결해주면 되므로 시간이 빠르다. (데이터 참조시 링크를 모두 거쳐야 하므로 데이터 검색시 속도가 느리다.)
 * 
 * List 주요 메소드
 * - add	  : 데이터 입력
 * - addAll   : 기존 저장된 집합 객체의 데이터 입력
 * - get	  : 데이터 추출 
 * - size 	  : 입력된 데이터의 개수 반환
 * - remove   : 특정 데이터 삭제
 * - clear    : 모든 데이터 삭제
 * - contains :	특정 데이터의 존재 여부
 * - isEmpty  : 비어있는지 여부 체크 
 * 
 * iterator : 인터페이스 객체 반환 목적(반복자) -> 컬렉션 클래스의 종류에 상관없이 동일한 형태의 데이터 참조방식을 유지할 수 있다.
 *  - hasNext : 요소(Element)의 존재유무 판단
 *  - next 	  : 요소 추출
 *  - remove  : 요소 반환(삭제)
 *  
 *  
 */

public class ListMain {
	public static void main(String[] args) {
		//ArrayList 배열의 확장판!, 동적배열!
		//List<String> list = new ArrayList<String>();
		List<String> list = new ArrayList<>();
		//1.7버전 생략 가능
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		list.add("two");	//중복 허용!
		list.remove("two");	//앞에 있는 데이터 삭제!
		list.remove("ten");	//없는 데이터를 remove해도 컴파일, 런타임 에러가 나타나지 않는다.
		
		System.out.println("Index를 이용한 데이터 출력");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+ " ");
		}
		System.out.println();
		
		System.out.println("foreach를 이용한 데이터 출력");
		for(String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("Iterator를 이용한 데이터 출력");
		Iterator<String> ite = list.iterator();
		// list의 Iterator()로 Iterator 형태로 사용하겠다!
		
		while(ite.hasNext()) {	//데이터가 존재한다면,
			System.out.print(ite.next() + " ");
		}
		System.out.println();
	}
}
