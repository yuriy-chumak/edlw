package com.example.edlw;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.main);
		
		findViewById(R.id.to_p).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TimePicker time = (TimePicker)findViewById(R.id.timePicker);
				Model.A5 = time.getCurrentHour() * 60 + time.getCurrentMinute();
				
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
						WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
				
				startActivityForResult(new Intent(MainActivity.this.getBaseContext(),
						P_Activity.class), 0);
				
				getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
			}});
		
		findViewById(R.id.now).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Calendar c = Calendar.getInstance();
				TimePicker time = (TimePicker)findViewById(R.id.timePicker);
				time.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
				time.setCurrentMinute(c.get(Calendar.MINUTE));
			}});
		
		((TimePicker)findViewById(R.id.timePicker)).setIs24HourView(true);
		((TimePicker)findViewById(R.id.timePicker)).setOnTimeChangedListener(new OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker time, int arg1, int arg2) {
				Model.A5 = time.getCurrentHour() * 60 + time.getCurrentMinute();
			}
		});
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/
}
