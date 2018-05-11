package com.douzone.inter;


//인터페이스 사용 예
//1. 자바는 다중상속이 불가능!, 인터페이스는 가능!

//class AAA extends BBB, CCC { }  --> 불가
//class BBB { }
//class CCC { }

interface SubInterface { }

//다만, interface를 활용하여 다중상속을 지원
/*
 * 
 * class MyClass implements SubInterface, TV, ExInterface {
 * }
 * 
 * 
 */

//인터페이스를 상속하기 위해선 implements 사용
public interface ExInterface /*implements TV*/ {
	
}

//2. 인터페이스는 상수를 관리 -> 변수는 모두 상수
//interface 기반의 상수 표현 예시, 상수 데이터 관리
//자바로 표현하면
class Cweek {
	public static final int MON = 1;
	// ...
	public static final int SUN = 7;
}

//인터페이스로 나타내면?
interface Iweek{
	/*public static final -> 생략 */ int VAL = 0;
	int MON = 1, /*...*/ SUN = 7;
}

//3. 무엇이 가능한가를 표시하는 용도 (클래스의 특성 표시)
//~able 로 끝나는 interface 표현, ~가능하다.
interface UpperCasePrintable{ //대문자로 출력 가능하다! 
	//비어 있음
	/*abstract public*/ void toUpperCasePrint();
}

class Printer implements UpperCasePrintable {
	
	//interface의 메소드의 접근지정자 public에 따라서,
	//Override된 메소드의 접근지정자 또한 public
	//부모클래스의 메소드 접근지정자보다
	//	확장될 수 는있지만, 좁혀질 수는 없다.
	
	/*
	 *	OCP(Open-cloased Principle)
	 * 		:확장에는 열려있지만, 수정에는 닫혀 있어야 한다.
	 */
	
	public void toUpperCasePrint() {
		//TODO
	}
}