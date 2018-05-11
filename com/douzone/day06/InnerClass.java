package com.douzone.day06;

/*
 * 
 * Inner class
 * class OuterClass {
 * 		class InnerClass {
 * 
 * 		}
 * 		static class NestedClass {
 * 
 * 		}
 * }
 * 
 */

class Outer {
	
	Outer() {
		//클래스 내부에서 직접 생성 가능
		Inner in = new Inner();
		in.test();
		
		Nested nst = new Nested();
		nst.test();
	}
	
	class Inner { 
		public void test() {
			System.out.println("Inner Class Method..");
		}
	}
	
	static class Nested {
		public void test() {
			System.out.println("Nested Class Method...");
		}
	}
}

interface Game {
	int startGame(int n);
}

class Overwatch implements Game {
	public int startGame(int n) {
		System.out.println("일리오스로 떠납니다~");
		return 10;
	}
}

public class InnerClass {
	public static void main(String[] args) {
		//Outer out = new Outer();
		
		//내부 클래스 접근 방법 Static으로 선언되어 직접 접근 가능
		Outer.Nested on = new Outer.Nested();
		on.test();
		
		//*Inner Class는 Outer Class에 종속적이다.
		//Inner Class가 있기 위해서는 Outer Class가 존재해야한다.

		//직접 생성이 불가
//		Outer.Inner oi = new Outer.Inner();
//		oi.test();
		
		
		/*
		 * 
		 * 1. 외부클래스의 인스턴스를 생성한 후에야,
		 * 		내부클래스를 생성 가능하다!
		 * 2. static를 활용하면 외부클래스 이름으로 직접 접근 가능!
		 * 
		 */
		
		Outer out = new Outer();
		Outer.Inner oi =  out.new Inner();
		
		//생성과 동시에 멤버 호출
		//일회용, 생성한 객체를 다시 사용할 수 없다.
		new Overwatch().startGame(1);
		
		Game g = new Game() { 
			public int startGame(int n) {
				System.out.println("네팔로 떠납니다~");
				return 1;
			}
		};
		int num = g.startGame(123);
		
		new Game() {
			public int startGame(int n) {
				System.out.println("하와이로 떠납니다~~");
				return 10;
			}
		}.startGame(10);
	}
}
