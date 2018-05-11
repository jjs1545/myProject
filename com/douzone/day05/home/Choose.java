package com.douzone.day05.home;

import java.util.Random;
import java.util.Scanner;

public class Choose {
	private int num=0;
	private int manualLt[] = new int[6]; //수동 로또 배열
	private int autoLt[] = new int[6];	 //자동 로또 배열
	private static int temp[] = new int[6]; 	 //자동 로또 배열 저장

	Scanner in = new Scanner(System.in);
	Random r = new Random();
	
	public Choose() {
		
	}

	public void select() {
		System.out.println("로또 구매 기기 입니다.");
		System.out.println("[1]수동 or [2]자동 선택하시오: ");
		num=in.nextInt();
		
		if(num==1) {
			for(int i=0;i<manualLt.length;i++){
				System.out.print("숫자 6개를 입력하시오(단,1~45번): ");
				manualLt[i]=in.nextInt();
				for(int j=0;j<i;j++){
					if(manualLt[i]==manualLt[j]){
						i--;
					}
				}
			}
		}else if(num==2) {
			for(int i=0;i<autoLt.length;i++){
				autoLt[i]=r.nextInt(45)+1;
				for(int j=0;j<i;j++){
					if(autoLt[i]==autoLt[j]){
						i--;
					}
				}
			}
		}
		
		for(int k=0; k<temp.length; k++) {
			System.out.println(autoLt[k]);
			temp[k]=autoLt[k];
		}
		
	}
	
		
	public int[] getManualLt() {
		return manualLt;
	}
	
	public static int[] getTemp() {
		return temp;
	}

	public void info(){
		if(num==1) {
			System.out.println("입력한 숫자 6개:" );
			for(int i=0;i<manualLt.length;i++){
				System.out.print(manualLt[i]+" ");
			}
			System.out.println(" ");
		}else if(num==2){ 
			System.out.println("자동 숫자 6개:" );
			for(int i=0;i<autoLt.length;i++){
				System.out.print(autoLt[i]+" ");
			}
			System.out.println(" ");
			/*System.out.println("===========");
			for(int r=0; r<temp.length; r++) {
				System.out.print(temp[r] + " ");
			}
			System.out.println(" ");
			System.out.println("===========");*/
		}
	}
}
