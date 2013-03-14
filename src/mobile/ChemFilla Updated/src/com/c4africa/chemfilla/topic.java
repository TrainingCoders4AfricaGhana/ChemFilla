package com.c4africa.chemfilla;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class topic {
	private static final String TABLE_NAME="topic";
	private static final String FIELD_ID="id"; 
	private static final String FIELD_NAME="name";
	private static final String FIELD_YEAR="year";
	static boolean hasRecord=false;
	public static void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
				FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				FIELD_NAME + " TEXT NOT NULL, " +
				FIELD_YEAR + " INTEGER)"
				);
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
		onCreate(db);
	}

	public static long createEntity(int id, String name, int year,SQLiteDatabase myDatabase) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(FIELD_ID, id);
		cv.put(FIELD_NAME, name);
		cv.put(FIELD_YEAR, year);
		return myDatabase.insert(TABLE_NAME, null, cv);
	}
	public static List<topicObj> getTopics(SQLiteDatabase myDatabase){
		String[]allColomns={FIELD_ID,FIELD_NAME,FIELD_YEAR};
		List<topicObj> topics=new ArrayList<topicObj>();
		Cursor cursor = myDatabase.query(TABLE_NAME,allColomns, null, null, null, null, null);
		hasRecord=cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			  topicObj newTopic=cursorToTopicObj(cursor);
			  topics.add(newTopic);
			  cursor.moveToNext();
		 }
		 cursor.close();
		 return topics;
	}
	public static List<topicObj> getTopics(int year,SQLiteDatabase myDatabase){
		String[]allColomns={FIELD_ID,FIELD_NAME,FIELD_YEAR};
		List<topicObj> topics=new ArrayList<topicObj>();
		Cursor cursor = myDatabase.query(TABLE_NAME,allColomns, FIELD_YEAR+"="+year, null, null, null,null);
		hasRecord=cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			  topicObj newTopic=cursorToTopicObj(cursor);
			  topics.add(newTopic);
			  cursor.moveToNext();
		 }
		 cursor.close();
		 return topics;
	}
	private static topicObj cursorToTopicObj(Cursor cursor){
		int rowId=cursor.getColumnIndex(FIELD_ID);
		int rowName=cursor.getColumnIndex(FIELD_NAME);
		int rowYear=cursor.getColumnIndex(FIELD_YEAR);
		return new topicObj(cursor.getInt(rowId),cursor.getString(rowName),cursor.getShort(rowYear));
	}
}