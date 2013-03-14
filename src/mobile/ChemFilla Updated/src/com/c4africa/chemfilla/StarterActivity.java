package com.c4africa.chemfilla;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
public class StarterActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starter);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(3000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally {
					Intent splash = new Intent("com.c4africa.chemfilla.SECONDACTIVITY");
					startActivity(splash);						
				}
			}
		};
		timer.start();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_starter, menu);
		return true;
	}

}
