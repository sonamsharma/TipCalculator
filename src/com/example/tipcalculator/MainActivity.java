package com.example.tipcalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
	        // get the value from the input textfield numbers
				String amt = etAddAmt.getText().toString();
						Double amount = Double.parseDouble(amt);
						Double valAmt = amount*.1;

						// Limit the tip amount to 2 decimal places.
						DecimalFormat newFormat = new DecimalFormat("#.##");
						double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
						String tip = Double.toString(twoDecimal);
						
						// Display the calculated tip amt to the screen
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

				// Limit the tip amount to 2 decimal places.
				DecimalFormat newFormat = new DecimalFormat("#.##");
				double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
				String tip = Double.toString(twoDecimal);
				
				// Display the calculated tip amt to the screen	
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
				
				// Limit the tip amount to 2 decimal places.
				DecimalFormat newFormat = new DecimalFormat("#.##");
				double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
				String tip = Double.toString(twoDecimal);
				// Display the calculated tip amt to the screen
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
