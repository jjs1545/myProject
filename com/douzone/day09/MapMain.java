package com.douzone.day09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 * 
 * Map 주요 메소드			K: key 타입, V: Value 타입
 *  - V put(K key, V value): 데이터 입력
 *  - V get(K key) 		   : 특정 key에 대한 value값 추출 
 *  - V remove(Object Key) : 특정 key에 대한 Map 요소 삭제
 *  
 *  
 */

class IDInfo {
	private String id;
	private String pw;
	
	public IDInfo(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public IDInfo() {
		
	}
	
	public String getID() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
}

public class MapMain {
	public static void main(String[] args) {
/*		Scanner s = new Scanner(System.in);
		
		Map<String, String> map = new HashMap<>();
		
		map.put("aaa","a123");
		map.put("bbb","b456");
		
		//다른 key의 value는 중복이 가능!
		map.put("ccc","a123");
		//map.put("ccc","c789");
		
		//key의 중복은 허용 불가!
		//하지만, 동일 키에 대한 value를 넣으면 업데이트
		//map.put("aaa", "0000");
		
		IDInfo idInfo = new IDInfo();
		
		System.out.println("aaa key에 대한 value : " + map.get("aaa"));
		System.out.println("aaa key에 대한 value : " + map.get("bbb"));
		System.out.println("ccc key에 대한 value : " + map.get("ccc"));
		
		
		//Key값
		System.out.print("아이디를 입력: ");
		String id = s.nextLine();
		System.out.println();
		
		//map에 해당 key의 요소가 존재하는지 확인
		if(map.containsKey(id)) { 			
			System.out.print("입력하신 [" + id + "]");
		} else {
			System.out.print("잘못 입력하셨습니다.");
			System.out.print("해당 ID [" + id + "] 는 존재하지 않습니다.");
			System.out.print("[System] : 프로그램 종료");
			System.exit(0);
		}
		
		// Value 
		System.out.print("현재 패스워드를 입력: ");
		String pw = s.nextLine();
		
		//넘어온 Key에 대한 pw가 map요소의 Value와 같은지 
		if(map.get(id).equals(pw)) {
			System.out.println("변경할 패스워드 입력 : ");
			String newPw = s.nextLine();
			map.put(id, newPw); //업데이트
		} else {
			System.out.println("입력하신 비밀번호가 맞지 않습니다.");
		}
		
		//keySet(): map요소의 key값들을 set으로 반환!
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			System.out.println(map.get(keys.next()));
		}
		
		//여러가지 형태로 셋을 만들겠다. Key와 Value 모두 출력
		Set<Entry<String, String>> entry = map.entrySet();
		for(Entry<String, String> e : entry) {
			System.out.println("ID: " + e.getKey() + "Pw: " + e.getValue());
		}*/
		
		
		//컬렉션에 객체 저장
		List<IDInfo> list = new ArrayList<>();
		list.add(new IDInfo("aaa","1111"));
		list.add(new IDInfo("bbb","2222"));
		list.add(new IDInfo("ccc","3333"));
		
		for(IDInfo info : list) {
			System.out.println("ID: " + info.getID() + ", PW: " + info.getPw());
		}
		
		//Map을 활용한 회원가입 프로그램을 작성하시오.
		//회원정보 IDInfo 클래스를 관리하는 Map.
		//회원 Member 클래스를 관리하는 Collection을 사용하시오(자유).
	}
}
