package com.c4africa.chemfilla;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class example {
	private static final String TABLE_NAME="example";
	private static final String FIELD_ID="id";
	private static final String FIELD_LESSON_ID="lesson_id";
	private static final String FIELD_EXAMPLE_TEXT="text_example";
	private static final String FIELD_RESOURCES="resources";
	
	public static void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+TABLE_NAME + " (" +
				FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				FIELD_LESSON_ID + " INTEGER, " +
				FIELD_EXAMPLE_TEXT + "TEXT NOT NULL, " + 
				FIELD_RESOURCES + " TEXT)"
				);
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	public static long createEntity(int id, int lesson_id, String exampleInfo,
		// TODO Auto-generated method stub
		String resources, SQLiteDatabase myDatabase) {
		ContentValues cv=new ContentValues();
		cv.put(FIELD_ID, id);
		cv.put(FIELD_LESSON_ID,lesson_id);
		cv.put(FIELD_EXAMPLE_TEXT, exampleInfo);
		cv.put(FIELD_RESOURCES, resources);
		return myDatabase.insert(TABLE_NAME, null, cv);
	}

}
