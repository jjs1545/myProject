package com.douzone.file01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.douzone.util.FileClose;

public class FileIOMain04 {
	public static void write() {
		UserInfo user = new UserInfo("정채연", 22, "서울시 서초");
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			//fos = new FileOutputStream("iotest/object.txt");	//자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 
			fos = new FileOutputStream("iotest/object_transient.txt");	//사용할 수 있도록 바이트(byte) 형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를
																//다시 객체로 변환하는 기술(역직렬화)을 아울러서 이야기합니다.
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(user);
			
			System.out.println("파일에 객체 출력을 완료하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(oos, fos);
		}
	}
	
	public static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			//fis = new FileInputStream("iotest/object.txt");
			fis = new FileInputStream("iotest/object_transient.txt");
			ois = new ObjectInputStream(fis);
			
			//객체를 읽어들이는 readObject();
			UserInfo user = (UserInfo)ois.readObject();	//명시적 형변환
			
			System.out.println("파일에서 객체 읽기를 완료하였습니다.");
//			System.out.println("이름: " + user.getName());
//			System.out.println("나이: " + user.getAge());
//			System.out.println("주소: " + user.getAddr());
			
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(ois, fis);
		}
	}
	
	public static void main(String[] args) {
		write();
		read();
	}
}
