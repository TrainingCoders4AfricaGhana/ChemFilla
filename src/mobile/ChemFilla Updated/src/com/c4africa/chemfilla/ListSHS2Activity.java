package com.c4africa.chemfilla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListSHS2Activity extends Activity implements OnItemClickListener,OnKeyListener{
	private ListView lv;
	private ChemFillaDB database;
	ArrayAdapter<topicObj> adapter;
	private List<topicObj> topics;
	EditText inputSearch;
	
	
	// ArrayList for L
	ArrayList<HashMap<String, String>> productList;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.lessons);
	        database=new ChemFillaDB(this);
	        try {
				database.open();
				topics=database.getTopics(2);
				if(!database.isConfigured()){
					ChemFillaConfig config=new ChemFillaConfig(this);
					config.execute("config");
					topics=database.getTopics(2);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				database.close();
			}
	        
	        lv = (ListView) findViewById(R.id.list_view);
	        inputSearch = (EditText) findViewById(R.id.inputSearch);
	        
	        // Adding items to listview
	        adapter = new ArrayAdapter<topicObj>(this, R.layout.list_item, R.id.product_name, topics);
	        lv.setAdapter(adapter);
	        lv.setOnItemClickListener(this);
	        inputSearch.setOnKeyListener(this);
	        /**
	         * Enabling Search Filter
	         * */
	        inputSearch.addTextChangedListener(new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
					// When user changed the Text
					ListSHS2Activity.this.adapter.getFilter().filter(cs);
				}
				
				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
						int arg3) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void afterTextChanged(Editable arg0) {
					// TODO Auto-generated method stub							
				}
			});

}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
		topicObj selectedTopic =(topicObj)lv.getItemAtPosition(position);
		Intent subtopics =new Intent(this,SubActivity.class);
		subtopics.putExtra("topicId", selectedTopic.id);
		subtopics.putExtra("topicName", selectedTopic.name);
		startActivity(subtopics);
	}

	@Override
	public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
		String error=null;
		if(arg1==KeyEvent.KEYCODE_ENTER){
			
			//write code to retrieve search input and search the ChemFilla database
			String searchText=inputSearch.getText().toString();
			SearchHelper search_helper=new SearchHelper(this);
			
			try {
				search_helper.open();
				search_helper.search(searchText);
				search_helper.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error=e.getMessage();
			}
			finally{
				TextView tv =new TextView(this);
				Dialog d=new Dialog(this);
				d.setTitle("Search feedback");
				tv.setTextColor(Color.GREEN);
				if(error!=null){
					tv.setText("Done");
					d.setContentView(tv);
					d.show();
				}
				else{
					tv.setText(error);
					d.setContentView(tv);
					d.show();
				}
				
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

}
