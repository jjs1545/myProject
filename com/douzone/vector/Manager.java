package com.douzone.day09.vector;

import java.util.Scanner;
import java.util.Vector;




/*
 * Vector 
 * 	: 1.0부터 제공
 * 	: 동기화(syncronized)//단일쓰레드에서는 동기화가 단점 but 다중쓰레드에서는 동기화가 단점이 아니다.
 * 
 * List   
 *  : 1.2부터 Vector의 확장판
 *  : 동기화가 필요하면 synchronizedList를 활용해라!
 * 
 */

//Handler class
public class Manager {
	Scanner s = new Scanner(System.in);
	Vector<MemberDAO> members = new Vector<>();
	
	public void run() {
		int key = 0;
		while((key = menu()) != 0) {	//key가 0이라면 종료
			switch(key){
				case 1:
					addMember();
					break;
				case 2:
					removeMember();
					break;
				case 3:
					searchMember();
				case 4:
					displayMember();
			}
		}
	}
	
	private int menu() {
		System.out.println("[처음만나는 관리 프로그램] 메뉴를 선택하세요.");
		return getNumInput("[1]:추가 [2]:삭제 [3]:검색 [4]:목록 [0]:종료");
	}
	
	private int getNumInput(String msg) {
		System.out.println(msg);
		return s.nextInt();
	}
	
	private String getStrInput(String msg) {
		System.out.println(msg);
		return s.nextLine();
	}
	
	private void addMember() {
		int num = getNumInput("추가할 회원 번호 : ");
		s.nextLine();
		
		String name = getStrInput("회원 이름 : ");
		MemberDAO member = new MemberDAO(num, name);
		members.add(member);
		System.out.println(member.toString() + " 회원을 추가했습니다.");
	}
	
	private void removeMember() {
		int num = getNumInput("삭제할 회원 번호: ");
		MemberDAO member = findByNumber(num);
		if(member == null) {
			System.out.println("회원 번호가 존재하지 않습니다.");
			return;
		}
		members.remove(member);
		System.out.println(member.toString() + "회원을 삭제하였습니다.");
	}
	
	private void searchMember() {
		int num = getNumInput("검색할 회원번호: ");
		MemberDAO member = findByNumber(num);
		if(member == null) {
			System.out.println("회원 번호가 존재하지 않습니다.");
			return;
		}
		System.out.println("[결과] : " +member.toString());
	}
	
	private void displayMember() {
		System.out.println("[전체 회원 목록] (" + members.size() + ")");
		if(members.size() == 0) {
			System.out.println("회원이 존재하지 않습니다.");
		}
		for(MemberDAO member : members) {
			System.out.println(member.toString());
		}
	}
	
	
	private MemberDAO findByNumber(int num) {
		for(MemberDAO member : members) {
			if(member.getNum() == num) {
				return member;
			}
		} 
		return null;
	}
}
