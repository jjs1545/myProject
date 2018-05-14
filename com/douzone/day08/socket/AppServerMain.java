package com.douzone.day08.socket;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerMain {
	public static void main(String[] args) {
		try { 
			
			//서버소켓 생성 시 포트넘버 전달
			ServerSocket server = new ServerSocket(10000);
			System.out.println("어플리케이션 서버 구동 중..");
			
			Socket Client = server.accept(); // 클라이언트를 기다려!
			String msg = "Hello~ 반갑습니다!"; 	 // 서버 -> 클라이언트
			OutputStream os = Client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(msg);
			dos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
