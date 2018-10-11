package com.example.jokes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;


import com.example.details.Details;
import com.example.jokes.JokeAnimals.Search;
import com.sina.funny.R;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class JokeJomlesazi extends Activity {
	private Button btnPrevious, btnNext, btnRand;
	private ListView list;
	private static int x = 1;
	private int len = 10;
	private String data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joke);
		////
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayUseLogoEnabled(false);
		LayoutInflater inf = getLayoutInflater();
		View view = inf.inflate(R.layout.search_actionbar, null);
		actionBar.setCustomView(view);
		Button btnSearch = (Button)view.findViewById(R.id.button1);
		final EditText edtSearch = (EditText)view.findViewById(R.id.editText1);
		btnSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Details.searchData.clear();
				new Search(JokeJomlesazi.this, edtSearch.getText().toString()).execute();
			}
		});
		////
		btnPrevious = (Button)findViewById(R.id.button1);
		btnNext = (Button)findViewById(R.id.button2);
		list = (ListView)findViewById(R.id.listView1);
		newPageOfList();
		btnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				x++;
				newPageOfList();
				page();
			}
		});
		btnPrevious.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				x--;
				newPageOfList();
				page();
			}
		});
		btnRand = (Button)findViewById(R.id.button3);
		btnRand.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Random r = new Random();
				x = r.nextInt(len - 1)+ 1;
				newPageOfList();
				page();
			}
		});
		page();
		
	}
	private void page()
	{
		
		if(x <= 1)
			btnPrevious.setEnabled(false);
		else if(x >= len)
			btnNext.setEnabled(false);
		else
		{
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
		}Toast.makeText(getApplicationContext(), x + "", 2000).show();
	}
	private void newPageOfList()
	{
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("joke/joke_jomlesazi/joke_jomlesazi" + x + ".html"), "UTF-8"));
			data = reader.readLine();
			String read;
			while((read = reader.readLine()) != null)
			{
				data += read;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Log.d("sssss", e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] data2 = data.split("</a>");
		String[] dataBody = new String[data2.length];
		String[] dataPublisher = new String[data2.length];
		for(int i = 0; i < data2.length ; i++)
		{
			String[] q = data2[i].split("فرستنده");
			dataBody[i] = q[0];
			try{
			dataPublisher[i] = q[1].replace(":", "");
			}catch(Exception er){}
		}
		JokeBaseAdapter adapter = new JokeBaseAdapter(this, dataBody, dataPublisher);
		list.setAdapter(adapter);
	}
	class Search extends AsyncTask<String, Integer, String>
	{
		private ProgressDialog pro;
		private Context c;
		private String data;
		private String searchInfo;
		public Search(Context c, String info)
		{
			this.c = c;
			this.searchInfo = info;
		}
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pro = new ProgressDialog(c);
			pro.setMessage("صبر کنید...");
			pro.show();
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			for(int k = 0; k <= len; k++)
			{
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("joke/joke_jomlesazi/joke_jomlesazi" + k + ".html"), "UTF-8"));
				data = reader.readLine();
				String read;
				while((read = reader.readLine()) != null)
				{
					data += read;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				Log.d("sssss", e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
			String[] data2 = data.split("</a>");
			for(int i = 0; i < data2.length ; i++)
			{
				String[] q = data2[i].split("فرستنده");
				try{
					if(q[0].contains(searchInfo))
						Details.searchData.put(q[0], new String(q[1].replace(":", "")));
				}catch(Exception er){}
			}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			if(Details.searchData.size() >= 50)
				break;
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(pro.isShowing())
				pro.dismiss();
			startActivity(new Intent(JokeJomlesazi.this, com.example.details.Search.class));
		}
	}
}
