package com.example.edlw;

import java.io.EOFException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jatha.Lisp;
import org.jatha.Tests;
import org.jatha.compile.LispPrimitive1;
import org.jatha.compile.LispPrimitive2;
import org.jatha.dynatype.LispNumber;
import org.jatha.dynatype.LispSymbol;
import org.jatha.dynatype.LispValue;
import org.jatha.dynatype.StandardLispCons;
import org.jatha.dynatype.StandardLispConstant;
import org.jatha.dynatype.StandardLispNIL;
import org.jatha.dynatype.StandardLispSymbol;
import org.jatha.exception.CompilerException;
import org.jatha.exception.LispValueNotANumberException;
import org.jatha.exception.LispValueNotASymbolException;
import org.jatha.read.LispParser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {
	static Lisp lisp = new Lisp();
	static LispParser cli = new LispParser(lisp, new InputStreamReader(System.in));
	static {
/*		while (true) {
			System.out.print("> ");
			try {
				System.out.println(lisp.eval(cli.read()).toString());
			} catch (EOFException e) {
				return; // done.
			}
		}*/
	}
	
	
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
		
		
		lisp.COMPILER.Register(new LispPrimitive1(lisp, "SLEEP") {
			@Override
			protected LispValue Execute(LispValue arg) throws CompilerException {
				if (arg instanceof LispNumber) {
					int times = (int)((LispNumber)arg).getLongValue();
					try {
						Thread.sleep(times);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return lisp.T;
				}
				throw new LispValueNotANumberException(arg);
			}
		});
		lisp.COMPILER.Register(new LispPrimitive1(lisp, "FIND-VIEW-BY-ID") {
			@Override
			protected LispValue Execute(LispValue arg) throws CompilerException {
				if (arg instanceof LispNumber) {
					int id = (int)((LispNumber)arg).getLongValue();
					return new LispView(lisp, "view-" + (LispNumber)arg, findViewById(id));
				}
				throw new LispValueNotANumberException(arg);
			}
		});
		lisp.COMPILER.Register(new LispPrimitive2(lisp, "SET-VIEW-BACKGROUND-COLOR") {
			@Override
			protected LispValue Execute(LispValue arg1, LispValue arg2) throws CompilerException {
				if (!(arg2 instanceof LispNumber))
					throw new LispValueNotANumberException(arg2);
				if (!(arg1 instanceof LispSymbol))
					throw new LispValueNotASymbolException(arg1);
				
				final LispView lview = (LispView)arg1;
				final int color = (int)((LispNumber)arg2).getLongValue();
				
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						lview.view.setBackgroundColor(0xFF000000 + (color & 0x00FFFFFF));
						lview.view.invalidate();
					}});
				return Lisp.NIL;
			}
		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				String scenario = "tests/scenario1.lisp";
				Reader resourceReader = new InputStreamReader(
						MainActivity.class.getClassLoader().getResourceAsStream(scenario)
				);
				
				Log.i("lisp", "Testing " + scenario + " ... ");
//				List<String> errors = new ArrayList<String>();
				
//				Lisp lisp = new Lisp(); 
				Log.i("lisp", lisp.eval("(defun restart () 'restart)").toString());   // сигнал к перезагрузке интерпретатора
				
				LispParser cli = new LispParser(lisp, resourceReader);
				while (true) {
					// System.io.printnl();
					try {
						LispValue s = cli.read();
						if (s instanceof StandardLispSymbol) {
							if (s.toString().equals("RESTART")) {
								lisp = new Lisp();
								cli = new LispParser(lisp, resourceReader);
								continue;
							}
						}
						LispValue r = lisp.eval(s);
						Log.i("lisp", r.toString());
						
						if ((r instanceof StandardLispConstant && !r.toString().equals("T"))
						 || (r instanceof StandardLispNIL)
						) {
							Log.e("lisp", "    FAILED " + s.toString() + " -> " + r.toString());
						}
					} catch (EOFException e) {
						break;
					}
				}
/*				if (errors.size() > 0) {
					System.out.println("FAILED!");
					for (String error : errors)
						System.out.println("    " + error);					
					System.out.println("!FAILED");					
				}
				else
					System.out.println("Ok");*/
			}
		}).start();
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/
}

class LispView extends StandardLispSymbol
{
	View view;
	public LispView(Lisp lisp, String symbolName, View view) {
		super(lisp, symbolName);
		
		this.view = view;
	}
}