package com.douzone.file01;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private String name;
	private int age;
	private transient String addr; //transient -> 직렬화에서 제외하겠다!
	
	//기본 생성자 : art+shif+s 후 c
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	//접근 메소드(getter/setter) : alt + shift + s 후 r

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
	
}
