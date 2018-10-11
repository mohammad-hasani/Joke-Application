package com.example.details;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sina.funny.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Search extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);
		ListView list = (ListView)findViewById(R.id.listView1);
		String[] dataBody = new String[Details.searchData.size()];
		String[] dataPublisher = new String[Details.searchData.size()];
		Set set = Details.searchData.entrySet();
		Iterator i = set.iterator();
		int j = 0;
		while(i.hasNext())
		{
			Map.Entry me = (Map.Entry) i.next();
			dataBody[j] = (String) me.getKey();
			dataPublisher[j] = (String) me.getValue();
			j++;
		}
		FavoritesBaseAdapter adapter = new FavoritesBaseAdapter(this, dataBody, dataPublisher);
		list.setAdapter(adapter);
	}
}
