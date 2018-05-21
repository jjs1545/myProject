package com.douznoe.dynamic;

//제네릭 동적 배열
public class DArray<datatype> {
	Object[] buffer; //Object 배열
	int capacity; // 저장소크기
	int usage; //보관 개수
	
	public DArray(int capacity) {
		this.capacity = capacity;
		buffer = new Object[capacity];
		usage = 0;
	}
	
	public boolean isFull() {
		return usage == capacity;
	}
	
	public boolean add(datatype value) {
		if(isFull()) {
			capacity++;
			Object[] temp = buffer;
			buffer = new Object[capacity];
			System.arraycopy(temp, 0, buffer, 0, usage);
		}
		buffer[usage] = value;
		usage++;
		return true;
	}
	
	public void viewAll() {
		String str = String.format("용량 크기 : %d, 보관 개수: %d", capacity, usage); // format = printf
		System.out.println(str);
		for(int i=0; i<usage; i++) {
			System.out.print(buffer[i]+ " ");
		}
		System.out.println();
	}
	
	
}
