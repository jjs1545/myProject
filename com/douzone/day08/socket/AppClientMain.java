package com.douzone.day08.socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class AppClientMain {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("192.168.1.28", 10000); //ip번호 와 포트번호 넘긴다.
			InputStream is = client.getInputStream();		   //넘어온 스트림을 받는다.
			DataInputStream dis = new DataInputStream(is); 	   //넘어온 데이터를 받는다.
			
			String msg = dis.readUTF();
			System.out.println("서버에서 보낸 메시지: " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
