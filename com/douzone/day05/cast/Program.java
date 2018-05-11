package com.douzone.day05.cast;

class AAA {
	@Override
	public String toString() {
		return "배부르네요~";
	}
}

class BBB {
	/*Object 클래스 상속*/
}

public class Program {
	
	static void print(Parent p) {	//묵시적 형변환
									//자식의 객체 주소를 부모가 받아준다.
		
		if(p instanceof Child01) {	//p가 가르키는 곳이 Child01의 영역인가?
			Child01 c = (Child01)p;
			c.song();
			c.study();
		} else if (p instanceof Child02) {
			Child02 c = (Child02)p;
			c.sports();
			c.sleep();
		} else {
			System.out.println("나는 부모야~");
			p.info();
		}
	}
	
	public static void main(String[] args) {
		/*Parent p = new Child01();
		Child01 c = (Child01)p; //명시적 형번환
		
		p.info();
		c.info();
		c.study();
		
		//Child02 c2 = new Parent(); 불가능  //컴파일 에러
		Child01 c3 = (Child01)new Parent(); //런타임 에러
		c3.info();
		c3.study();*/
		
		/*
		 * instanceof 연산자
		 * 	: 형변환이 가능한지를 묻는 연산자
		 * 	: 가능하면 true, 불가능하면 false
		 */
		
		Parent p = new Parent();
		p.info();
		
		Child01 c01 = new Child01();
		print(c01);
		
		Child02 c02 = new Child02();
		print(c02);
		
		print(p);
		
		AAA aaa = new AAA();
		System.out.println(aaa.toString());
		
		//모든 클래스는 최상위 클래스 Object를 상속한다!
		//BBB클래스는 OBject 클래스를 상속받기에
		//부모 클래스 Object의 멤버 메소드인 toString() 사용가능!
		//System.out.println(bbb) : toString() 자동 호출!
		BBB bbb = new BBB();
		System.out.println(bbb.toString());
	}
}
