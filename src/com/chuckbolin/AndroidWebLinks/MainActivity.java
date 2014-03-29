package com.chuckbolin.AndroidWebLinks;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	ListView listView;
	private static String TAG = "Practice2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.list);
		
		String[] values = new String[]{
				"http://www.google.com",
				"https://www.coursera.org/",
				"http://startandroid.ru/en/lessons/complete-list.html",
				"http://www.tutorialspoint.com/java/",
				"http://www.vogella.com/tutorials/android.html",
				"http://www.ntu.edu.sg/home/ehchua/programming/android/Android_BasicsUI.html",
				"http://chrisrisner.com/31-Days-of-Android",
				"http://www.tutorialspoint.com/android/",
				"http://petrnohejl.github.io/Android-Cheatsheet-For-Graphic-Designers/",

		};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,values);
		
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//int  itemPosition = position;
				
				String itemValue = (String) listView.getItemAtPosition(position);
				startWebPage(itemValue);
				Log.d(TAG,itemValue);	
			
			}			
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void startWebPage(String page){
		Uri webpage = Uri.parse(page);
		Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);
		Intent chooserIntent = webIntent.createChooser(webIntent,  "MyBrowser");
		startActivity(chooserIntent);		
		

	}


}
