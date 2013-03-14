package com.c4africa.chemfilla;

public class topicObj {
	int id;
	String name;
	int year;
	public topicObj(int id, String name,int year){
		this.id=id;
		this.name=name;
		this.year=year;
	}
	public String toString(){
		return name;
	}
}
