package com.douznoe.dynamic;

public class IntDArray {
	int[] buffer;
	int capacity;
	int usage;
	int[] temp;
	public IntDArray(int capacity) {
		this.capacity = capacity;
		buffer = new int[capacity];
		usage = 0;
	}
	
	public boolean isFull() {
		return usage == capacity;
	}
	public boolean add(int value) {
		//다음 코드는 데이터가 꽉 찼을 때 더이상 추가를 시키지 않는다.
		//수정을 통해 데이터가 꽉 차있는 상대라도 데이터가 들어갈 수 있도록 
		//동적 배열을 만드시오. (용량을 증가 시킨다.)
		//TODO
		if(isFull()) {
			capacity++;
			
			temp = new int[capacity];
			for(int i=0;i<temp.length-1;i++){
				temp[i] = buffer[i];
			}
			temp[usage] = value;
			
			buffer = new int[capacity];
			for(int j=0;j<buffer.length;j++) {
				buffer[j]=temp[j];
			}
			usage++;
			return false;
		}
		
		buffer[usage] = value;
		usage++;
		return true;
	}
	
	public boolean delete(int value) {
		
		
		for(int k=value-1;k<buffer.length-1;k++){
			buffer[k]=buffer[k+1];
		}
		
		return true;
	}
	
	public void viewAll() {
		String str = String.format("저장소 크기 : %d, 보관 개수: %d" , capacity, usage);
		
		System.out.println(str);
		for(int i=0; i<usage; i++) {
			System.out.print(buffer[i]+" ");
		}
		
		System.out.println();
	}
}
