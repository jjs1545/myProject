package com.douzone.file01;

import java.net.InetAddress;

/*
 * 
 * IP 관련 클래스, InetAddress
 * String getHostAddress(): 주소 정보 반환
 * String getHostName(): 컴퓨터 이름 반환
 * InetAddress getLocalHost()
 * 	: 현재 컴퓨터 InetAddress 객체 반환
 * InetAddress getByName(String hostName)
 *  : hostName으로 지정된 컴퓨터 InetAddress 객체 반환
 * InetAddress[] getAllByName(String hostName)
 *  : hostName으로 지정된 모든 컴퓨터의 InetAddress 객체 반환
 *   (하나의 도메인 이름으로 여러 대의 컴퓨터를 사용하는 경우)
 */
public class InetAddressMain {
	public static void main(String[] args) {
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 이름: " + localHost.getHostName());
			System.out.println("내 컴퓨터 IP 주소: " + localHost.getHostAddress());
			//www.douzone.com/
			System.out.println("더존의 주소 얻어오기");
			InetAddress addr = InetAddress.getByName("www.douzone.com");
			System.out.println(addr);
			
			System.out.println("네이버의 주소 얻어오기");
			InetAddress[] addrs = InetAddress.getAllByName("www.naver.com");
			for(InetAddress address : addrs) {
				System.out.println(address);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
