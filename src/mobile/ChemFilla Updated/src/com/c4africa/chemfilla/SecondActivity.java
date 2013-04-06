package com.c4africa.chemfilla;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	final Context context = null;
	ImageButton btnLession,btnQuiz,btnAbout,btnHelp;
	protected View view;
	Button lbutton;
	
	@Override
	protected void onCreate(Bundle Tutors) {
		// TODO Auto-generated method stub
		super.onCreate(Tutors);
		
		setContentView(R.layout.secondview);
		
		setTitle("Lesson Selector");
		
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		TextView myTextView=(TextView)findViewById(R.id.syllabus);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/backlash.ttf");
		myTextView.setTypeface(typeFace);
		
		TextView subject = (TextView)findViewById(R.id.subject);
		Typeface subj = Typeface.createFromAsset(getAssets(), "fonts/kberry.ttf");
		subject.setTypeface(subj);
		
		btnLession = (ImageButton)findViewById(R.id.lesson);
		btnLession.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 	
				Intent choiceintent = new Intent();
				choiceintent.setClass(v.getContext(), AndroidTabLayoutActivity.class);
				startActivity(choiceintent);
			}
			
		});
		
		btnAbout = (ImageButton)findViewById(R.id.about);
		btnAbout.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 	
				Intent pageintent = new Intent();
				pageintent.setClass(v.getContext(), PagerActivity.class);
				startActivity(pageintent);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater cheminflate = getMenuInflater();
		cheminflate.inflate(R.menu.activity_starter,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		/*
		switch (item.getItemId()){
		case R.id.action:
			Toast.makeText(this,"seach here", Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_settings:
			Toast.makeText(this, "Second Action", Toast.LENGTH_LONG).show();
			break;
		case R.id.reset:
			Toast.makeText(this,"Reset List", Toast.LENGTH_LONG).show();
			break;
			
			default:
				break;
		}
		*/
		return true;
			
		}
	}
