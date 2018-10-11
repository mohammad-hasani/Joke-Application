package com.sina.funny;




import java.util.Timer;
import java.util.TimerTask;

import com.example.details.Favorites;
import com.example.rest.EterafMikonam;
import com.example.rest.FakoFamil;
import com.example.rest.FunnyDiaries;
import com.example.rest.Monasebat;
import com.example.rest.MoredDashtim;
import com.example.rest.PaNaPa;
import com.example.rest.ShortStory;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {
	private Button btnFavorites, btnjoke, btnSms, btnMonasebat, btnEteraf, btnFako, btnDiaries, btnMored, btnPanapa, btnStory;
	private int[] i = {0,0,0,0,0,0,0,0,0};
	private ImageView img;
	private LinearLayout lay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		///

		/////
		btnFavorites = (Button)findViewById(R.id.button0);
		btnFavorites.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, Favorites.class));
			}
		});
		btnjoke = (Button)findViewById(R.id.button1);
		btnjoke.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, JokeLayout.class));
			}
		});
		btnSms = (Button)findViewById(R.id.button2);
		btnSms.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, SmsLayout.class));
			}
		});
		btnEteraf = (Button)findViewById(R.id.button3);
		btnEteraf.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, EterafMikonam.class));
			}
		});
		btnFako = (Button)findViewById(R.id.button4);
		btnFako.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, FakoFamil.class));
			}
		});
		btnDiaries = (Button)findViewById(R.id.button5);
		btnDiaries.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, FunnyDiaries.class));
			}
		});
		btnMored = (Button)findViewById(R.id.button7);
		btnMored.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, MoredDashtim.class));
			}
		});
		btnPanapa = (Button) findViewById(R.id.button8);
		btnPanapa.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, PaNaPa.class));
			}
		});
		btnStory = (Button)findViewById(R.id.button9);
		btnStory.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, ShortStory.class));
			}
		});
		btnMonasebat = (Button)findViewById(R.id.button6);
		btnMonasebat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, MonasebatLayout.class));
			}
		});
		btnjoke.setAnimation(anim(100));
		btnSms.setAnimation(anim(200));
		btnEteraf.setAnimation(anim(300));
		btnFako.setAnimation(anim(400));
		btnDiaries.setAnimation(anim(500));
		btnMonasebat.setAnimation(anim(600));
		btnMored.setAnimation(anim(700));
		btnPanapa.setAnimation(anim(800));
		btnStory.setAnimation(anim(900));
		
		////
		
		
	}
	private Animation anim(int startOffSet)
	{
		AnimationSet animSet = new AnimationSet(true);
		animSet.setFillAfter(true);
		animSet.setFillEnabled(true);
		TranslateAnimation trans1 = new TranslateAnimation(-1000, 100, 0, 0);
		trans1.setDuration(1000);
		trans1.setStartOffset(startOffSet);
		animSet.addAnimation(trans1);
		TranslateAnimation trans2 = new TranslateAnimation(0, -100, 0, 0);
		trans2.setDuration(100);
		trans2.setStartOffset(startOffSet + 1000);
		animSet.addAnimation(trans2);
		return animSet;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.about_me:
			startActivity(new Intent(MainActivity.this, AboutMe.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}