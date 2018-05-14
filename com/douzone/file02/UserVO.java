package com.douzone.file02;

import java.io.Serializable;

/*
 * 
 * VO  : Value Object			//데이터 모음
 * DTO : data Transfer Object	//데이터를 바꿔준다
 * 
 * 개념은 다르지만, 비슷하게 쓴다.
 * (굳이 구분할 필요가 있을까?)
 *  
 */


public class UserVO implements Serializable {
	private String name;
	private int age;
	private String addr;
	
	public UserVO() {
		super();
	}

	//매개변수 생성자 : alt + shift + s 후 O
	public UserVO(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	

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
	
	/*@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}*/
	
}
