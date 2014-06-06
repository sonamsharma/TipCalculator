package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public EditText etAddAmt;
	public Button btn10press;
	public Button btn15press;
	public Button btn20press;
	public TextView totalPay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etAddAmt = (EditText) findViewById(R.id.addAmt);
		totalPay = (TextView) findViewById(R.id.totalPay);
		btn10press = (Button) findViewById(R.id.btn10); 
		btn15press = (Button) findViewById(R.id.btn15); 
		btn20press = (Button) findViewById(R.id.btn20); 
		setUpButtonPressListener();
		
	}

	private void setUpButtonPressListener() {
		btn10press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	        // Do something here  
				String amt = etAddAmt.getText().toString();
				Double amount = Double.parseDouble(amt);
				Double valAmt = amount*.1;
				String tip = Double.toString(valAmt);
				totalPay.setText(tip);
			}
		});
		
		btn15press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	        // Do something here  
				String amt = etAddAmt.getText().toString();
				Double amount = Double.parseDouble(amt);
				Double valAmt = amount*.15;
				String tip = Double.toString(valAmt);
				totalPay.setText(tip);
			}			
		});
		
		btn20press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	        // Do something here  
				String amt = etAddAmt.getText().toString();
				Double amount = Double.parseDouble(amt);
				Double valAmt = amount*.2;
				String tip = Double.toString(valAmt);
				totalPay.setText(tip);
			}			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
