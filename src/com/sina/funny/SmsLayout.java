package com.sina.funny;


import com.example.sms.Sms;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;

public class SmsLayout extends Activity {
	private Button btnAshegh, btnAshti, btnEmamZaman, btnFalsafi, btnFriendly, btnFunny, btnKhodavand,
		btnMazhabi, btnNew, btnShabbekheyr, btnShabeArezooha, btnSobhBekheyr, btnTabrikRoozeTavalod,
		btnTasliat, btnZiba;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_layout);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		btnAshegh = (Button)findViewById(R.id.btnashegh);
		btnAshegh.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 0);
				startActivity(i);
			}
		});
		btnAshti = (Button)findViewById(R.id.btnashti);
		btnAshti.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 1);
				startActivity(i);
			}
		});
		btnEmamZaman = (Button)findViewById(R.id.btnemamzaman);
		btnEmamZaman.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 2);
				startActivity(i);
			}
		});
		btnFalsafi = (Button)findViewById(R.id.btnfalsafi);
		btnFalsafi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 3);
				startActivity(i);
			}
		});
		btnFriendly = (Button)findViewById(R.id.btnfriendly);
		btnFriendly.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 4);
				startActivity(i);
			}
		});
		btnFunny = (Button)findViewById(R.id.btnfunny);
		btnFunny.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 5);
				startActivity(i);
			}
		});
		btnKhodavand = (Button)findViewById(R.id.btngod);
		btnKhodavand.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 6);
				startActivity(i);
			}
		});
		btnMazhabi = (Button)findViewById(R.id.btnmazhabi);
		btnMazhabi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 7);
				startActivity(i);
			}
		});
		btnNew = (Button)findViewById(R.id.btnnew);
		btnNew.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 8);
				startActivity(i);
			}
		});
		btnShabbekheyr = (Button)findViewById(R.id.btnshabbekheyr);
		btnShabbekheyr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 9);
				startActivity(i);
			}
		});
		btnShabeArezooha = (Button)findViewById(R.id.btnshabearezooha);
		btnShabeArezooha.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 10);
				startActivity(i);
			}
		});
		btnSobhBekheyr = (Button)findViewById(R.id.btnsobhbekheyr);
		btnSobhBekheyr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 11);
				startActivity(i);
			}
		});
		btnTabrikRoozeTavalod = (Button)findViewById(R.id.btntabrikroozetavalod);
		btnTabrikRoozeTavalod.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 12);
				startActivity(i);
			}
		});
		btnTasliat = (Button)findViewById(R.id.btntasliat);
		btnTasliat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 13);
				startActivity(i);
			}
		});
		btnZiba = (Button)findViewById(R.id.btnziba);
		btnZiba.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SmsLayout.this, Sms.class);
				i.putExtra("which", 14);
				startActivity(i);
			}
		});
		
 	}
}
