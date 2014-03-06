package com.example.edlw;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class NotFoundActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.not_found);
		
		findViewById(R.id.to_common).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}});
		
		set(R.id.K5, Model.K5);
		set(R.id.L5, Model.L5);
		set(R.id.M5,
				Integer.toString(Model.M5 / 10) + "." +
				Integer.toString(Model.M5 % 10)
		);

		set(R.id.K8, Model.K8);
		set(R.id.L8, Model.L8);
		set(R.id.M8,
				Integer.toString(Model.M8 / 10) + "." +
				Integer.toString(Model.M8 % 10)
		);
	}
}
