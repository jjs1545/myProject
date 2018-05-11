package com.douzone.override;

//handler 클래스

public class Menu {
	public void run(int num) {
		
		/*Scanner s = new Scanner(System.in);
		System.out.println("동물을 선택하세요.");
		System.out.println("[1]. 고양이 [2]. 강아지");
		
		int num = s.nextInt();		
		*/
		//객체 생성 및 인터페이스 눈에 보인다.
		switch(num) {
		case 1:
			Cat c = new Cat();
			c.cry();
			break;
		case 2:
			Dog d = new Dog();
			d.cry();
		}
		
	}
}
