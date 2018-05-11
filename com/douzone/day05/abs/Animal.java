package com.douzone.day05.abs;

/*
 * Override 예제에서 보듯이,
 * Animal의 cry() 메소드가 불필요하다! (어짜피 안쓸 것!)
 * 그래서 Animal class를 추상화 해보자!
 * 
 * 추상 클래스 : abstract
 * 	: 실체를 가지지 않는 클래스 (생각만 한다!)
 *  : 하나 이상의 메소드가 abstract 하다면,
 *  	클래스도 abstract 해야한다.
 */

public abstract class Animal {
	//Body를 가지지 않는 추상 메소드 선언!
	public abstract void cry();
	
	/*
	 public void cry() { 		--> 상속받은 자식들은 오버라이딩 가능하므로 추상메소드 아니여도 된다.
		//Body				
		System.out.println("난 부모 애니멀이야~");
	}
	
	*/
}
