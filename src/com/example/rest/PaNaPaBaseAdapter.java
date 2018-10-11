package com.example.rest;

import com.sina.funny.R;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class PaNaPaBaseAdapter extends BaseAdapter {
	private Context c;
	private LayoutInflater inf;
	private String[] dataBody, dataPublisher;
	public PaNaPaBaseAdapter(Context c, String[] dataBody, String[] dataPublisher)
	{
		this.c = c;
		inf = LayoutInflater.from(c);
		this.dataBody = dataBody;
		this.dataPublisher = dataPublisher;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataBody.length - 1;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null)
			convertView = inf.inflate(R.layout.pa_na_pa_list_items, parent, false);
		final TextView body = (TextView)convertView.findViewById(R.id.textView3);
		final TextView publisher = (TextView)convertView.findViewById(R.id.textView1);
		Button btnShare = (Button)convertView.findViewById(R.id.btnshare);
		Button btnCopy = (Button)convertView.findViewById(R.id.btncopy);
		CheckBox chk1 = (CheckBox)convertView.findViewById(R.id.checkbox_fav);
		try{
			body.setText(dataBody[position].trim());
			publisher.setText(dataPublisher[position].trim());
		}catch(Exception er){}
		btnCopy.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ClipboardManager clipBoard = (ClipboardManager)c.getSystemService(Context.CLIPBOARD_SERVICE);
				ClipData clip = ClipData.newPlainText("text", body.getText().toString());
				clipBoard.setPrimaryClip(clip);
			}
		});
		btnShare.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("text/plain");
				i.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
				c.startActivity(Intent.createChooser(i, "Choose one"));
			}
		});
		chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
					addToDB(body.getText().toString().trim() , publisher.getText().toString().trim());
				else
					removeFromDB(body.getText().toString().trim(), publisher.getText().toString().trim());
			}
		});
		chk1.setChecked(selectFromDB(body.getText().toString().trim()));
		return convertView;
	}
	void addToDB(String body, String publisher)
	{
		SQLiteDatabase db = c.openOrCreateDatabase("/sdcard/funnyJokesSina/Database/funnyDB.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		ContentValues cn = new ContentValues();
		//cn.put("body", body);
		//cn.put("publisher", publisher);
		//db.insert("favorites", null, cn);
		db.execSQL("insert into favorites values ('"+body+"','"+publisher+"')");
		db.close();
	}
	void removeFromDB(String body, String publisher)
	{
		SQLiteDatabase db = c.openOrCreateDatabase("/sdcard/funnyJokesSina/Database/funnyDB.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		//String whereSql = "body like ?";
        //String[] whereValues = new String[]{"%"+body+"%"};
        //db.delete("favorites", whereSql, whereValues);
        db.execSQL("delete from favorites where body='"+body+"'");
		db.close();
	}
	boolean selectFromDB(String body)
	{
		SQLiteDatabase db = c.openOrCreateDatabase("/sdcard/funnyJokesSina/Database/funnyDB.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		Cursor cursor = db.rawQuery("select * from favorites where body like ?", new String[]{"%"+body+"%"});
		if(cursor.getCount() > 0)
			return true;
		else
			return false;
	}
}
