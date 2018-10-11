package com.example.sms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.example.details.Details;
import com.example.jokes.JokeBaseAdapter;
import com.example.jokes.JokeSport;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Sms extends Activity {
	private Button btnPrevious, btnNext, btnRand;
	private Intent i;
	private int witch;
	private int x = 1;
	private String path;
	private String data;
	private ListView list;
	private int len;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms);
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
				x = 1;
				new Search(Sms.this, edtSearch.getText().toString()).execute();
			}
		});
		////
		i = getIntent();
		witch = i.getExtras().getInt("which");
		list = (ListView)findViewById(R.id.listView1);
		btnPrevious = (Button)findViewById(R.id.button1);
		btnPrevious.setOnClickListener(new View.OnClickListener() {
			                     
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				x--;
				newPageOfList();
				page();
			}
		});
		btnNext = (Button)findViewById(R.id.button2);
		btnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				x++;
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
		
		newPageOfList();
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
		switch (witch) {
		case 0:
		    path = "sms/Sms_Asheghane/Sms_Asheghane" + x + ".html";
			len = 1295;
		    break;
		case 1:
		    path = "sms/Sms_Ashti/Sms_Ashti" + x + ".html";
			len = 4;
		    break;
		case 2:
		    path = "sms/Sms_Emam_Zaman/Sms_Emam_Zaman" + x + ".html";
			len = 76;
		    break;
		case 3:
		    path = "sms/Sms_Falsafi/Sms_Falsafi" + x + ".html";
			len = 287;
		    break;
		case 4:
		    path = "sms/Sms_Friendly/Sms_Friendly" + x + ".html";
			len = 197;
		    break;
		case 5:
		    path = "sms/Sms_funny/Sms_funny" + x + ".html";
			len = 368;
		    break;
		case 6:
		    path = "sms/Sms_Khodavand/Sms_Khodavand" + x + ".html";
			len = 127;
		    break;
		case 7:
		    path = "sms/Sms_Mazhabi/Sms_Mazhabi" + x + ".html";
			len = 142;
		    break;
		case 8:
		    path = "sms/Sms_New/Sms_New" + x + ".html";
			len = 646;
		    break;
		case 9:
		    path = "sms/Sms_Shab_Bekheyr/Sms_Shab_Bekheyr" + x + ".html";
			len = 7;
		    break;
		case 10:
		    path = "sms/Sms_Shabe_Arezooha/Sms_Shabe_Arezooha" + x + ".html";
			len = 6;
		    break;
		case 11:
		    path = "sms/Sms_Sobh_Bekheyr/Sms_Sobh_Bekheyr" + x + ".html";
			len = 4;
		    break;
		case 12:
		    path = "sms/Sms_Tabrik_Rooze_Tavalod/Sms_Tabrik_Rooze_Tavalod" + x + ".html";
			len = 22;
		    break;
		case 13:
		    path = "sms/Sms_Tasliat/Sms_Tasliat" + x + ".html";
			len = 30;
		    break;
		case 14:
		    path = "sms/Sms_ziba/Sms_ziba" + x + ".html";
			len = 1062;
		    break;
			
		default:
			break;
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open(path), "UTF-8"));
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
		SmsBaseAdapter adapter = new SmsBaseAdapter(this, dataBody, dataPublisher);
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
				BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open(path), "UTF-8"));
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
			x++;
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(pro.isShowing())
				pro.dismiss();
			startActivity(new Intent(Sms.this, com.example.details.Search.class));
		}
	}
}
