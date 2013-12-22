package com.activity.se_conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import myViews.MyPagerAdapter;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	
	private ViewPager mViewPager = null;
	private View news_view = null;
	private View papers_view = null;
	private View agenda_view = null;
	private View maps_view = null;
	private View info_view = null;
	private LinearLayout News_Layout = null;
	private LinearLayout Papers_Layout = null;
	private LinearLayout Agenda_Layout = null;
	private LinearLayout Maps_Layout = null;
	private LinearLayout Info_Layout = null;
	private LinearLayout Title_Layout = null;
	private ImageView News_underline = null;
	private ImageView Papers_underline = null;
	private ImageView Agenda_underline = null;
	private ImageView Maps_underline = null;
	private ImageView Info_underline = null;
	private TextView News_textview;
	private TextView Papers_textview;
	private TextView Agenda_textview;
	private TextView Maps_textview;
	private TextView Info_textview;
	private ListView Drawer_List;
	private DrawerLayout MyDrawerLayout = null;
	private Button Drawer_Btn = null;
	public static Resources resources;	
	private int currentPage = 0;
	private boolean drawer_open = false;
	private boolean titlecolor = false;
	@SuppressLint("UseSparseArrays")
	Map<Integer,View> map = new HashMap<Integer,View>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mViewPager = (ViewPager)this.findViewById(R.id.viewpager);		
		
		News_textview= (TextView)findViewById(R.id.News_textview);
		Papers_textview= (TextView)findViewById(R.id.Papers_textview);
		Agenda_textview= (TextView)findViewById(R.id.Agenda_textview);		
		Maps_textview= (TextView)findViewById(R.id.Maps_textview);
		Info_textview= (TextView)findViewById(R.id.Info_textview);
		
		News_Layout = (LinearLayout)findViewById(R.id.News_Layout);
		Papers_Layout = (LinearLayout)findViewById(R.id.Papers_Layout);
		Agenda_Layout = (LinearLayout)findViewById(R.id.Agenda_Layout);
		Maps_Layout = (LinearLayout)findViewById(R.id.Maps_Layout);
		Info_Layout = (LinearLayout)findViewById(R.id.Info_Layout);
		Title_Layout = (LinearLayout)findViewById(R.id.Title_Layout);
		
		News_underline = (ImageView)findViewById(R.id.News_Underline);
		Papers_underline = (ImageView)findViewById(R.id.Papers_Underline);
		Agenda_underline = (ImageView)findViewById(R.id.Agenda_Underline);
		Maps_underline = (ImageView)findViewById(R.id.Maps_Underline);
		Info_underline = (ImageView)findViewById(R.id.Info_Underline);
		
		Drawer_List = (ListView)findViewById(R.id.drawer);
		Drawer_Btn = (Button)findViewById(R.id.Drawer_Btn);
		MyDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		
		Drawer_List.setAdapter(new ArrayAdapter<String>(this, R.layout.list_layout, new String[]{
				"News","Papers","Agenda","Maps","Info"}));
		Drawer_List.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(position);
				MyDrawerLayout.closeDrawer(Gravity.LEFT);
				
			}
		});
		
		
		resources = getResources();
		News_underline.setBackgroundColor(resources.getColor(R.color.Blue_Color));
		map.put(0, News_underline);
		map.put(1,Papers_underline);
		map.put(2,Agenda_underline);
		map.put(3,Maps_underline);
		map.put(4,Info_underline);
		
		LayoutInflater mLi = LayoutInflater.from(this);     
        news_view = mLi.inflate(R.layout.news, null);
        papers_view = mLi.inflate(R.layout.papers, null);
        agenda_view = mLi.inflate(R.layout.agenda, null);
        maps_view = mLi.inflate(R.layout.maps, null);        
        info_view = mLi.inflate(R.layout.info, null);
        
        InitViewpager();

		News_Layout.setOnClickListener(new MyViewPageListener(0));
		Papers_Layout.setOnClickListener(new MyViewPageListener(1));
		Agenda_Layout.setOnClickListener(new MyViewPageListener(2));
		Maps_Layout.setOnClickListener(new MyViewPageListener(3));
		Info_Layout.setOnClickListener(new MyViewPageListener(4));
			
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				switch (arg0){
					case 0:
						News_underline.setBackgroundColor(resources.getColor(R.color.Blue_Color));						
						break;
					case 1:
						Papers_underline.setBackgroundColor(resources.getColor(R.color.Blue_Color));
						break;
					case 2:
						Agenda_underline.setBackgroundColor(resources.getColor(R.color.Blue_Color));
						break;
					case 3:
						Maps_underline.setBackgroundColor(resources.getColor(R.color.Blue_Color));
						break;
					case 4:
						Info_underline.setBackgroundColor(resources.getColor(R.color.Blue_Color));
						break;
				}
				map.get(currentPage).setBackgroundColor(resources.getColor(R.color.Light_Grey));			
				currentPage = arg0;
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Drawer_Btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!drawer_open){
					MyDrawerLayout.openDrawer(Gravity.LEFT);
					drawer_open = true;
				}
				else if(drawer_open){
					MyDrawerLayout.closeDrawer(Gravity.LEFT);
					drawer_open = false;
				}
				
				if(!titlecolor){
					Title_Layout.setBackgroundColor(getResources().getColor(R.color.Blue_Color));
					titlecolor = true;
				}
				else if(titlecolor){
					Title_Layout.setBackgroundColor(getResources().getColor(R.color.Dark_Grey));
					titlecolor = false;
				}
				
				
			}
		});
				
	} 

	class MyViewPageListener implements OnClickListener{
		
		int index = 0;
		public MyViewPageListener(int i){
			index = i;
		}
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mViewPager.setCurrentItem(index);
	
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void InitViewpager(){

        final ArrayList<View> views = new ArrayList<View>();
        views.add(news_view);
        views.add(papers_view);
        views.add(agenda_view);
        views.add(maps_view);
        views.add(info_view);
        PagerAdapter mPagerAdapter = new MyPagerAdapter(views);
		mViewPager.setAdapter(mPagerAdapter);
	}
	

}


