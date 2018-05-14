package com.douzone.file02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.douzone.util.FileClose;

/*
 * DAO : Data Access Object
 *  - 데이터 베이스에 접근하기 위한 객체
 * 
 */


public class UserDAO {
	ArrayList<UserVO> list = new ArrayList<>();
	
	public void run() {
		save();
		load();
	}
	
	private void save() {
		list.add(new UserVO("전효성", 30, "서울"));
		list.add(new UserVO("이효리", 40, "제주"));
		list.add(new UserVO("손예진", 36, "서울"));
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iotest/object_list.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			System.out.println("데이터베이스(.txt)파일의 객체 출력 완료.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
		}
	}
	
	private void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("iotest/object_list.txt");
			ois = new ObjectInputStream(fis);
			
			list = (ArrayList<UserVO>)ois.readObject();
			
			System.out.println("데이터베이스(.txt)의 객체 데이터 로드 완료!");
			
			for(UserVO u : list) {
				System.out.println("이름 : " + u.getName());
				System.out.println("이름 : " + u.getAge());
				System.out.println("이름 : " + u.getAddr());
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			FileClose.close(fis);
			FileClose.close(ois);
		}
	}
	
}
