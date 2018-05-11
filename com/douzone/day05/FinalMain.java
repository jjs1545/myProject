package com.douzone.day05;

import java.util.Random;


/*
 * final class
 * 	: 상속하는 것을 허용하지 않는다!
 */

/*final*/ class FinalSuper {
	
	//final 메소드만 사용하면 상속은 허용하지만,
	//오버라이딩은 허용하지 않는다.
	
	public /*final*/ void hello() {
		System.out.println("hello~");
	}
}

//String class는 final이기에 상속 불가!

/*
 * class MyString extends String {
   }
 */

class MyRandom extends Random { 
	//부모 클래스 Random의 nextInt() 메소드 재정의!
	public int nextInt(int max) {
		return super.nextInt(max) + 1;
	}
}

public class FinalMain extends FinalSuper{

	/*
	@Override
	public void hello() {
		System.out.println("hi~");
	}
	*/
	
	public static void main(String[] args) {
		Random r = new Random();
		//난수는 nextInt(인자)
		// 0을 기준으로 0이상의 개수만큼 난수 생성
		
		//int num = r.nextInt(2);	//0~1
		//TODO 난수를 1부터 생성하게끔 만들고 싶다..
		int num = r.nextInt(2) + 1; //1~2
		System.out.println(num);
		
		MyRandom mr = new MyRandom();
		int rNum = mr.nextInt(2);
		System.out.println(rNum);
	}
}
