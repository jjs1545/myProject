package com.douzone.day10;

import java.net.StandardSocketOptions;

public class StringMain {
	public static void main(String[] args) {
		
		/*// 자바 메모리 추가 내용
		String str = new String("Hello");
		// JVM이 상수풀에 해당 데이터가 존재하는지 확인,
		// 존재한다면 이미 있는 데이터 참조!
		// 즉, "Hello" <- 요놈은 전부다 같은 놈!
		
		System.out.println("Hello" == "Hello");
		System.out.println(str == "Hello");
		System.out.println(str.equals("Hello"));
		
		str = "Sing.mp3";
		String sub = "Si";
		
		boolean bool = str.startsWith(sub);	// 시작점부터 인자로 넘겨주는 문자열로 시작하는지 판단해줌
		if(bool)
			System.out.println(sub + "로 시작합니다.");
		else
			System.out.println(sub + "로 시작하지 않습니다.");
		
		sub = ".txt";
		bool = str.endsWith(sub);	// 끝에 인자로 된 단어로 끝나는지
		
		if(bool) {
			System.out.println("텍스트 파일이 입니다.");
		}else {
			System.out.println("텍스트 파일이 아닙니다.");
		}
		
		String[] strArr = {"전효성","아이유","정우성","이선균"};
		for(String s : strArr) {
			if(s.equals("정우성")) {
				System.out.println(s);
			}
		}
		for(String s : strArr) {
			if(s.startsWith("정"))
				System.out.println("정씨인 사람: " + s);
		}
		for(String s : strArr) {
			if(s.endsWith("효성")) {
				System.out.println("이름이 효성인 사람: " + s);
			}
		}
		
		//indexOf() : 해당 문자(문자열)의 위치(Index)를 반환
		int searchIdx = str.indexOf('o');
		System.out.println("o의 위치: " + searchIdx);
		
		searchIdx = str.indexOf("x");
		System.out.println("x의 위치: " + searchIdx); //-1 출력시 값이 없음을 나타낸다
		
		//문자열은 시작위치를 반환
		searchIdx = str.indexOf("world");
		System.out.println("world의 위치: " + searchIdx);
		 */
		
		/*String str = "Hello world";
		// 'l'의 위치를 모두 찾을 때
		char c = 'l';
		int searchIdx = str.indexOf(c);			//초기값
		while(searchIdx != -1) {			//조건식 -> searchIdx == -1일때 탈출 -1이아닐때 while문 실행
			System.out.println(c + "의 위치는" + searchIdx);
			searchIdx = str.indexOf(c, searchIdx + 1); //위치 설정 / 증감(위치)
		}
		
		searchIdx = -1;
		while((searchIdx = str.indexOf(c, searchIdx +1)) != -1) {
			System.out.println(c + "의 위치는 " + searchIdx);
		}
		
		str = "Hello Java Program";
		String result = str.substring(3, 10);		//3부터 10전까지 추출!!(3~9)
		
		// 길이가 인덱스의 위치로 사용할 수 없다.
		// 배열의 마지막 값을 넘어가기 때문에!
		// 하지만, substring()의 두번째 인자는 넘어가는 Index -1 값
		System.out.println(str + "의 길이: " + str.length() );
		System.out.println(result + "의 길이" + result.length());
		
		//문자열 뒤에 붙여라.
		result = str.concat("~~!!");	
		System.out.println("concat(): " + result);
		
		result = str + "~~!!";
		System.out.println("문자열 (+)연산: " + result);
		
		//문자열을 대체하라.
		result = str.replace('a', 'o');
		System.out.println("str: " + str);
		System.out.println("result: " + result);
		
		//양쪽에 불필요한 공백을 없애라.
		str = "			Hello			";
		result = str.trim();
		System.out.println("trim() 전: " + str);
		System.out.println("trim() 후: " + result);
		
		char ch = 'a';
		System.out.println(ch ^ 1<<5);
		
		str = "MySql MongDB";
		System.out.println("소문자로 변경: " + str.toLowerCase());
		System.out.println("대문자로 변경: " + str.toUpperCase());
		
		str = "전효성:아이유:강다니엘:사나";
		// 구분자(Token)기준으로 잘라서 배열에 넣어라.
		String[] sArr = str.split(":");
		for(String s : sArr) {
			System.out.println(s + " ");
		}
		System.out.println();
		
		int num = 1234;
		// num의 값을 문자열로 반환하라.
		// 정수뿐만 아니라 모두 가능!
		str = Integer.toString(num);
		System.out.println("str: " + str);
		
		//char[] -> String
		//1. String.valueOf()
		char[] chars = {'A', 'B', 'C', 'D', 'E'};
		String str1 = String.valueOf(chars);
		System.out.println("str: " + str);
		
		//2. Index를 활용한 변환
		String str2 = "";
		for(int idx=0;idx<chars.length;idx++) {
			str2 += chars[idx];
		}
		System.out.println("str2: " + str2);
		
		//3. String 객체 생성
		String str3 = new String(chars);
		System.out.println("str3: " + str3);
		
		//4. Wrapper 클래스
		String str4 = "";
		for(int idx=0; idx<chars.length; idx++) {
			str4 += new Character(chars[idx]).toString();
		}
		System.out.println("str4: " + str4);*/
		
		//StringBuffer Class
		System.out.println("String 연산...");
		String str ="";
		long start = System.currentTimeMillis();
		
		for(int i=0; i<10000; i++) {
			str = str + i;
		}
		
		long end = System.currentTimeMillis();
		System.out.println("소요 시간: " + (end-start)/1000.0 + "s");
		
		System.out.println("StringBuffer 연산...");
		StringBuffer sb = new StringBuffer();
		long start2 = System.currentTimeMillis();
		for(int i=0; i<100000; i++) {
			sb.append(i);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("소요 시간: " + (end2-start2)/1000.0 + "s");
	}
}
