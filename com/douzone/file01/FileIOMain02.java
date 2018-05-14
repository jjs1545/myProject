package com.douzone.file01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIOMain02 {

	public static void write() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("iotest/writer.txt");	//writer.txt 파일 내보내기
			dos = new DataOutputStream(fos);					//writer.txt 파일에 텍스트(데이터) 보내기
			
			int num = 97;
			fos.write(num); //byte 타입으로 1byte 출력,
							// 97 -> a
			
			dos.writeInt(num);		//정수 타입으로 4byte 출력
									// 숫자 97이 아니라, 4byte 정수 형태,
			
			dos.writeDouble(12.34);	
			dos.writeChar('A');
			//쓴 사람만 알고 있다.
			//작성 방식을 알고 있어야 Input이 가능하다!
			
			
			System.out.println("파일 저장이 완료 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(dos != null) {
					dos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void read() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("iotest/writer.txt");
			dis = new DataInputStream(fis);
			
			System.out.println("읽어들인 데이터 출력");
			
			int c = fis.read();	 //기본 반환형 int
			System.out.println(c);
			
			int i = dis.readInt();
			double d = dis.readDouble();
			char ch = dis.readChar();
			
			System.out.println("정수 : " + i);
			System.out.println("실수 : " + d);
			System.out.println("문자 : " + ch);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//write();
		read();
	}
}
