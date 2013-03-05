package com.c4africa.chemfilla;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class lesson {
	private static final String TABLE_NAME="lesson";
	private static final String FIELD_ID="id";
	private static final String FIELD_SUB_ID="sub_id";
	private static final String FIELD_TITLE="title";
	private static final String FIELD_LESSON_INFO="lessonInfo";
	private static final String FIELD_LINK="link";
	private static final String FIELD_RESOURCES="resources";

	public static void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_NAME+ " (" +
				FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				FIELD_SUB_ID + " INTEGER, " +
				FIELD_TITLE + " TEXT NOT NULL, " +
				FIELD_LESSON_INFO + " TEXT NOT NULL, " +
				FIELD_LINK + " TEXT, "+
				FIELD_RESOURCES+ " TEXT)"
				);
	}
	public static String getTableName(){
		return TABLE_NAME;
	}
	public static String getFieldId(){
		return FIELD_ID;
	}
	public static String  getFieldSubId(){
		return FIELD_SUB_ID;
	}
	public static String getFieldTitle(){
		return FIELD_TITLE;
	}
	public static String getFieldLessonInfo(){
		return FIELD_LESSON_INFO;
	}
	public static String getFieldLink(){
		return FIELD_LINK;
	}
	public static String getFiledResources(){
		return FIELD_RESOURCES;
	}
	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
		onCreate(db);
	}
	public static long createEntity(int id, int sub_id, String title, String data,
			String link, String resources, SQLiteDatabase myDatabase) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(FIELD_ID, id);
		cv.put(FIELD_SUB_ID, sub_id);
		cv.put(FIELD_TITLE, title);
		cv.put(FIELD_LESSON_INFO, data);
		cv.put(FIELD_LINK, link);
		cv.put(FIELD_RESOURCES, resources);
		return myDatabase.insert(TABLE_NAME, null, cv);
	}
	public static List<lessonObj> getLessons( int sub_id,
			SQLiteDatabase myDatabase) {
		String[]allColomns={FIELD_ID,FIELD_SUB_ID,FIELD_TITLE,FIELD_LESSON_INFO,FIELD_LINK,FIELD_RESOURCES};
		List<lessonObj> lessons=new ArrayList<lessonObj>();
		Cursor cursor=myDatabase.query(TABLE_NAME, allColomns,FIELD_SUB_ID+"="+sub_id, null, null, null, null);
		// TODO Auto-generated method stub
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			  lessonObj newLesson=cursorToTopicObj(cursor);
			  lessons.add(newLesson);
			  cursor.moveToNext();
		 }
		 cursor.close();
		return lessons;
	}
	public static lessonObj cursorToTopicObj(Cursor cursor){
		int rowId=cursor.getColumnIndex(FIELD_ID);
		int rowSubId=cursor.getColumnIndex(FIELD_SUB_ID);
		int rowTitle=cursor.getColumnIndex(FIELD_TITLE);
		int rowData=cursor.getColumnIndex(FIELD_LESSON_INFO);
		int rowLink=cursor.getColumnIndex(FIELD_LINK);
		return new lessonObj(cursor.getInt(rowId),cursor.getInt(rowSubId),cursor.getString(rowTitle),cursor.getString(rowData),cursor.getString(rowLink));
		
	}

}
