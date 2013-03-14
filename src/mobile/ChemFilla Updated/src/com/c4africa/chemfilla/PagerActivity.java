package com.c4africa.chemfilla;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
//import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.TextView;

public class PagerActivity extends Activity {

// private int previousState, currentState;
 private ViewPager viewPager;

 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.pager);
  
 /* TextView pagetxt=(TextView)findViewById(R.id.p2txt);
  pagetxt.setMovementMethod(new ScrollingMovementMethod());
  */
  
	
  viewPager = (ViewPager) findViewById(R.id.ViewPagerMainActivity);
  viewPager.setAdapter(new CustomPageAdapter());
  viewPager.setOnPageChangeListener(onPageChangeListener);
  viewPager.setPageMargin(5);
 }

 OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

  @Override
  public void onPageSelected(int pageSelected) {
   Log.e("onPageSelected", "pageSelected:" + pageSelected);
  }

  @Override
  public void onPageScrolled(int pageSelected, float positionOffset,
    int positionOffsetPixel) {
	  
  }

  @Override
  public void onPageScrollStateChanged(int state) {
 
  }
  
 };

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
  getMenuInflater().inflate(R.menu.activity_starter, menu);
  return true;
 }

 private class CustomPageAdapter extends PagerAdapter {

  @Override
  public int getCount() {
   return 2;
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
   Log.d("test", "position:"+position);
   LayoutInflater layoutInflater = (LayoutInflater) container
     .getContext().getSystemService(
       Context.LAYOUT_INFLATER_SERVICE);
   View view = null;
   if (position <= container.getChildCount() - 1)
    view = container.getChildAt(position);
   if (view != null)
    return view;
   switch (position) {
   case 0:
    view = layoutInflater.inflate(R.layout.aboutcf, null);
    break;
   case 1:
    view = layoutInflater.inflate(R.layout.about_pg2, null);
    break;
   case 2:
    view = layoutInflater.inflate(R.layout.lessons, null);
    break;
   default:
	 finish();
    break;
   }
   ((ViewPager) container).addView(view, position);
   return view;
  }

  @Override
  public void destroyItem(View view, int position, Object object) {
    ((ViewPager) view).removeView((View) object);

  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
   return view == ((View) object);

  }

  @Override
  public Parcelable saveState() {
   return null;
  }
 }
}