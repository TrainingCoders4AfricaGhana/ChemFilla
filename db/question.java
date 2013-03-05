package com.c4africa.chemfilla;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class question {
	private static final String TABLE_NAME="question";
	private static final String FIELD_ID="id";
	private static final String FIELD_LESSON_ID="lesson_id";
	private static final String FIELD_DESCRIPTION="qns_descrip";
	private static final String FIELD_OPTION_A="option_a";
	private static final String FIELD_OPTION_B="option_b";
	private static final String FIELD_OPTION_C="option_c";
	private static final String FIELD_OPTION_D="option_d";
	private static final String FIELD__ANSWER="answer";
	public static void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
				FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				FIELD_LESSON_ID + "INTEGER, " +
				FIELD_DESCRIPTION + " TEXT NOT NULL, " +
				FIELD_OPTION_A + " TEXT NOT NULL, " +
				FIELD_OPTION_B + " TEXT NOT NULL, " +
				FIELD_OPTION_C + " TEXT NOT NULL, " +
				FIELD_OPTION_D + " TEXT NOT NULL, " +
				FIELD__ANSWER + " TEXT NOT NULL)"
				);
		
	}
	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
		onCreate(db);
	}
	public static long createEntity(int id, int lesson_id, String descript,
			String optA, String optB, String optC, String optD, String answer,SQLiteDatabase myDatabase) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(FIELD_ID, id);
		cv.put(FIELD_LESSON_ID, lesson_id);
		cv.put(FIELD_DESCRIPTION, descript);
		cv.put(FIELD_OPTION_A, optA);
		cv.put(FIELD_OPTION_B, optB);
		cv.put(FIELD_OPTION_C, optC);
		cv.put(FIELD_OPTION_D, optD);
		cv.put(FIELD_OPTION_A, answer);
		return myDatabase.insert(TABLE_NAME, null, cv);
	}

}
