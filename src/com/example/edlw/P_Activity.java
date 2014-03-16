package com.example.edlw;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class P_Activity extends Activity {
/*	class functor {
		functor(int id, )
	}*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.p);
		
		findViewById(R.id.to_main).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}});
		findViewById(R.id.to_common).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Model.setB5(get(R.id.B5));
				Model.setB6(get(R.id.B6));
				Model.setB7(get(R.id.B7));
				Model.setB8(get(R.id.B8));
				Model.setB9(get(R.id.B9));
				
				Model.setC5(get(R.id.C5));
				Model.setC6(get(R.id.C6));
				Model.setC7(get(R.id.C7));
				Model.setC8(get(R.id.C8));
				Model.setC9(get(R.id.C9));
				
				startActivityForResult(new Intent(P_Activity.this.getBaseContext(),
						CommonActivity.class), 0);
			}});
		

		// Рна входе в НДДС
		((EditText)findViewById(R.id.B5)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setB5(get(value));
				((TextView)findViewById(R.id.D5)).setText(Integer.toString(Model.D5));
			}});
		((EditText)findViewById(R.id.B6)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setB6(get(value));
				((TextView)findViewById(R.id.D6)).setText(Integer.toString(Model.D6));
			}});
		((EditText)findViewById(R.id.B7)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setB7(get(value));
				((TextView)findViewById(R.id.D7)).setText(Integer.toString(Model.D7));
			}});
		((EditText)findViewById(R.id.B8)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setB8(get(value));
				((TextView)findViewById(R.id.D8)).setText(Integer.toString(Model.D8));
			}});
		((EditText)findViewById(R.id.B9)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setB9(get(value));
				((TextView)findViewById(R.id.D9)).setText(Integer.toString(Model.D9));
			}});
		
		// Рпо прибытии к месту работы
		((EditText)findViewById(R.id.C5)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setC5(get(value));
				((TextView)findViewById(R.id.D5)).setText(Integer.toString(Model.D5));
			}});
		((EditText)findViewById(R.id.C6)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setC6(get(value));
				((TextView)findViewById(R.id.D6)).setText(Integer.toString(Model.D6));
			}});
		((EditText)findViewById(R.id.C7)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setC7(get(value));
				((TextView)findViewById(R.id.D7)).setText(Integer.toString(Model.D7));
			}});
		((EditText)findViewById(R.id.C8)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setC8(get(value));
				((TextView)findViewById(R.id.D8)).setText(Integer.toString(Model.D8));
			}});
		((EditText)findViewById(R.id.C9)).addTextChangedListener(new TextWatcher() {
			@Override public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
			@Override public void afterTextChanged(Editable value) {
				Model.setC9(get(value));
				((TextView)findViewById(R.id.D9)).setText(Integer.toString(Model.D9));
			}});
	}
	
	private int get(int id)
	{
		try {
			return Integer.parseInt(((EditText)findViewById(id)).getText().toString());
		}
		catch (Exception ex) {}
		return 0;
	}
	private int get(Editable value)
	{
		try {
			return Integer.parseInt(value.toString());
		}
		catch (Exception ex) {}
		return 0;
	}
}
