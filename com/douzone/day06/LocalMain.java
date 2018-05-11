package com.douzone.day06;

interface Readable {
	/*public*/ void read();
	
}

class OuterClass {
	//멤버 변수
	private String name;
	
	//생성자
	OuterClass(String name) {
		this.name=name;
	}
	
	//멤버 메소드
	//반환형 : Readable
	public Readable createLocalClassInst() {
		class LocalClass implements Readable {
			//멤버 변수
			int age;
			String addr;
			
			LocalClass() {
				System.out.println("Local 기본생성");
			}
			
			//멤버 메소드
			void print() {
				System.out.println("print()..");
			}
			
			@Override
			public void read() {
				// TODO Auto-generated method stub
				System.out.println(name);
			}
			
		}
		//LocalClass가 Readable을 상속받기 때문에 가능!
		// Readable > LocalClass
		LocalClass lc = new LocalClass();
		lc.print();
		
		return new LocalClass();
	}
	
	//익명의 LocalClass인 AnonymousClass
	public Readable createLocalClassInst2(int instID) {
		//Readable Interface를 상속받는 Class가 존재!
		return new Readable() {
			//멤버 변수 생성
			int age;
			String addr;
			
			//멤버 메소드
			void print() {
				System.out.println("print()...");
			}
			
			//익명 클래스의 Body
			@Override
			public void read() {
				System.out.println("name : " + name);
				System.out.println("instID : " + instID);
			}
		};
	}
}

/*
 * 
 *	Local 클래스는 메소드 내에 정의가 되어서, 메소드 내에서만 인스턴스의 생성 및 참조 변수의 선언이 가능하다는 특징이 있다!
 *
 */

public class LocalMain {
	public static void main(String[] args) {
		OuterClass oc = new OuterClass("유닛1");
		//직접 호출
		oc.createLocalClassInst().read();
		
		//인터페이스의 참조 변수를 활용하여 호출
		Readable r = oc.createLocalClassInst();
		r.read();
		
		OuterClass oc2 = new OuterClass("유닛2");
		Readable r2 = oc2.createLocalClassInst2(111);
		r2.read();
	}
}
