package com.c4africa.chemfilla;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChoiceList extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_2, Topics));
        getListView().setTextFilterEnabled(true);
        
    }
    
    static final String[] Topics = new String[]{
    	"Basic Tools And Principles",
    	"Atomic and Molecular Structure (Including Moles)",
    	"States of Matter",
    	"Types and Control of Chemical Reactions",
    	"Chemistry of Elements, Compounds and Materials",
    	"Chemfilla"
    };
    
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	Object o = this.getListAdapter().getItem(position);
    	String pen = o.toString();
    	Toast.makeText(this, "You have chosen the pen: " + " " + pen, Toast.LENGTH_LONG).show();
    }
}