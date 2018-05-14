package com.douzone.day08.echo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * [Client]
 * Construct
 * 	: Socket(String hostName, int port)
 * Method
 *  : InputStream getInputStream()
 *  	현재 소켓과 관련된 InputStream 객체 반환
 *    OutputStream getOutputStream()
 *    	현재 소켓과 관련된 OutputStream 객체 반환
 *    void close()
 *    	소켓을 닫는다.
 */

public class EchoClientMain {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("192.168.1.36", 9600);
			BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
			
			//서버에 내용을 전송할 객체
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			//서버에서 재전송한 내용을 받는 객체
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				System.out.println("메시지 입력(exit 종료) : ");
				String msg = key.readLine();
				
				if(msg.equalsIgnoreCase("exit")) {
					System.out.println("서버와 연결을 종료합니다.");
					client.close();
					break;
				}
				// 서버에 메시지 전송
				pw.println(msg);
				pw.flush();
				
				// 서버가 재전송한 메시지 출력
				String echoMsg = br.readLine();
				System.out.println("서버 재전송 메세지: " + echoMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
