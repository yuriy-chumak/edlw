package com.wata;

import java.io.EOFException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.jatha.Lisp;
import org.jatha.dynatype.LispValue;
import org.jatha.dynatype.StandardLispConstant;
import org.jatha.dynatype.StandardLispNIL;
import org.jatha.dynatype.StandardLispSymbol;
import org.jatha.read.LispParser;

import com.example.edlw.MainActivity;
import com.wata.framework.type.LispActivity;

import android.app.Activity;
import android.util.Log;

public class Framework {
	static Lisp lisp = new Lisp();
	static LispParser cli = new LispParser(lisp, new InputStreamReader(System.in));
	
	public Framework(final Activity activity)
	{
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
				Log.i("lisp", lisp.intern("THIS", new LispActivity("THIS", activity)).toString());
				
				LispParser cli = new LispParser(lisp, resourceReader);
				while (true) {
					// System.io.printnl();
					try {
						LispValue s = cli.read();
/*						if (s instanceof StandardLispSymbol) {
							if (s.toString().equals("RESTART")) {
								lisp = new Lisp();
								cli = new LispParser(lisp, resourceReader);
								continue;
							}
						}*/
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
}