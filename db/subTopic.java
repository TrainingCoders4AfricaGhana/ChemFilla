package com.c4africa.chemfilla;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class subTopic {
	private static final String TABLE_NAME="subTopic"; 
	private static final String FIELD_ID="id";
	private static final String FIELD_TOPIC_ID ="topic_id";
	private static final String FIELD_NAME="name";
	public static void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
				FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				FIELD_TOPIC_ID + " INTEGER, " +
				FIELD_NAME + " TEXT NOT NULL)"
				);
	}
	public static String getTableName(){
		return TABLE_NAME;
	}
	public static String getFieldId(){
		return FIELD_ID;
	}
	public static String getFieldName(){
		return FIELD_NAME;
	}
	public static String getFieldTopicId(){
		return FIELD_TOPIC_ID;
	}
	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
		onCreate(db);
		
	}

	public static long createEntity(int id, int topic_id, String name,
			SQLiteDatabase myDatabase) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(FIELD_ID, id);
		cv.put(FIELD_TOPIC_ID, topic_id);
		cv.put(FIELD_NAME, name);
		return myDatabase.insert(TABLE_NAME, null, cv);
	}

	public static List<subObj> getSubTopics(int topic_id,SQLiteDatabase myDatabase) {
		// TODO Auto-generated method stub
		String[]allColomns={FIELD_ID,FIELD_TOPIC_ID,FIELD_NAME};
		List<subObj> subs=new ArrayList<subObj>();
		Cursor cursor = myDatabase.query(TABLE_NAME,allColomns, FIELD_TOPIC_ID+"=" +topic_id, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			subObj newSub=cursorToTopicObj(cursor);
			subs.add(newSub);
			cursor.moveToNext();
		 }
		 cursor.close();
		 return subs;
	}
	public static subObj cursorToTopicObj(Cursor cursor){
		int rowId=cursor.getColumnIndex(FIELD_ID);
		int rowTopicName=cursor.getColumnIndex(FIELD_TOPIC_ID);
		int rowName=cursor.getColumnIndex(FIELD_NAME);
		return new subObj(cursor.getInt(rowId),cursor.getInt(rowTopicName),cursor.getString(rowName));
	}
}