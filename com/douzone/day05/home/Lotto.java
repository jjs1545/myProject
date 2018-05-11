package com.douzone.day05.home;

import java.util.Random;

public class Lotto {
	Random r = new Random();
	private int[] lotto = new int[6];

	public int[] getLotto() {
		return lotto;
	}

	public void setLotto(int[] lotto) {
		this.lotto = lotto;
	}

	public Lotto() {	
		for(int i=0;i<lotto.length;i++){
			lotto[i]=r.nextInt(45)+1;
			for(int j=0;j<i;j++){
				if(lotto[i]==lotto[j]){
					i--;
				}
			}
		}
		
	}	
	
	public int[] ltArray() {
		return lotto;
	}
	
	public void info() {
		System.out.println("이번주 당첨 번호는 : ");
		for(int j=0;j<lotto.length;j++){
			System.out.print(lotto[j]+" ");
		}
		System.out.println(" ");
	}
}
