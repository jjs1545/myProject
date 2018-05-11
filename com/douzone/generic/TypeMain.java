package com.douzone.day07;

class Fruit { }

class FruitBox<T> { }

//FruitBox<Fruit>의 Fruit를 상속시켜서 인자로 받는다? 불가능!
//우리는 박스에 Fruit라는 스티커만 붙인거다. Fruit의 상속관계를 신경X
//class Apple extends Fruit { }

class Apple extends FruitBox<Fruit> { }

//Java Data Structure
//Collection Framework

/* 
 * 
 * 일반적인 타입 약자
 * T - Data Type (U, ... ) 
 * K - Key Value
 * V - Value
 * E - Element
 * N - Number 
 * 
 */

public class TypeMain {
	public static void print(FruitBox<Fruit> param) {
		System.out.println("print() 호출...");
	}
	
	public static void main(String[] args) {
		Apple ap = new Apple();
		print(ap);
	}
}
