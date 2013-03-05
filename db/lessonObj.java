package com.c4africa.chemfilla;

public class lessonObj {
	int id;
	int sub_id;
	String title;
	String data;
	String link;
	public lessonObj(int id,int sub_id,String title,String data,String link){
		this.id=id;
		this.sub_id=sub_id;
		this.title=title;
		this.data=data;
		this.link=link;
	}
	public String toString(){
		return data;
	}
}
