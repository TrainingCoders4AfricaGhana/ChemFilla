package com.c4africa.chemfilla;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings({ "deprecation" })
public class AndroidTabLayoutActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("SHS Topics");
        
        TabHost tabHost = getTabHost();
        
        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("SHS1");
        photospec.setIndicator("SHS1", getResources().getDrawable(R.drawable.shs1));
        Intent photosIntent = new Intent(this, ListSHS1Activity.class);
        photospec.setContent(photosIntent);
        
        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("SHS2");
        // setting Title and Icon for the Tab
        songspec.setIndicator("SHS2", getResources().getDrawable(R.drawable.shs1));
        Intent songsIntent = new Intent(this, ListSHS2Activity.class);
        songspec.setContent(songsIntent);
        
        // Tab for Videos
        TabSpec videospec = tabHost.newTabSpec("SHS3");
        videospec.setIndicator("SHS3", getResources().getDrawable(R.drawable.shs1));
        Intent videosIntent = new Intent(this, ListSHS3Activity.class);
        videospec.setContent(videosIntent);
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        tabHost.addTab(videospec); // Adding videos tab
    }
}