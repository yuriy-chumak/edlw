package com.example.edlw;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CommonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.common);
		
		findViewById(R.id.to_p).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}});
		findViewById(R.id.to_found).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivityForResult(new Intent(CommonActivity.this.getBaseContext(),
						FoundActivity.class), 0);
			}});
		findViewById(R.id.to_not_found).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivityForResult(new Intent(CommonActivity.this.getBaseContext(),
						NotFoundActivity.class), 0);
			}});
		
		((TextView)findViewById(R.id.E5)).setText(Integer.toString(Model.E5));
		((TextView)findViewById(R.id.F5)).setText(
				Integer.toString(Model.F5 / 60) + ":" +
				Integer.toString(Model.F5 % 60)
		);
		
	}
}
