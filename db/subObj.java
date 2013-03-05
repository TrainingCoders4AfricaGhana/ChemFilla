package com.c4africa.chemfilla;

public class subObj {
	int id;
	int topic_id;
	String name;

	public subObj(int id, int topic_id, String name) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.topic_id=topic_id;
		this.name=name;
	}
	public String toString(){
		return name;
	}
}
