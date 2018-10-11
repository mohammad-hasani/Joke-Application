package com.sina.funny;

import java.util.Timer;
import java.util.TimerTask;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class AboutMe extends Activity {
	private int x = 0;
	private TextView txt1;
	private int y = 0;
	char[] data = ">Mohammad Hasani...! ".toCharArray();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_me);
		txt1 = (TextView)findViewById(R.id.textView1);
		ActionBar ab = getActionBar();
		ab.hide();
		Typeface face = Typeface.createFromAsset(getAssets(), "fonts/leadcoat.ttf");
		txt1.setTypeface(face);
		txt1.setText("");
		TextView txt2 = (TextView)findViewById(R.id.textView2);
		txt2.setTypeface(face);
		txt2.setText("דהÈÚ : " + "\n" + "4jok.com");
		x = 0;
		timer1();
	}
	private void timer1()
	{
		x = 0;
		final Timer timer = new Timer();
		txt1.setText("");
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				txt1.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
							txt1.setText(txt1.getText().toString() + data[x]);
						x++;
						if(x == data.length - 4)
						{
							timer.cancel();
							timer2();
						}
					}
				});
				
			}
		};
		timer.scheduleAtFixedRate(task, 0, 200);
	}
	private void timer2()
	{
		final Timer timer2 = new Timer();
		TimerTask task2 = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				txt1.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						txt1.setText(txt1.getText().toString() + data[x]);
						x++;
						if(x == data.length - 1)
						{
							timer2.cancel();
							timer3();
						}
					}
				});
			}
		};
		timer2.scheduleAtFixedRate(task2, 500, 500);
	}
	private void timer3()
	{
		final Timer timer3 = new Timer();
		TimerTask task3 = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				txt1.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if(x > data.length)
						{
							timer3.cancel();
							timer1();
						}
						try{
							txt1.setText(txt1.getText().toString() + data[x]);
						}catch(Exception er){}
						x++;

					}
				});
			}
		};timer3.scheduleAtFixedRate(task3, 1000, 1000);
	}
}
