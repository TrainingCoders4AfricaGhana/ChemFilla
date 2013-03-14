package com.c4africa.chemfilla;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SubActivity extends Activity {
	List<subObj> subs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		Intent i=getIntent();
		Bundle b=i.getExtras();
		int topic_id=b.getInt("topicId");
		String topic_name=b.getString("topicName");
		setTitle(topic_name);
		ChemFillaDB database= new ChemFillaDB(this);
		try {
			database.open();
			subs=database.getSubTopics(topic_id);
			database.close();
			ListView lv=(ListView)findViewById(R.id.subList);
			ArrayAdapter<subObj> adapter=new ArrayAdapter<subObj>(this,R.layout.list_item,R.id.product_name,subs);
			lv.setAdapter(adapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sub, menu);
		return true;
	}

}
