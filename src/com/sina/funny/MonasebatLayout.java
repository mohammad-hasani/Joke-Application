package com.sina.funny;

import com.example.rest.Monasebat;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonasebatLayout extends Activity {
	private Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.monasebat_layout);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		i = new Intent(this, Monasebat.class);
		Button btn13 = (Button)findViewById(R.id.btn0);
		btn13.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 0);
				startActivity(i);
			}
		});
		Button btnChrismas = (Button)findViewById(R.id.btn1);
		btnChrismas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 1);
				startActivity(i);
			}
		});
		Button btnGhadir = (Button)findViewById(R.id.btn2);
		btnGhadir.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 2);
				startActivity(i);
			}
		});
		Button btnGhorban = (Button)findViewById(R.id.btn3);
		btnGhorban.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 3);
				startActivity(i);
			}
		});
		Button btnMoharam = (Button)findViewById(R.id.btn4);
		btnMoharam.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 4);
				startActivity(i);
			}
		});
		Button btnRamazan = (Button)findViewById(R.id.btn5);
		btnRamazan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 5);
				startActivity(i);
			}
		});
		Button btnEmamZaman = (Button)findViewById(R.id.btn6);
		btnEmamZaman.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 6);
				startActivity(i);
			}
		});
		Button btnMiladPiambar = (Button)findViewById(R.id.btn7);
		btnMiladPiambar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 7);
				startActivity(i);
			}
		});
		Button btnNoruz = (Button)findViewById(R.id.btn8);
		btnNoruz.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 8);
				startActivity(i);
			}
		});
		Button btnRehlatPiambar = (Button)findViewById(R.id.btn9);
		btnRehlatPiambar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 9);
				startActivity(i);
			}
		});
		Button btnArafe = (Button)findViewById(R.id.btn10);
		btnArafe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 10);
				startActivity(i);
			}
		});
		Button btnMadar = (Button)findViewById(R.id.btn11);
		btnMadar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 11);
				startActivity(i);
			}
		});
		Button btnPedar = (Button)findViewById(R.id.btn12);
		btnPedar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 12);
				startActivity(i);
			}
		});
		Button btnGhadr = (Button)findViewById(R.id.btn13);
		btnGhadr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 13);
				startActivity(i);
			}
		});
		Button btnYalda = (Button)findViewById(R.id.btn14);
		btnYalda.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 14);
				startActivity(i);
			}
		});
		Button btnShahadatHazratFateme = (Button)findViewById(R.id.btn15);
		btnShahadatHazratFateme.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 15);
				startActivity(i);
			}
		});
		Button btnEmamReza = (Button)findViewById(R.id.btn16);
		btnEmamReza.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i.putExtra("w", 16);
				startActivity(i);
			}
		});
	}
}
