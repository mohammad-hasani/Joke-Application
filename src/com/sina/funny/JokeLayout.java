package com.sina.funny;

import com.example.jokes.JokeAnimals;
import com.example.jokes.JokeDifferent;
import com.example.jokes.JokeFriendly;
import com.example.jokes.JokeJomlesazi;
import com.example.jokes.JokeNew;
import com.example.jokes.JokeSport;
import com.sina.funny.R;
import com.sina.funny.R.id;
import com.sina.funny.R.layout;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Xml.Encoding;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class JokeLayout extends Activity {
	private Button btnDef, btnNew, btnFriendly, btnJomle, btnAnimal, btnSport;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joek_layout);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		btnDef = (Button)findViewById(R.id.btndef);
		btnNew = (Button)findViewById(R.id.btnnew);
		btnFriendly = (Button)findViewById(R.id.btnfriendly);
		btnJomle = (Button)findViewById(R.id.btnjomle);
		btnAnimal = (Button)findViewById(R.id.btnanimal);
		btnSport = (Button)findViewById(R.id.btnsport);
		btnDef.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(JokeLayout.this, JokeDifferent.class));
			}
		});
		btnNew.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(JokeLayout.this, JokeNew.class));
			}
		});
		btnFriendly.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(JokeLayout.this, JokeFriendly.class));
			}
		});
		
		btnJomle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(JokeLayout.this, JokeJomlesazi.class));
			}
		});
		btnAnimal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(JokeLayout.this, JokeAnimals.class));
			}
		});
		btnSport.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(JokeLayout.this, JokeSport.class));
			}
		});
	}
}
