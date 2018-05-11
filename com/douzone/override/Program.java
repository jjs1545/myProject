package com.douzone.override;

import java.util.Scanner;

//User Class
public class Program {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("동물을 선택하세요.");
		System.out.println("[1]. 고양이 [2]. 강아지");
		
		int num = s.nextInt();		
		
		//handler class
		Menu m = new Menu();
		m.run(num);
		
		/*
		switch (num) {
			case 1:
				Cat c = new Cat();
				c.cry();
			case 2:
				Dog d = new Dog();
				d.cry();
		}*/
		
		//Program, User 입장에서 눈에 보이네?
	}
}


/*
 * 
 * 상속 배열
 * Parent p = new Parent[]; //부모로 초기화
 * p = new Child01[];
 * p : Data Type ?
 * 부모의 형식
 * p. ?? 부모의 멤버들
 * p : [Child01][Child02]
 * 자식의 멤버를 호출하기 위해서는?
 * 
 */
