package com.activity.se_conference;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Previous_conference extends Activity {
	ListView listView;
	String[] year={"2013","2012","2011","2010","2009","2008","2007","2006","2005"};
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.previous_conference);
		listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),  
                R.layout.listview_item, year));
        listView.setCacheColorHint(0);
        
        listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String clickName=(String) listView.getItemAtPosition(arg2);
				 if(clickName.equals("2013")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsp-conferences.org/icssp2013/index.html"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 if(clickName.equals("2012")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsp-conferences.org/icssp2012/index.html"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 if(clickName.equals("2011")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsp-conferences.org/icssp2011/index.html"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 if(clickName.equals("2010")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://icsp10.uni-paderborn.de/"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 if(clickName.equals("2009")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsp-conferences.org/icsp2009/index.html"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 if(clickName.equals("2008")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsp-conferences.org/icsp2008/index.html"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 if(clickName.equals("2007")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsp-conferences.org/icsp2007/index.html"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 if(clickName.equals("2006")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsp-conferences.org/spw2006/jsp/html/spw/index.jsp"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 if(clickName.equals("2005")){
					 Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsp-conferences.org/cnsqa/jsp/html/spw/index.jsp"));
					it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
					startActivity(it);
				 }
				 
            }
        });
	}
}