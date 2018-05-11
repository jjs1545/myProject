package com.douzone.day07;

class Banana {
	int sugar;
	
	public Banana(int sugar) {
		this.sugar = sugar;
	}
	
	public void info() {
		System.out.println("당도: " + sugar);
	}
}

class Orange {
	int vita;
	public Orange(int vita) {
		this.vita = vita;
	}
	public void info() {
		System.out.println("vita: " + vita);
	}
}

class Box<datatype> { 
//	Object item;
	datatype item;
	public void store(/*object*/datatype item) {
		this.item=item;
	}
	public /*Object*/datatype pullout() {
		return item;
	}
}

public class GenericMain {
	public static void main(String[] args) {
		Box<Banana> b = new Box<Banana>();
		b.store(new Banana(5));
		Banana ba = b.pullout();
		ba.info();
		
		Box<Orange> o = new Box<Orange>();
		o.store(new Orange(10));
		Orange or = o.pullout();
		or.info();
		
//		Box b = new Box();
//		b.store(new Banana(5));
//		
//		//Class Cast Exception
//		b.store(new Orange(10));
//		Banana banana = (Banana)b.pullout();
//		banana.info();
//		b.store(new Banana(10));
//		System.out.println(b.pullout());
	}
}
