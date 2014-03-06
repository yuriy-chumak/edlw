package com.example.edlw;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base, menu);
		return true;
	}
*/
	protected void set(int id, int text)
	{
		set(id, Integer.toString(text));
	}
	protected void set(int id, String text)
	{
		((TextView)findViewById(id)).setText(text);
	}
	
	protected int get(int id)
	{
		try {
			return Integer.parseInt(((EditText)findViewById(id)).getText().toString());
		}
		catch (Exception ex) {}
		return 0;
	}
	protected int get(Editable value)
	{
		try {
			return Integer.parseInt(value.toString());
		}
		catch (Exception ex) {}
		return 0;
	}
	
}
