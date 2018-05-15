package com.douzone.day10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 정규 표현식
 * 	: 문자열을 원하는 패턴으로 처리하는 방법
 * 	: 문자열 입력에서 원하는 데이터 방식으로 제한
 * 
 * 	^ : 패턴 시작
 *  $ : 패턴 끝
 * [] : 문자의 종류 및 범위 제한
 * ex) [a-z] : 소문자 a부터 z까지 받는다.
 * 	   [A-Z] : 대문자 A부터 Z까지 받는다.
 * 	   [0-9] : 숫자 0부터 9까지 받는다.
 * () : 내부의 문자를 하나의 문자로
 * {} : 횟수 및 범위를 나타낸다.
 * 
 *  * : 적용되는 문자의 길이가 0-무한으로 받게끔
 *  
 */


public class PatternMain {
	public static void main(String[] args) {
//		String pattern = "^[a-zA-Z]*$";
//		String str = "abcdEFGhijk";
//		String str = "abcd1234EFG";
//		
//		if(Pattern.matches(pattern, str)) {
//			System.out.println("일치하는 패턴입니다.");
//		} else {
//			System.out.println("일치하지 않는 패턴입니다.");
//		}
		
//		Pattern p = Pattern.compile("(^[0-9]*$)");
//		System.out.println("입력: ");
		Scanner s = new Scanner(System.in);
//		String sVal = s.nextLine();
//		
//		Matcher m = p.matcher(sVal);
		
		/*
		// find(): 입력받은 문자열이 패턴과 일치할 때 true,
		//							아니라면 false
		// *내가 설정한 패턴에 따른다.
		if(m.find()) {
			int num = Integer.parseInt(sVal);
			System.out.println("입력하신" + num + "은 숫자 입니다.");
		} else {
			System.out.println("입력하신" + sVal + "는 숫자가 아닙니다.");
		}*/
		
		//전화를 번호를 입력받는 패턴을 작성해보세요.
		//p = Pattern.compile("^[0-9]*{3}-[0-9]*{4}$");
		//p = Pattern.compile("^\\d{3.4}-[0-9]");
//		String phoneNum;
//		while(true) {
//			System.out.println("입력: ");
//			phoneNum = s.nextLine();
//			Matcher mc = p.matcher(phoneNum);
//			
//			if(mc.find()) {
//				System.out.println("일치합니다.");
//			}else {
//				System.out.println("불일치 합니다.");
//			}	
//		}
		
		// \d : 숫자 [0-9]
		// \D : 숫자를 제외한 문자
		// \w : 영문, 숫자
		// \W : 영문, 숫자를 제외한 문자
		// \s : 공백 문자
		// \S : 공백 문자를 제외한 문자
		
		
		/*
		 * 
		 * 필수 조건
		 * 1. 시작과 끝
		 * 2. 표현 종류
		 * 3. 표현 범위
		 * 
		 */
		
		//이메일을 입력 받을 수 있는 패턴을 작성하시오.
		String pattern = "^\\w*@\\w*.\\w*$";
		String input ="jusin1545@gmail.com";
		
		if(Pattern.matches(pattern, input)) {
			System.out.println(input + " 일치 합니다.");
		} else {
			System.out.println(input + " 불일치 합니다.");
		}
		
		//HOMEWORK
		//1. 주민등록 번호
		//2. 핸드폰 번호
		//3. IP 주소
		//4. 파일 확장자 판단
		
		//3가지의 패턴을 입력받을 수 있는 프로그램을 작성하라
		
	/*	//1.주민등록 번호
		String pattern1 = "^\\d*{6}-[1-4]\\d*{7}$"; //주민등록번호 뒷자리 시작번호 [1-4] 제한
		System.out.println("1.주민등록번호 입력: ");
		String input1 = s.next();
		
		if(Pattern.matches(pattern1, input1)) {
			System.out.println(input1 + " 일치 합니다.");
		} else {
			System.out.println(input1 + " 불일치 합니다.");
		}
		
		//2.핸드폰 번호
		// ? : A|B|C
		// | : or 연산자 
		String pattern2 = "^01(?:0|1|[6-9])-\\d*{4}-\\d*{4}$";
		System.out.println("2.휴대폰 번호 입력: ");
		String input2 = s.next();
		
		if(Pattern.matches(pattern2, input2)) {
			System.out.println(input2 + " 일치 합니다.");
		} else {
			System.out.println(input2 + " 불일치 합니다.");
		}
		
		//3.IP 주소 (121.138.83.22)
		String pattern3 = "^\\d*{1,3}.\\d*{1,3}.\\d*{1,3}.\\d*{1,3}$"; //d*{1,3} -> 1개부터 3개
		System.out.println("3.IP 주소 입력: ");
		String input3 = s.next();
		
		if(Pattern.matches(pattern3, input3)) {
			System.out.println(input3 + " 일치 합니다.");
		} else {
			System.out.println(input3 + " 불일치 합니다.");
		}*/
		
		// (?i) : 대소문자 무시
		// \S . 문자까지 받기 때문에
		// 구분자 +를 사용하라
		String pattern4 = "^\\S+.(?i)(txt|jpg|exe|java)$"; 
		String input4 = "HelloMain.java";
		if(Pattern.matches(pattern4, input4)) {
			System.out.println("사용 가능한 확장자 입니다.");
		} else {
			System.out.println("사용 불가능한 확장자 입니다.");
		}
	}
}
