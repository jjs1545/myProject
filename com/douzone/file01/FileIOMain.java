package com.douzone.file01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIOMain {
	public static void main(String[] args) {
		/*
		 * 
		 * 1. 스트림을 연다.
		 * 2. 작업을 수행한다.
		 * 3. 스트림을 닫는다.
		 * 
		 */
/*		//1. 스트림을 연다.
		InputStream is = System.in;
		try {
			//2. 작업을 수행한다.
			System.out.println("입력하시오.");
			byte[] bytes = new byte[20]; //문자 하나하나를 저장할 배열
			
			while(true) {
				// -1 : EOF (End Of File)
				if(is.read(bytes) == -1) { //입력받는 것이 끝날 때 까지
					break;
				}
				
				for(byte b : bytes) {
					System.out.print((char)b);
				}
				
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			//3. 스트림을 닫는다
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/

		
		//한글을 입력받기 위한 예제
		InputStream is2 = System.in;
		//문자 스트림을 바꾸기 위한 필터 클래스, 한글을 받기 위해
		InputStreamReader isr = new InputStreamReader(is2);
		
		try {
			while(true) {
				int c = isr.read();
				if(c == -1) {
					break;
				}
				System.out.print((char)c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(isr != null) {
					isr.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(is2 != null)
					is2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
