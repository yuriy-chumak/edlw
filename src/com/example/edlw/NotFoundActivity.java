package com.example.edlw;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class NotFoundActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.not_found);
		
		findViewById(R.id.to_common).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}});
		
		((TextView)findViewById(R.id.K5)).setText(Integer.toString(Model.K5));
		((TextView)findViewById(R.id.L5)).setText(Integer.toString(Model.L5));
		((TextView)findViewById(R.id.M5)).setText(
				Integer.toString(Model.M5 / 10) + "." +
				Integer.toString(Model.M5 % 10)
		);

		((TextView)findViewById(R.id.K8)).setText(Integer.toString(Model.K8));
		((TextView)findViewById(R.id.L8)).setText(Integer.toString(Model.L8));
		((TextView)findViewById(R.id.M8)).setText(
				Integer.toString(Model.M8 / 10) + "." +
				Integer.toString(Model.M8 % 10)
		);
	}
}
