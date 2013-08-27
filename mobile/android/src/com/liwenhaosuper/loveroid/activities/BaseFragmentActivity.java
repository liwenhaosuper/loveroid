package com.liwenhaosuper.loveroid.activities;

import android.location.Location;
import android.os.Bundle;
import android.view.KeyEvent;

import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;
import com.liwenhaosuper.loveroid.util.ActivityHelper;

public abstract class BaseFragmentActivity extends RoboSherlockFragmentActivity
	implements ActivityHelper.HelperGetter, ActivityHelper.OnLocationChangedListener{

	private ActivityHelper mActivityHelper;
	  
	public void onCreate(Bundle paramBundle){
		mActivityHelper = new ActivityHelper(this, this);
		super.onCreate(paramBundle);
		mActivityHelper.onCreate(paramBundle);
	}
	protected void onDestroy(){
		mActivityHelper.onDestroy();
	    super.onDestroy();
	}
	public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent){
		boolean res = mActivityHelper.onKeyUp(paramInt, paramKeyEvent);
		if(!res){
			res = super.onKeyUp(paramInt, paramKeyEvent);
		}
		return res;
	}
	public void onLocationChanged(Location paramLocation){
	}
	public ActivityHelper getHelper(){
	    return mActivityHelper;
	}
	  
	  
}
