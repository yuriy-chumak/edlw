package com.wata.framework.type;

import org.jatha.dynatype.StandardLispSymbol;

import android.app.Activity;

public class LispActivity extends StandardLispSymbol
{
	Activity activity;
	public LispActivity(String symbolName, Activity activity) {
		super(symbolName);
		
		this.activity = activity;
	}
	
	public Activity getActivity()
	{
		return activity;
	}
}