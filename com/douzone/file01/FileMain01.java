package com.douzone.file01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMain01 {
	public static void main(String[] args) {
		/*
		 * 
		 * 1. 스트림을 연다
		 * 2. 작업을 수행한다.
		 * 3. 스트림을 닫는다.
		 * 
		 */
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		//이미지 파일 복사
		try {
			
			//1. 스트림을 연다.
			fis = new FileInputStream("C:\\Users\\bit34\\eclipse-workspace\\Test\\iotest\\001.jpg"); //스트림을 열 대상의 경로
			fos = new FileOutputStream("iotest/002.jpg"); //파일을 (내보낸다) 복사
			
			long start = System.currentTimeMillis();
			
			//2. 작업을 수행한다.
			while(true) {
				int c = fis.read();
				if(c == -1) {
					break;
				}
				fos.write(c);
				fos.flush(); //버퍼를 비워준다.
			}
			
			
			long end = System.currentTimeMillis();
			System.out.println("복사를 완료했습니다.");
			System.out.println("소요 시간 : " + (end-start)/1000.0 + "s");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//3. 스트림을 닫아라.
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
