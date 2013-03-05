package com.c4africa.chemfilla;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.TextView;
/* Class for setting up the ChemFilla database
 * Inserts all the data needed for the application to function properly into various tables
 * via the ChemFillaDB object 
 */
public class ChemFillaConfig extends AsyncTask<String,Integer,String>{
	private ChemFillaDB myDB;
	private ProgressDialog dialog;
	private Context c;
	String error;
	boolean itWorked;
	// constructor
	public ChemFillaConfig(Context c){
		this.c=c;
		myDB=new ChemFillaDB(c);
		dialog=new ProgressDialog(c);
		itWorked=true;
		error=null;
	}
	/*method to be executed before insertion of the data
	 * (non-Javadoc)
	 * @see android.os.AsyncTask#onPreExecute()
	 */
	protected void onPreExecute(){
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setMax(100);
		dialog.show();
	}
	// method that does the set up bit by bit
	private void config(int i) throws Exception{
		switch(i){
		case 1:
			addTopics();
			publishProgress(4);
			break;
		case 2:
			addSubs();
			publishProgress(16);
			break;
		case 3:
			addLessons();
			publishProgress(45);
			break;
		case 4:
			addExamples();
			publishProgress(10);
			break;
		case 5:
			addQuestions();
			publishProgress(25);
			break;
		}
	}
	@Override
	/* method that will be executed to do all the set up
	 * (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		try {
			myDB.open();
			if(itWorked)
				for(int i=1;i<=5;i++){
					config(i);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			error=e.getMessage();
			itWorked=false;
			e.printStackTrace();
		}
		finally{
			myDB.close();
		}
		return null;
	}
	/*method that updates the status or progress of the entire setting up process
	 * (non-Javadoc)
	 * @see android.os.AsyncTask#onProgressUpdate(Progress[])
	 */
	protected void onProgressUpdate(Integer...progress){
		dialog.incrementProgressBy(progress[0]);
	}
	/*method to be executed after the setting up of data is complete
	 * (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	protected void onPostExecute(String result){
		TextView tv=new TextView(c);
		Dialog d=new Dialog(c);
		d.setTitle("Information");
		tv.setTextSize(15);
		tv.setTextColor(Color.GREEN);
		tv.setText("ChemFilla App Configured sucessfully.Please go back to the menu and enjoy using your app");
		d.setContentView(tv);
		d.show();
		
	}
	// method for adding all topics
	private void addTopics(){
		myDB.createTopic(1, "Introduction to Chemistry");
		myDB.createTopic(2, "Atomic Structure");
		myDB.createTopic(3, "Chemical Bonding");
		myDB.createTopic(4, "Conservation of Matter and Stoichiometry");
		myDB.createTopic(5, "States of Matter");
		myDB.createTopic(6, "Energy and Energy Changes");
		myDB.createTopic(7, "Inorganic Chemistry");
		myDB.createTopic(8, "Chemical Kinetics and Equilibrium");
		myDB.createTopic(9, "Acids and Bases");
		myDB.createTopic(10, "Redox Reactions and Electrochemistry");
		myDB.createTopic(11, "Chemistry of Carbon Compounds");
		myDB.createTopic(12, "Chemistry, Industry and Environment");
		myDB.createTopic(13, "Basic Biochemistry");
	}
	// method for adding all sub topics
	private void addSubs(){
		//subs for Introduction to Chemistry
		myDB.createSub(1, 1, "Chemistry as a discipline");
		myDB.createSub(2, 1, "Measurement of Physical Quantities");
		myDB.createSub(3, 1, "Basic Safety Laboratory Practices");
		
		//subs for Atomic Structure
		myDB.createSub(4, 2, "Particulate Nature of Matter");
		myDB.createSub(5, 2, "Structure of Atom");
		myDB.createSub(6, 2, "Periodicity");
		
		//subs for Chemical Bonding
		myDB.createSub(7, 3, "Interactive Bonding");
		myDB.createSub(8, 3, "Intermolecular Bonding");
		myDB.createSub(9, 3, "Hybridization and Shapes of Molecules");
		
		//subs for Conservation of Matter and Stoichiometry
		myDB.createSub(10, 4, "Carbon-12 Scale");
		myDB.createSub(11, 4, "Solutions");
		myDB.createSub(12, 4, "Stoichiometry and Chemical Equations");
		myDB.createSub(13, 4, "Nuclear Chemistry");
		
		//subs for States of Matter
		myDB.createSub(14, 5, "Solids and Liqiuds");
		myDB.createSub(15, 5, "Gases and their properties");
		
		//subs for Energy and Energy Changes
		myDB.createSub(16, 6, "Energy Changes in Physical and Chemical Process");
		myDB.createSub(17, 6, "Energy Cycles and Bond Enthalpies");
		
		//subs for Inorganic Chemistry
		myDB.createSub(18, 7, "Periodic Chemistry");
		myDB.createSub(19, 7, "Transition Chemistry");
		
		//subs for Chemical Kinetics and Equilibrium
		myDB.createSub(20, 8, "Rates of Reactions");
		myDB.createSub(21, 8, "Chemical Equilibruim");
		
		//subs for Acids and Bases
		myDB.createSub(22, 9, "The Concept Acids and Bases");
		myDB.createSub(23, 9, "Properties of Acids, Bases and acid-base indicators");
		myDB.createSub(24, 9, "Classification of acids and base");
		myDB.createSub(25, 9, "Concept of pH and pOH");
		myDB.createSub(26, 9, "Buffer solutions");
		myDB.createSub(27, 9, "Solubility of Substances");
		myDB.createSub(28, 9, "Salt and Chemicals from Salt");
		
		//subs for Redox Reactions and Electrochemistry
		myDB.createSub(29, 10, "Oxidation-reduction processes and oxidizing-reducing agents");
		myDB.createSub(30, 10, "Balancing redox reaction equations");
		myDB.createSub(31, 10, "Redox Titration");
		myDB.createSub(32, 10, "Electrochemical Cells");
		myDB.createSub(33, 10, "Electrolytic Cells");
		myDB.createSub(34, 10, "Corrosion of Metals");
		
		//subs for Chemistry of Carbon Compounds
		myDB.createSub(35, 11, "Bonding in Carbon");
		myDB.createSub(36, 11, "Classification of Organic Compounds");
		myDB.createSub(37, 11, "Identification of elements in Organic Compounds");
		myDB.createSub(38, 11, "Separation and purification of Organic Compounds");
		myDB.createSub(39, 11, "Alkanes");
		myDB.createSub(40, 11, "Alkenes");
		myDB.createSub(41, 11, "Alkynes");
		myDB.createSub(42, 11, "Benzene");
		myDB.createSub(43, 11, "Alkanols");
		myDB.createSub(44, 11, "Alkanoic Acids");
		myDB.createSub(45, 11, "Alkanoic Acids derivatives: Alkylalkanoate(esters)");

		//subs for Chemistry, Industry and Environment
		myDB.createSub(46, 12, "Chemistry and Industry");
		myDB.createSub(47, 12, "Extraction of Metals");
		myDB.createSub(48, 12, "Extraction of Crude Oil and Petroleum Processing");
		myDB.createSub(49, 12, "Environmental P0llution");
		myDB.createSub(50, 12, "Biotechnology");
		myDB.createSub(51, 12, "Cement and its uses");
		
		//subs for Basic Biochemistry
		myDB.createSub(52, 13, "Fats and oils");
		myDB.createSub(53, 13, "Protein");
		myDB.createSub(54, 13, "Carbohadrates");
		myDB.createSub(55, 13, "Synthetic polymers");
		
	}
	
	// method for adding all lessons
	private void addLessons(){
		lessonInfo.init(myDB);
	}
	// method for adding all questions
	private void addQuestions(){
		
	}
	// method for adding all examples
	private void addExamples(){
		
	}
	
}// end of ChemFillaConfig class
