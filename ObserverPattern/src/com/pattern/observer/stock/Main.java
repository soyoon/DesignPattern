package com.pattern.observer.stock;
public class Main{
	public static void main(String[] args){
		Stock st=new Stock("홍길동", "Google", 150);
		ObserverView  o1=new ObserverView(st);
		ObserverView  o2=new ObserverView(st);
	}
}
