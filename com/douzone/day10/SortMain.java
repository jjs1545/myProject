package com.douzone.day10;


class Sort {
	//Call By Reference: 주소에 의한 참조
	//자바는 Call By Value의 형식! 흉내만 내보자
	public static void swap(int[] data, int a, int b) {
		int temp = 0;
		temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
	public static void viewSort(int[] data) {
		for(int i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
/*
 * 퀵 정렬
 * 1. 정렬할 데이터 중 하나를 pivot 선정
 * 2. pivot을 기준으로 pivot보다 작은 값은 왼쪽으로
 * 						  큰 값은 오른쪽으로 분할
 * 3. 분할된 각각의 리스트를 위의 과정으로 반복한다.
 * 
 */

class QuickSort {
	public void sort(int[] data, int l, int r) {	
		int left = l;
		int right = r;
		int pivot = data[(l+r)/2];
		
		do {
			while(data[left] < pivot) {
				left++;
			}
			while(data[right] > pivot) {
				right--;
			}
		 	if(left < right) {
		 		Sort.swap(data, left, right);
		 		Sort.viewSort(data);
		 		left++;
		 		right--;
		 	}
		}while(left <= right);
	
		if(l < right);
			sort(data, l, right);
		if(r > left);
			sort(data, left, r);
	}	
}
	
/*
 * 삽입 정렬
 * : 원소 배열의 요소를 이미 정렬된 배열과 비교하여,
 * : 자신의 위치에 삽입하는 정렬!
 */

class InsertSort { 
	public void sort(int[] data) {
		
		for(int i=1; i<data.length; i++) {
			for(int j=i; j>0; j--) {
				if(data[j-1] > data[j]) {
					Sort.swap(data, j-1, j);
					Sort.viewSort(data);
				}else {
					break;
				}
			}
		}
		
		/*for(int i=1; i<data.length; i++ ) { //정렬할 범위 확대
			int temp = data[i];
			int sub = i - 1;
			while((sub>=0) && (data[sub]) > temp) {
				data[sub + 1] = data[sub];
				sub--;
			}
			data[sub + 1] = temp;
			Sort.viewSort(data);
		}*/
	}
}

/*
 * 
 * 선택 정렬
 * 1. 정렬할 데이터 중 가장작은(큰) 데이터를 찾는다.
 * 2. 가장 작은 값을 찾았다면 맨 앞의 요소와 Swap
 * 3. 정렬할 범위를 줄이면서 정렬!
 * 시간 복잡도 : O(n^2)
 * 
 */

class SelectSort {
	public void sort(int[] data) {
		int maxIdx = 0; //가장 큰 데이터를 뒤로 보내도 된다!
		for(int i = data.length; i>1; i--) {
			maxIdx=0;
			for (int j=1; j<i; j++) {
				if(data[maxIdx] < data[j]) {
					maxIdx = j;
				}
			}
			Sort.swap(data, maxIdx, i-1);
			Sort.viewSort(data);
		}
	}
}

/*
 * 버블 정렬
 * 	: 인접한 두 요소를 비교하여 정렬하는 방법
 * 	시간 복잡도 : O(n^2)
 */
class BubbleSort {
	//Call By Value: 값에 의한 참조
	//단순히 값만 받아오기에,
	//매개변수 a와 넘어온 data[j-1]의 주소가 다르다.
	//*이거 쓰지마세염
	public /*static*/ void swap(int a, int b) {
		int t=0;
		t = a;
		a = b;
		b = t;
	}

	//Call By Reference: 주소에 의한 참조
	//자바는 Call By Value 형식
	
	
	public void sort(int[] data) {
		int temp = 0;
		for(int i=data.length; i>1; i--) {	//정렬할 범위 축소
			for(int j=1; j<i; j++) {
				if(data[j-1] > data[j]) {
					//swap(data[j-1], data[j]);
					Sort.swap(data, j-1, j);
					Sort.viewSort(data);
				}
			}
		}
		/*for(int i=0;i<data.length-1;i++) {
			for(int j=0; j<data.length-1; j++) { 
				if(data[j]>data[j+1]) {
					temp=data[j];
					data[j]=data[j+1];
					data[j+1]=temp;
				}
			}
		}*/
	}
}

public class SortMain {
	public static void main(String[] args) {
		int data[] = { 1, 2, 3, 4, 5};
		Sort.viewSort(data);
		System.out.println("===============");
		/*BubbleSort bs = new BubbleSort();
		bs.sort(data);*/
		
		SelectSort ss = new SelectSort();
		ss.sort(data);
		
		/*InsertSort is = new InsertSort();
		is.sort(data);*/
		
		/*QuickSort qs = new QuickSort();
		qs.sort(data, 0, data.length-1);*/
	}
}


