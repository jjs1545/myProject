package com.douzone.vector;

public class MemberDAO {
	private int num;
	String name;
	
	public MemberDAO(int num, String name) {
		this.num=num;
		this.name=name;
	}
	
	public int getNum() {
		return num;
	}
	
	@Override
	public String toString() {
		return String.format("번호:%d 이름:%s", num, name);
	}
}
