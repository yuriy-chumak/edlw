package com.example.edlw;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FoundActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.found);
		
		findViewById(R.id.to_common).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}});
		
		set(R.id.G5, Model.G5);
		set(R.id.H5, Model.H5);
		set(R.id.I5, Model.I5);
		set(R.id.J5, 
				Integer.toString(Model.J5 / 60 % 24) + ":" +
				Integer.toString(Model.J5 % 60)
		);

		set(R.id.G8, Model.G8);
		set(R.id.H8, Model.H8);
		set(R.id.I8, Model.I8);
		set(R.id.J8,
				Integer.toString(Model.J8 / 60 % 24) + ":" +
				Integer.toString(Model.J8 % 60)
		);
	}
}
