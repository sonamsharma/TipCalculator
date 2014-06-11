package com.example.tipcalculator;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
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
	public TextView tipPay;
	public TextView totalToPay;
	
	int flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etAddAmt = (EditText) findViewById(R.id.addAmt);
		tipPay = (TextView) findViewById(R.id.tipPay);
		totalToPay = (TextView) findViewById(R.id.totalToPay);
		btn10press = (Button) findViewById(R.id.btn10); 
		btn10press.setEnabled(false);
		btn15press = (Button) findViewById(R.id.btn15); 
		btn15press.setEnabled(false);
		btn20press = (Button) findViewById(R.id.btn20); 
		btn20press.setEnabled(false);
		addamtToEditText();
		setUpButtonPressListener();
		
	}

	private void addamtToEditText() {
		// TODO Auto-generated method stub
		final EditText etValue = (EditText) findViewById(R.id.addAmt);
		
		etValue.addTextChangedListener(new TextWatcher() {
		    @Override
		    public void onTextChanged(CharSequence s, int start, int before, int count) {
		        // Fires right as the text is being changed (even supplies the range of text)
		    	btn10press.setEnabled(true);
		    	btn15press.setEnabled(true);
		    	btn20press.setEnabled(true);
		    	
		    }

		    @Override
		    public void beforeTextChanged(CharSequence s, int start, int count,
		            int after) {
		        // Fires right before text is changing
		    	
		    }

		    @Override
		    public void afterTextChanged(Editable s) {
		    	
		    	// on text removed from the edittext field disable the 3 buttons and set text of the tip to 0.0
		    	if(s.length() == 0){
		    		etValue.setHint("Add Amount");
		    		btn10press.setEnabled(false);
			    	btn15press.setEnabled(false);
			    	btn20press.setEnabled(false);
			    	tipPay.setText("0.0");
			    	totalToPay.setText("0.0");
			    	
		    		return;
		    	}
		    	// enable the buttons when the length of the text field is more than 0
		    	if(s.length() >0){
		    		btn10press.setEnabled(true);
			    	btn15press.setEnabled(true);
			    	btn20press.setEnabled(true);
		    	}
		        // do the calculation according to the progress button. 
		        if(flag==1){
		        	firstBtnPress();
		        }if(flag==2){
		        	secondBtnPress();
		        }if(flag==3){
		        	thirdBtnPress();
		        }
		    }
		});
	}
	
	

	private void setUpButtonPressListener() {
		
		btn10press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// assign a flag to it when button 10% is clicked
				flag = 1;
	        // get the value from the input textfield numbers
				String amt = etAddAmt.getText().toString();
				if(amt == null|| amt == ""){
					return;
				}
						Double amount = Double.parseDouble(amt);
						Double valAmt = amount*.1;
						
						// Limit the tip amount to 2 decimal places.
						DecimalFormat newFormat = new DecimalFormat("#.##");
						double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
						String tip = Double.toString(twoDecimal);
						Double totalamt = amount + twoDecimal;
						String addedAmtPay = Double.toString(totalamt);
						// Display the calculated tip amt to the screen
						tipPay.setText(tip);
						totalToPay.setText(addedAmtPay);
				
			}
		});
		
		btn15press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
	        // Do something here  
				// assign a flag to it when button 15% is clicked
				flag = 2;
				
				String amt = etAddAmt.getText().toString();
				if(amt == null|| amt == ""){
					return;
				}

				Double amount = Double.parseDouble(amt);
				Double valAmt = amount*.15;
				
				// Limit the tip amount to 2 decimal places.
				DecimalFormat newFormat = new DecimalFormat("#.##");
				double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
				String tip = Double.toString(twoDecimal);
				Double totalamt = amount + twoDecimal;
				String addedAmtPay = Double.toString(totalamt);
				// Display the calculated tip amt to the screen
				tipPay.setText(tip);
				totalToPay.setText(addedAmtPay);
			}			
		});
		
		btn20press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	        // Do something here  
				
				// assign a flag to it when button 20% is clicked
				flag = 3;
				String amt = etAddAmt.getText().toString();
				if(amt == null|| amt == ""){
					return;
				}

				Double amount = Double.parseDouble(amt);
				Double valAmt = amount*.2;
				
				// Limit the tip amount to 2 decimal places.
				DecimalFormat newFormat = new DecimalFormat("#.##");
				double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
				String tip = Double.toString(twoDecimal);
				Double totalamt = amount + twoDecimal;
				String addedAmtPay = Double.toString(totalamt);
				// Display the calculated tip amt to the screen
				tipPay.setText(tip);
				totalToPay.setText(addedAmtPay);
			}			
		});
	} 

	private void firstBtnPress() {
				// assign a flag to it when button 10% is clicked
				flag = 1;
	        // get the value from the input textfield numbers
				String amt = etAddAmt.getText().toString();
				if(amt == null|| amt == ""){
					return;
				}

				Double amount = Double.parseDouble(amt);
				Double valAmt = amount*.1;
				
				// Limit the tip amount to 2 decimal places.
				DecimalFormat newFormat = new DecimalFormat("#.##");
				double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
				String tip = Double.toString(twoDecimal);
				Double totalamt = amount + twoDecimal;
				String addedAmtPay = Double.toString(totalamt);
				// Display the calculated tip amt to the screen
				tipPay.setText(tip);
				totalToPay.setText(addedAmtPay);
	}
	
	private void secondBtnPress(){
				
	        // Do something here  
				// assign a flag to it when button 15% is clicked
				flag = 2;
				
				String amt = etAddAmt.getText().toString();
				if(amt == null|| amt == ""){
					return;
				}

				Double amount = Double.parseDouble(amt);
				Double valAmt = amount*.15;
				
				// Limit the tip amount to 2 decimal places.
				DecimalFormat newFormat = new DecimalFormat("#.##");
				double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
				String tip = Double.toString(twoDecimal);
				Double totalamt = amount + twoDecimal;
				String addedAmtPay = Double.toString(totalamt);
				// Display the calculated tip amt to the screen
				tipPay.setText(tip);
				totalToPay.setText(addedAmtPay);
		
	}
	private void thirdBtnPress(){
				
				// assign a flag to it when button 15% is clicked
				flag = 3;
				String amt = etAddAmt.getText().toString();
				if(amt == null|| amt == ""){
					return;
				}

				Double amount = Double.parseDouble(amt);
				Double valAmt = amount*.2;
				
				// Limit the tip amount to 2 decimal places.
				DecimalFormat newFormat = new DecimalFormat("#.##");
				double twoDecimal =  Double.valueOf(newFormat.format(valAmt));
				String tip = Double.toString(twoDecimal);
				Double totalamt = amount + twoDecimal;
				String addedAmtPay = Double.toString(totalamt);
				// Display the calculated tip amt to the screen
				tipPay.setText(tip);
				totalToPay.setText(addedAmtPay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
