package jp.co.comnic.lesson.azami;

import java.util.LinkedList;

public class ListClient {
	public static void main(String[] args) {
		
		List list = new List();
		
		list.add("梶原");
		list.add("クエスト失敗");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	
		
	}

}
