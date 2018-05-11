package com.douzone.inter;

public interface TV {
	
	int MAX_VOLUE_SIZE = 40;
	int MIN_VOLUME_SIZE = 0;
	
	/* public abstract --> 생략 가능 */ void powerOn();
	public abstract void PowerOff();
	void voluemUp();
	void volueDown();
	void channelUp();
	void channelDown();
	void mute();
	
}
