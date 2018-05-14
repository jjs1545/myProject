package com.douzone.singleton;

public class CatMain {
	public static void main(String[] args) {
		//서로 다른 cat이 생성된다.
//		Cat cat1 = new Cat();
//		Cat cat2 = new Cat();
		
		//cat을 하나만 생성하기 위해 getInstance() 호출
		Cat cat1 = Cat.getInstance();
		Cat cat2 = Cat.getInstance();
		
		System.out.println("cat1 : " + cat1);
		System.out.println("cat2 : " + cat2);
		
		/*
		 \0
		 널 문자
		 \b
		 백스페이스
		 \t  수평 탭  \n  줄바꿈 문자  \v  수직 탭  \f
		 폼 피드
		 \r
		 캐리지 리턴
		 \"  큰따옴표  \'  작은따옴표  \\ 역슬래시 \xXX
		 두 개의 16진수 숫자 XX에 의해 지정되는 Latin-1 문자.
		 \XXX
		 1과 377 사이의 8진수 숫자 XXX에 의해 지정되는 Latin-1 문자. 
		*/
		
		// -- 사용 되는 곳 --
		// \r\n : 윈도우
		// \n : 리눅스(유닉스)
		// \r : Mac 
		
		/*
			 %n : 해당 플랫폼별 줄 바꿈 문자 출력 (독립적)
			 \n : 풀랫폼에 독립적인 줄 바꿈 문자 출력
			 종속적 ~ 이식성이 떨어진다.
			 독립적 ~ 이식성이 뛰어나다.
		 */
		
		 
		// 자바에서는 해당 플랫폼에 따라 변환
		System.out.printf("%d\t\n %c\t", 12, 'A');
		
		System.out.printf("%d\r%c\n", 12, 'A');
		System.out.printf("%d\r%c\n", 12, 'A');
		System.out.printf("%d\n%c\n", 12, 'A');
		System.out.printf("%d%n%c\n", 12, 'A');
		System.out.printf("Hello~%n"); //서식문자는 printf()에서 사용해라 -> 독립적이므로 다른 언어에도 사용가능하다(이식성이 높다)
		System.out.print("Hello~\n");
		System.out.println("Hello~"); //권장
		System.out.print("Hi~");
	}
}
