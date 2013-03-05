package com.c4africa.chemfilla;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*Public class for handling ChemFilla database operations
 * All interactions with the ChemFilla database will be done through this class
 */
public class ChemFillaDB{
	private static final String DB_NAME="ChemFillaDB";
	private static final int DB_VERSION=1;
	private final Context myContext;
	protected SQLiteDatabase myDatabase;
	protected DbHelper myHelper;
	
	// method to check if data has been already set up  
		public  boolean isConfigured(){
			return topic.hasRecord;
		}
		
	/* Private class that handles database creation and update
	 * Only the ChemFillaDB class has access to it
	 */
	private static class DbHelper extends SQLiteOpenHelper {
		public DbHelper(Context c){
			super(c,DB_NAME,null,DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			topic.onCreate(db);
			subTopic.onCreate(db);
			lesson.onCreate(db);
			question.onCreate(db);
			example.onCreate(db);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			topic.onUpgrade(db,oldVersion,newVersion);
			subTopic.onUpgrade(db,oldVersion,newVersion);
			lesson.onUpgrade(db,oldVersion,newVersion);
			question.onUpgrade(db,oldVersion,newVersion);
			example.onUpgrade(db,oldVersion,newVersion);
		}

	}//end of DbHelper private class
	
	//constructor for the ChemFilla database object
	public ChemFillaDB(Context c){
		myContext=c;
	}
	
	/*opens a connection to the ChemFilla database
	 * returns this object
	 * must be called first before any other method in this class is called 
	 */
	public ChemFillaDB open() throws Exception{
		myHelper=new DbHelper(myContext);
		myDatabase=myHelper.getWritableDatabase();
		return this;
	}
	
	/*closes the connection to the ChemFilla database
	 * must be called after performing ChemFilla database operations 
	 */
	public void close(){
		myHelper.close();
		myDatabase.close();
	}
	
	/* Below are method for inserting into various tables 
	 * in the chemFilla Database
	 * They return row id for the new insertion
	 */
	public long createTopic(int id, String name){
		return topic.createEntity(id,name,myDatabase);
	}
	public long createSub(int id, int topic_id,String name){
		return subTopic.createEntity(id,topic_id,name,myDatabase);
	}
	public long createLesson(int id,int sub_id,String title,String data,String link,String resources){
		return lesson.createEntity(id,sub_id,title,data,link,resources,myDatabase);
	}
	public long createQuestion(int id, int lesson_id,String descript,String optA, String optB,String optC,String optD, String answer){
		return question.createEntity( id,  lesson_id, descript, optA,  optB, optC, optD,  answer,myDatabase);
	}
	public long createExample(int id,int lesson_id,String exampleInfo,String resources){
		return example.createEntity(id,lesson_id,exampleInfo,resources,myDatabase);
	}
	
	/*Below are methods for retrieving data from various tables
	 *  in the chemFilla database
	 *  They return a list of objects representing the corresponding database records
	 */
	public List<topicObj> getTopics(){
		return topic.getTopics(myDatabase);
	}
	public List<subObj> getSubTopics(int topic_id){
		return subTopic.getSubTopics(topic_id,myDatabase);
	}
	public List<lessonObj> getLessons(int sub_id){
		return lesson.getLessons(sub_id,myDatabase);
	}
}// end of ChemFillaDB public class
