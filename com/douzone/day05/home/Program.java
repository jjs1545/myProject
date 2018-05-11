package com.douzone.day05.home;

/*
 * 국내에서 발매되는 로또는 1부터 45까지의 숫자 중 자신이 원하는 6개의 숫자를 임의로 고르는 ‘645 방식’을 채택하고 있다.
 */

public class Program {
	public static void main(String[] args) {
		/*
		 * 로또 프로그램을 작성하시오.
		 */
		//TODO
		Choose choose = new Choose();
		choose.select();
		choose.info();
		Lotto lotto = new Lotto();
		lotto.info();
		Win win = new Win();
		win.compare();
		win.info();
	}
}
