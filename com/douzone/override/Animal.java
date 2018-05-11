package com.douzone.override;

public class Animal {
	public void cry() {
		System.out.println("cry~");
	}
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.cry();
	}
}
