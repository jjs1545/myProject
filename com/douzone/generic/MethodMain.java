package com.douzone.day07;

class  AAA {
	@Override
	public String toString() {
		return "Class A";
	}
}

class BBB {
	@Override
	public String toString() {
		return "Class B";
	}
}

class InstInfo {
	public <T> void view(T inst) {
		System.out.println(inst);
	}
	public <T, U> void view(T inst, U inst2) {
		System.out.println(inst);
		System.out.println(inst2);
	}
}

public class MethodMain {
	public static void main(String[] args) {
		AAA a = new AAA();
		BBB b = new BBB();
		
		InstInfo ii = new InstInfo();
		ii.<AAA>view(a);
		ii.<BBB>view(b);
		
		ii.<AAA, BBB> view(a,b);
		// ii.<AAA>view(b); // 컴파일 에러
		// AAA라는 스티커를 붙이면,
		// AAA의 인스턴스만 인자로 넣을 수 있다.
		
//		ii.view(a);
//		ii.view(b);
	}
}
