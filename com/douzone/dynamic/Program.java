package com.douznoe.day04.dynamic;

public class Program {
	public static void main(String[] args) {
		/*
		System.out.println("---- IntDArray Test ----");
		IntDArray idarr = new IntDArray(3);
		idarr.viewAll();
		idarr.add(3);
		idarr.viewAll();
		idarr.add(5);
		idarr.viewAll();
		idarr.add(7);
		idarr.viewAll();
		
		idarr.add(9);
		idarr.viewAll();
		idarr.add(10);
		idarr.viewAll();
		idarr.add(11);
		idarr.viewAll();
		idarr.add(12);
		idarr.viewAll();
		
		idarr.delete(4);
		idarr.viewAll();
		
		 * 
		 * 과제 : 저장소가 가득찼을때 false를 return하지 않고 동적으로 저장소 크기를 늘려라!
		 * 
		 *
		*/
		
		System.out.println("---- DArray Test ----");
		DArray<Integer> darr = new DArray<Integer>(3);
		darr.viewAll();
		darr.add(3);
		darr.viewAll();
		
		DArray<String> darr2 = new DArray<String>(3);
		darr.viewAll();
		//darr.add("One");
		
	}
}
