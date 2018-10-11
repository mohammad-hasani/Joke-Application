package com.example.details;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;


import com.sina.funny.R;

import android.app.ActionBar;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Favorites extends Activity {
	private Button btnPrevious, btnNext, btnRand;
	private ListView list;
	private static int x = 1;
	private int len = 27;
	private String data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favorites);
		Button btnClear = (Button)findViewById(R.id.buttonclear);
		btnClear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = openOrCreateDatabase("/sdcard/funnyJokesSina/Database/funnyDB.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
				db.execSQL("delete from favorites");
				db.close();
			}
		});
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		list = (ListView)findViewById(R.id.listView1);
		data();
	}
	private void data()
	{
		SQLiteDatabase db = openOrCreateDatabase("/sdcard/funnyJokesSina/Database/funnyDB.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		Cursor cursor = db.rawQuery("select distinct * from favorites", null);
		cursor.moveToFirst();
		String[] dataBody = new String[cursor.getCount()];
		String[] dataPublisher = new String[cursor.getCount()];
		int i = 0;
		do {
			try{
				dataBody[i] = cursor.getString(0);
				dataPublisher[i] = cursor.getString(1);
				i++;
			}catch(Exception e){Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();}
		}while(cursor.moveToNext());
		db.close();
		FavoritesBaseAdapter adapter = new FavoritesBaseAdapter(this, dataBody, dataPublisher);
		list.setAdapter(adapter);
	}
}
