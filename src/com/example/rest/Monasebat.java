package com.example.rest;

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

public class Monasebat extends Activity {
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
		setContentView(R.layout.monasebat);
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
				new Search(Monasebat.this, edtSearch.getText().toString()).execute();
			}
		});
		////
		i = getIntent();
		witch = i.getExtras().getInt("w");
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
		    path = "Monasebat/Monasebat_13Bedar/Monasebat_13Bedar" + x + ".html";
			len = 3;
		    break;
		case 1:
		    path = "Monasebat/Monasebat_Christmas/Christmas" + x + ".html";
			len = 2;
		    break;
		case 2:
		    path = "Monasebat/Monasebat_Eyde_Ghadir/Monasebat_Eyde_Ghadir" + x + ".html";
			len = 9;
		    break;
		case 3:
		    path = "Monasebat/Monasebat_Eyde_Ghorban/Monasebat_Eyde_Ghorban" + x + ".html";
			len = 4;
		    break;
		case 4:
		    path = "Monasebat/Monasebat_Mahe_Moharam/Monasebat_Mahe_Moharam" + x + ".html";
			len = 94;
		    break;
		case 5:
		    path = "Monasebat/Monasebat_Mahe_Ramazan/Monasebat_Mahe_Ramazan" + x + ".html";
			len = 18;
		    break;
		case 6:
		    path = "Monasebat/Monasebat_Milad_Emam_Zaman/Monasebat_Milad_Emam_Zaman" + x + ".html";
			len = 9;
		    break;
		case 7:
		    path = "Monasebat/Monasebat_Milade_Piambar_Emam_Sadegh/Monasebat_Milade_Piambar_Emam_Sadegh" + x + ".html";
			len = 3;
		    break;
		case 8:
		    path = "Monasebat/Monasebat_Noruz/Monasebat_Noruz" + x + ".html";
			len = 33;
		    break;
		case 9:
		    path = "Monasebat/Monasebat_Rehlate_Piapbar_Shahadate_Emam_hasan/Monasebat_Rehlate_Piapbar_Shahadate_Emam_hasan" + x + ".html";
			len = 2;
		    break;
		case 10:
		    path = "Monasebat/Monasebat_Rooze_Arafe/Monasebat_Rooze_Arafe" + x + ".html";
			len = 3;
		    break;
		case 11:
		    path = "Monasebat/Monasebat_Rooze_Madar/Monasebat_Rooze_Madar" + x + ".html";
			len = 21;
		    break;
		case 12:
		    path = "Monasebat/Monasebat_Rooze_Pedar/Monasebat_Rooze_Pedar" + x + ".html";
			len = 21;
		    break;
		case 13:
		    path = "Monasebat/Monasebat_Shabe_Ghadr/Monasebat_Shabe_Ghadr" + x + ".html";
			len = 13;
		    break;
		case 14:
		    path = "Monasebat/Monasebat_Shabe_Yalda/Monasebat_Shabe_Yalda" + x + ".html";
			len = 14;
		    break;
		case 15:
		    path = "Monasebat/Monasebat_Shahadat_Hazrate_Fateme/Monasebat_Shahadat_Hazrate_Fateme" + x + ".html";
			len = 17;
		    break;
		case 16:
		    path = "Monasebat/Monasebat_Veladate_Emam_Reza/Monasebat_Veladate_Emam_Reza" + x + ".html";
			len = 8;
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
		MonasebatBaseAdapter adapter = new MonasebatBaseAdapter(this, dataBody, dataPublisher);
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
			startActivity(new Intent(Monasebat.this, com.example.details.Search.class));
		}
	}
}
