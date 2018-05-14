package com.douzone.file01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.douzone.util.FileClose;

public class FileMain03 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;		//속도 빠르게 하기 위해
		BufferedWriter bw = null;		//버퍼사용
	
		try {
			fr = new FileReader("iotest/ArrayMain.java");	  // java 파일 읽어 들이기
			fw = new FileWriter("iotest/ArrayMain.java.txt"); // java 파일을 txt 파일로
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			
			long start = System.currentTimeMillis();
			
			while(true) {
				//Bufferd 필터 클래스 장착 x
//				int c = fr.read();
//				if(c == -1) break;
//				fw.write(c);
//				fw.flush();
				
				//필터 클래스 장착
				String str = br.readLine();
				/*
				 * 안녕하세요.
				 * 오늘 뭐 먹을까요?
				 */
				//안녕하세요. 오늘 뭐 먹을까요?
				//enter 시 개행을 수행해야하지만,
				//str은 enter가 없기에 한줄 출력의 결과를 보인다.
				if(str == null) break;
				//bw.write(str);
				
				//개행문자추가
				//bw.write(str+"\r\n");
				
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			long end = System.currentTimeMillis();
			System.out.println("복사 완료");
			System.out.println("소요 시간: " + (end-start) + "ns");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fr);
			FileClose.close(fw);
		}
	}
}
