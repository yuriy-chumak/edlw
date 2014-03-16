package com.example.edlw;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FoundActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.found);
		
		findViewById(R.id.to_common).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}});
		
		((TextView)findViewById(R.id.G5)).setText(Integer.toString(Model.G5));
		((TextView)findViewById(R.id.H5)).setText(Integer.toString(Model.H5));
		((TextView)findViewById(R.id.I5)).setText(Integer.toString(Model.I5));
		((TextView)findViewById(R.id.J5)).setText(
				Integer.toString(Model.J5 / 60) + ":" +
				Integer.toString(Model.J5 % 60)
		);

		((TextView)findViewById(R.id.G8)).setText(Integer.toString(Model.G8));
		((TextView)findViewById(R.id.H8)).setText(Integer.toString(Model.H8));
		((TextView)findViewById(R.id.I8)).setText(Integer.toString(Model.I8));
		((TextView)findViewById(R.id.J8)).setText(
				Integer.toString(Model.J8 / 60) + ":" +
				Integer.toString(Model.J8 % 60)
		);
		
	}
}
