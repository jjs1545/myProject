package com.douzone.day08.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

// 쓰레드 활용한 채팅방
class Echo extends Thread{
	private Socket socket;
	
	public Echo(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			InetAddress client = socket.getInetAddress();
			System.out.println("시스템: [" + client + "] 님이 참가했습니다.");
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String msg = null;
			while (true) {
				Set<String> msgSet = new HashSet<String>();
				msg = br.readLine();
				msgSet.add(msg);
				
				if(msg == null) {
					System.out.println("[" + client.getHostAddress() + "] 님이 접속을 종료했습니다.");
					
					socket.close();
					break;
				}
				for(String s : msgSet) {
					System.out.println("[" + client.getHostAddress() + "] : " + s );
				}
				
				pw.println(msg);
				pw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}

public class ChatServerMain {
	public static void main(String[] args) {
		try {
			
			ServerSocket server = new ServerSocket(9600);
			System.out.println("대화방이 개설되었습니다!");			
			
			while (true) {
				Socket client = server.accept();
				Echo echoThread = new Echo(client);
				echoThread.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}
}
