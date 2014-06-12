package com.example.tipcalculator;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText etAddAmt;
	private Button btn10press;
	private Button btn15press;
	private Button btn20press;
	private TextView tipPay;
	private TextView totalToPay;
	private TextView textProgress;
	private SeekBar bar;
	private TextView eachPayAmt;
	
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
		textProgress = (TextView)findViewById(R.id.tv_splitvalue);
		bar = (SeekBar)findViewById(R.id.seekBar);
		eachPayAmt = (TextView)findViewById(R.id.tv_eachPay);
		addamtToEditText();
		setUpButtonPressListener();
		seekbarValue();
		
	}
	
	private void seekbarValue(){
		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
                // Log the progress
           Log.d("DEBUG", "Progress is: "+progress);
                           //set textView's text
           textProgress.setText(""+progress);
           
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			} 
			
		});
	
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
			    	eachPayAmt.setText("0.0");
			    	
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
			// get the value from the splitter number 
				String tvProgress = textProgress.getText().toString();
				Double tvProgressinDouble = Double.parseDouble(tvProgress);
				if(tvProgressinDouble == 0){
					tvProgressinDouble = (double)1;
				}
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
						String totalAmtPay = Double.toString(Double.valueOf(newFormat.format(totalamt)));
						Double totalAfterSplit = totalamt/tvProgressinDouble;
						String eachPay = Double.toString(Double.valueOf(newFormat.format(totalAfterSplit)));
						// Display the calculated tip amt to the screen
						tipPay.setText(tip);
						totalToPay.setText(totalAmtPay);
						eachPayAmt.setText(eachPay);
				
			}
		});
		
		btn15press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
	        // Do something here  
				// assign a flag to it when button 15% is clicked
				flag = 2;
	        // get the value from the input textfield numbers
				String amt = etAddAmt.getText().toString();
			// get the value from the splitter number 
				String tvProgress = textProgress.getText().toString();
				Double tvProgressinDouble = Double.parseDouble(tvProgress);
				if(tvProgressinDouble == 0){
					tvProgressinDouble = (double)1;
				}
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
						String totalAmtPay = Double.toString(Double.valueOf(newFormat.format(totalamt)));
						Double totalAfterSplit = totalamt/tvProgressinDouble;
						String eachPay = Double.toString(Double.valueOf(newFormat.format(totalAfterSplit)));
						// Display the calculated tip amt to the screen
						tipPay.setText(tip);
						totalToPay.setText(totalAmtPay);
						eachPayAmt.setText(eachPay);
				
			}			
		});
		
		btn20press.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	        // Do something here  
				
				// assign a flag to it when button 20% is clicked
				// assign a flag to it when button 10% is clicked
				flag = 3;
	        // get the value from the input textfield numbers
				String amt = etAddAmt.getText().toString();
			// get the value from the splitter number 
				String tvProgress = textProgress.getText().toString();
				Double tvProgressinDouble = Double.parseDouble(tvProgress);
				if(tvProgressinDouble == 0){
					tvProgressinDouble = (double)1;
				}
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
						String totalAmtPay = Double.toString(Double.valueOf(newFormat.format(totalamt)));
						Double totalAfterSplit = totalamt/tvProgressinDouble;
						String eachPay = Double.toString(Double.valueOf(newFormat.format(totalAfterSplit)));
						// Display the calculated tip amt to the screen
						tipPay.setText(tip);
						totalToPay.setText(totalAmtPay);
						eachPayAmt.setText(eachPay);
				
			}			
		});
	} 

	private void firstBtnPress() {
				// assign a flag to it when button 10% is clicked
		// assign a flag to it when button 10% is clicked
		flag = 1;
    // get the value from the input textfield numbers
		String amt = etAddAmt.getText().toString();
	// get the value from the splitter number 
		String tvProgress = textProgress.getText().toString();
		Double tvProgressinDouble = Double.parseDouble(tvProgress);
		if(tvProgressinDouble == 0){
			tvProgressinDouble = (double)1;
		}
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
				String totalAmtPay = Double.toString(Double.valueOf(newFormat.format(totalamt)));
				Double totalAfterSplit = totalamt/tvProgressinDouble;
				String eachPay = Double.toString(Double.valueOf(newFormat.format(totalAfterSplit)));
				// Display the calculated tip amt to the screen
				tipPay.setText(tip);
				totalToPay.setText(totalAmtPay);
				eachPayAmt.setText(eachPay);
		
	}
	
	private void secondBtnPress(){
				
	        // Do something here  
				// assign a flag to it when button 15% is clicked
		// assign a flag to it when button 10% is clicked
		flag = 2;
    // get the value from the input textfield numbers
		String amt = etAddAmt.getText().toString();
	// get the value from the splitter number 
		String tvProgress = textProgress.getText().toString();
		Double tvProgressinDouble = Double.parseDouble(tvProgress);
		if(tvProgressinDouble == 0){
			tvProgressinDouble = (double)1;
		}
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
				String totalAmtPay = Double.toString(Double.valueOf(newFormat.format(totalamt)));
				Double totalAfterSplit = totalamt/tvProgressinDouble;
				String eachPay = Double.toString(Double.valueOf(newFormat.format(totalAfterSplit)));
				// Display the calculated tip amt to the screen
				tipPay.setText(tip);
				totalToPay.setText(totalAmtPay);
				eachPayAmt.setText(eachPay);
		
		
	}
	private void thirdBtnPress(){
				
				// assign a flag to it when button 15% is clicked
				flag = 3;
	        // get the value from the input textfield numbers
				String amt = etAddAmt.getText().toString();
			// get the value from the splitter number 
				String tvProgress = textProgress.getText().toString();
				Double tvProgressinDouble = Double.parseDouble(tvProgress);
				if(tvProgressinDouble == 0){
					tvProgressinDouble = (double)1;
				}
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
						String totalAmtPay = Double.toString(Double.valueOf(newFormat.format(totalamt)));
						Double totalAfterSplit = totalamt/tvProgressinDouble;
						String eachPay = Double.toString(Double.valueOf(newFormat.format(totalAfterSplit)));
						// Display the calculated tip amt to the screen
						tipPay.setText(tip);
						totalToPay.setText(totalAmtPay);
						eachPayAmt.setText(eachPay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
