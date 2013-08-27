package com.liwenhaosuper.loveroid.activities;

import java.util.concurrent.Executor;

import roboguice.activity.RoboActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

import com.liwenhaosuper.loveroid.util.ActivityHelper;
import com.liwenhaosuper.loveroid.util.InternalUri;

public abstract class BaseActivity extends RoboActivity
	implements ActivityHelper.HelperGetter, ActivityHelper.OnLocationChangedListener{

	private ActivityHelper mHelper;
	
	public void dispatchClick(View paramView){
		
	}
	public void finish(){
		this.mHelper.finish();
	    super.finish();
	}
	public Executor getTaskExecutor(){
	    return this.mHelper.getTaskExecutor();
	}
	public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent){
	    super.onActivityResult(paramInt1, paramInt2, paramIntent);
	    this.mHelper.onActivityResult(paramInt1, paramInt2, paramIntent);
	}
	public void onConfigurationChanged(Configuration paramConfiguration){
	    super.onConfigurationChanged(paramConfiguration);
	    this.mHelper.onConfigurationChanged(paramConfiguration);
	}
	protected void onCreate(Bundle paramBundle){
		mHelper = new ActivityHelper(this, this);
		super.onCreate(paramBundle);
		mHelper.onCreate(paramBundle);
	}
	public boolean onCreateOptionsMenu(Menu paramMenu){
		boolean bool = super.onCreateOptionsMenu(paramMenu);
		//TODO
		return bool;
	}
	protected void onDestroy(){
	    this.mHelper.onDestroy();
	    super.onDestroy();
	}
	public boolean onInternalUriEvent(InternalUri paramInternalUri){
	    return false;
	}
	public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent){
		//TODO
		return false;
	}
}
