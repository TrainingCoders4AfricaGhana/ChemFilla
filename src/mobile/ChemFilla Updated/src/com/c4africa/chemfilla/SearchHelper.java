package com.c4africa.chemfilla;

import java.util.List;

import android.content.Context;
import android.database.Cursor;

public class SearchHelper extends ChemFillaDB{
	private List<subObj> resultedsubs;
	private List<lessonObj> resultedlessons;
	public SearchHelper(Context c){
		super(c);
	}
	public List<lessonObj> getLessons(){
		return resultedlessons;
	}
	public List<subObj> getSubs(){
		return resultedsubs;
	}
	public void search(String searchText) throws Exception {
		// TODO Auto-generated method stub
		searchSub(searchText);
		searchLessons(searchText);
	}
	private void searchSub(String searchText){
		String []columns = {subTopic.getFieldId(),subTopic.getFieldTopicId(),subTopic.getFieldName()};
		String [] selArg={searchText};
		Cursor cursor=myDatabase.query(subTopic.getTableName(), columns, columns[2]+" LIKE %?%", selArg, null, null, null);
		for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
			resultedsubs.add(subTopic.cursorToTopicObj(cursor));
		}
	}
	private void searchLessons(String searchText){
		String []columns={lesson.getFieldId(),lesson.getFieldSubId(),lesson.getFieldTitle(),lesson.getFieldLessonInfo(),lesson.getFieldLink(),lesson.getFiledResources()};
		String [] selArg={searchText,searchText};
		Cursor cursor= myDatabase.query(lesson.getTableName(), columns, columns[2]+" LIKE %?% OR "+columns[3]+" LIKE %?%", selArg, null, null, null);
		for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
			resultedlessons.add(lesson.cursorToTopicObj(cursor));
		}
	}
}
