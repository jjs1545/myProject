package com.douzone.day05.home;

public class Win {
	int cnt=0;
	
	public Win() {
		
	}
	
	boolean compare() {
		Choose ch = new Choose();
		Lotto lt = new Lotto();
		
		for(int i=0;i<ch.getManualLt().length;i++) {
			if(ch.getManualLt()[i]==lt.getLotto()[i]){
				cnt++;
			}
		}
		for(int j=0;j<Choose.getTemp().length;j++){
			if(Choose.getTemp()[j]==lt.getLotto()[j]){
				cnt++;
			}
		}
		
		for(int j=0;j<Choose.getTemp().length;j++){
			System.out.print(Choose.getTemp()[j] + " ");
		}
		System.out.println(" ");
		return false;
	}
	
	void info() {
		System.out.println(" ");
		System.out.println("============당첨 결과============");
		System.out.println(cnt+"개 맞았습니다.");
		if(cnt==6)      {System.out.println("로또 1등에 당첨되셨습니다.");}
		else if(cnt==5) {System.out.println("로또 2등에 당첨되셨습니다.");}
		else if(cnt==4) {System.out.println("로또 3등에 당첨되셨습니다.");}
		else if(cnt==3) {System.out.println("로또 5등에 당첨되셨습니다.");}
		else if(cnt<3)  {System.out.println("당첨 실패");}
	}
}
