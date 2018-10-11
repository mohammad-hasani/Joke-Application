package com.sina.funny;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class SplashLayout extends Activity {
	private int x = 0;
	private Timer t;
	private ImageView img;
	private WebView web;
	private LinearLayout lay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_layout);
		createDB();
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		lay = (LinearLayout)findViewById(R.id.LinearLayout1);
		web = (WebView)findViewById(R.id.webView1);
		web.loadUrl("file:///android_asset/sign.gif");
		t = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				x++;
				if(x >= 5)
				{
					
					web.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							startActivity(new Intent(SplashLayout.this, MainActivity.class));
							t.cancel();
						}
					});
					
				}
	
			}
		};
		t.scheduleAtFixedRate(task, 0, 1000);
		SharedPreferences settings = getSharedPreferences("ranking", MODE_PRIVATE);
		boolean b = settings.getBoolean("r", false);
		if(!b)
		{
			new sendRank().execute();
		}
	}
	private Animation animation()
	{
		AnimationSet animset = new AnimationSet(true);
		animset.setFillAfter(true);
		animset.setFillEnabled(true);
		TranslateAnimation trans1 = new TranslateAnimation(1280, 0, -300, -300);
		trans1.setDuration(1000);
		trans1.setFillAfter(true);
		trans1.setFillEnabled(true);
		animset.addAnimation(trans1);
		return animset;
	}
	class sendRank extends AsyncTask<String, Integer, String>
	{
		private String namespace = "http://tempuri.org/";
		private String method = "getRanking";
		private String url = "http://www.https-code.cf/Service1.asmx";
		private String Soap_Action = "http://tempuri.org/getRanking";
		private String result = null;
		private SoapPrimitive sp;
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String result = null;
			try{
				SoapObject request = new SoapObject(namespace, method);
				request.addProperty("code", "ranking");
				SoapSerializationEnvelope env = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				env.dotNet = true;
				env.setOutputSoapObject(request);
				HttpTransportSE http = new HttpTransportSE(url);
				http.call(Soap_Action, env);
				sp =  (SoapPrimitive) env.getResponse();
			}catch(Exception er){Log.d("aaaaaaaaaaaaaaaaaaaaaaaaaaaa", er.getMessage());}
			result = String.valueOf(sp);
			return result;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(result.compareTo("ok") == 0)
			{
				SharedPreferences settings = getSharedPreferences("ranking", MODE_PRIVATE);
				Editor ed = settings.edit();
				ed.putBoolean("r", true);
				ed.commit();
			}
		}
	}
	private void createDB()
	{
		try
		{
			File f = new File("/sdcard/funnyJokesSina/Database");
			if(!f.exists())
			{
				f.mkdirs();
				f.createNewFile();
				createDBPath(getBaseContext().getAssets().open("funnyDB.db"),new FileOutputStream(f+"/funnyDB.db"));
			}
		}
		catch(Exception e)
		{
			Log.d("log", e.getMessage());
		}
	}
	private void createDBPath(InputStream infile , OutputStream outfile)
	{
			byte[] buffer = new byte[1024];
			int length;
			try {
				while((length = infile.read(buffer)) > 0)
				{
					outfile.write(buffer, 0, length);
				}
				infile.close();
				outfile.close();
			} catch(Exception e)
			{
				Log.d("log", e.getMessage());
			}
	}
}
