package org.jatha.extras;

import org.jatha.Registrar;
import org.jatha.compile.LispCompiler;
import org.jatha.compile.LispPrimitive1;
import org.jatha.compile.LispPrimitive2;
import org.jatha.dynatype.LispNumber;
import org.jatha.dynatype.LispSymbol;
import org.jatha.dynatype.LispValue;
import org.jatha.dynatype.StandardLispSymbol;
import org.jatha.exception.CompilerException;
import org.jatha.exception.LispValueNotANumberException;
import org.jatha.exception.LispValueNotASymbolException;
import com.wata.framework.type.LispActivity;

import android.app.Activity;
import android.view.View;

public class ANDROID implements Registrar
{
	@Override
	public void Register(LispCompiler lisp) {
		final Activity activity = ((LispActivity)lisp.getLisp().intern("THIS")).getActivity();

		lisp.Register(new LispPrimitive1("SLEEP") {
			@Override
			protected LispValue Execute(LispValue arg) throws CompilerException {
				if (arg instanceof LispNumber) {
					int times = (int)((LispNumber)arg).getLongValue();
					try {
						Thread.sleep(times);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return T;
				}
				throw new LispValueNotANumberException(arg);
			}
		});
		lisp.Register(new LispPrimitive1("FIND-VIEW-BY-ID") {
			@Override
			protected LispValue Execute(LispValue arg) throws CompilerException {
				if (arg instanceof LispNumber) {
					int id = (int)((LispNumber)arg).getLongValue();
					return new LispView("view-" + (LispNumber)arg, activity.findViewById(id));
				}
				throw new LispValueNotANumberException(arg);
			}
		});
		lisp.Register(new LispPrimitive2("SET-VIEW-BACKGROUND-COLOR") {
			@Override
			protected LispValue Execute(LispValue arg1, LispValue arg2) throws CompilerException {
				if (!(arg2 instanceof LispNumber))
					throw new LispValueNotANumberException(arg2);
				if (!(arg1 instanceof LispSymbol))
					throw new LispValueNotASymbolException(arg1);
				
				final LispView lview = (LispView)arg1;
				final int color = (int)((LispNumber)arg2).getLongValue();
				
				activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						lview.view.setBackgroundColor(0xFF000000 + (color & 0x00FFFFFF));
						lview.view.invalidate();
					}});
				return NIL;
			}
		});
	}
}
class LispView extends StandardLispSymbol
{
	View view;
	public LispView(String symbolName, View view) {
		super(symbolName);
		
		this.view = view;
	}
}