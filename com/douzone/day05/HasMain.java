package com.douzone.day05;

class Gun {
	//멤버 변수(데이터)
	int bullet;
	
	//생성자, 클래스를 생성할 때 딱 한번만 호출된다.
	public Gun(int bnum) {
		bullet = bnum;
	}
	
	//멤버 메소드(기능, 행위)
	public void shut() {
		System.out.println("빵!");
		bullet--;
	}
	
	public void status() {
		System.out.println("남은 총알 : " + bullet);
	}
}

//직접적인 상속관계가 아닌,
//한 클래스에서 다른 클래스를 참조하는 형태
class Police extends Gun {
	Gun pistol;
	
	public Police(int bnum) {
		super(0);
		
		if(bnum > 0) {
			pistol = new Gun(bnum);
		} else {
			pistol = null;
		}
	}
	
	public void targetShut() {
		if(pistol != null) {
			System.out.println("발사!");
		} else {
			System.out.println("총이 없습니다.");
		}
		
		shut();
	}
}

//복합 관계, has-a 관계
//클래스간의 관계를 상속보단 느슨하게 만들어주는 방법

/*
 * 사람
 * 직원
 * 강사
 * 교육생
 * 출석부
 * 
 * 직원, 강사, 교육생은 사람 클래스를 상속받는 형태 (is-a)
 * 출석부는 직원 강사와 복합관계로 설계 (has-a)
 * 
 */
public class HasMain {
	public static void main(String[] args) {
		
		Police p1 = new Police(3);
		Police p2 = new Police(0);
		p1.targetShut();
		p2.targetShut();
		
		Police p3 = new Police(0);
		
		//메소드 오버로딩
		System.out.println();
		System.out.println(12);
		System.out.println("Hello~");

	}
}
