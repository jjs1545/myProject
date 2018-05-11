package com.douzone.day07.thread;

class GirlFriendThread extends Thread {
	@Override
	public void run() {
		System.out.println("(여자친구): 저는 여자친구 쓰레드입니다.");
		System.out.println("(여자친구): 오늘은 남자친구를 시험해보겠습니다.");
		System.out.println("(여자친구): 남자친구가 10초도 못 기다리면 안되겠죠?");
		
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("(여자친구): " + i + "초가 지났네요. 기다리고 있을까요?");
		}
		//System.out.println("(여자친구): 남자친구가 없어졌어요!");
		System.out.println("(여자친구): 남자친구가 기다려줬어요! 영화보러 갈게요~");
	}
}

class BoyFriendThread extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("(남자친구): 저는 남자친구 쓰레드입니다.");
			System.out.println("(남자친구): 오늘 여자친구와 어벤져스를 보기로 했어.");
			System.out.println("(남자친구): 영화 시작시간이 얼마 남지 않았어요.");
			System.out.println("(남자친구): 여자친구를 기다립니다..");
			
			GirlFriendThread gf = new GirlFriendThread();
			gf.start();
			//gf.join();// 앞에 쓰래드가 끝날때까지 뒤에 문장을 대기 시킨다. 블록 상태 
			gf.join(5000);	//5초 대기
			
			//System.out.println("(남자친구): 여자친구가 드디어 왔네요!");
			System.out.println("(남자친구): 하... 5초나 기다렸어... 집에 갈게...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class JoinMain {
	
	public static void main(String[] args) {
		BoyFriendThread bf = new BoyFriendThread();
		bf.start();
	}
}
