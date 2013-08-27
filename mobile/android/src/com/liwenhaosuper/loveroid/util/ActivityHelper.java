package com.liwenhaosuper.loveroid.util;

import java.util.concurrent.Executor;

import roboguice.RoboGuice;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.google.inject.Inject;
import com.liwenhaosuper.loveroid.activities.BaseActivity;
import com.liwenhaosuper.loveroid.tasks.UITaskExecutor;

import de.greenrobot.event.EventBus;

public class ActivityHelper {
	private static String TAG = "ActivityHelper";
	private final Activity activity;
	
	public ActivityHelper(Activity paramActivity, ActivityHelper.OnLocationChangedListener paramOnLocationChangedListener){
		this.activity = paramActivity;
		RoboGuice.getInjector(paramActivity).injectMembers(this);
	}
	public abstract interface OnLocationChangedListener{
	  public abstract void onLocationChanged(Location paramLocation);
	}
	
	@Inject
	private EventBus eventBus;
	@Inject
	private NotificationManager notificationManager;
	@Inject
	private UITaskExecutor uiExecutor;
	public static Activity getActivityFromContext(Context ctx){
		Context localCtx = ctx;
		if((ctx instanceof ContextWrapper) && !(ctx instanceof Activity)){
			localCtx = ((ContextWrapper)ctx).getBaseContext();
		}
		if((localCtx instanceof Activity)){
			return (Activity)localCtx;
		}
		Log.d(TAG,"getActivityFromContext: not an activity instance");
		return null;
	}
	public static ActivityHelper getActivityHelperFromContext(Context ctx){
		//TODO:
		Activity localActivity = getActivityFromContext(ctx);
		if(localActivity!=null){
			if(localActivity instanceof  BaseActivity){
				return ((BaseActivity)localActivity).getHelper();
			}
		}
		return null;
	}
	public EventBus getEventBus(){
		return this.eventBus;
	}
	public Executor getTaskExecutor(){
		return uiExecutor;
	}
	public void onCreate(Bundle paramBundle){
		//TODO
	}
	public void onDestroy(){
		//TODO
	}
	public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent){
		//TODO
		return false;
	}
	public abstract interface HelperGetter{
		public abstract ActivityHelper getHelper();
		public abstract boolean onInternalUriEvent(InternalUri paramInternalUri);
	}
	public void finish() {
		//TODO
		
	}
	public void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		// TODO 
		
	}
	public void onConfigurationChanged(Configuration paramConfiguration) {
		// TODO Auto-generated method stub
		
	}
	public void finishAllActivities() {
		finishAllActivities(activity);
	}
	public static void finishAllActivities(Context paramContext){
	    Intent localIntent = new Intent();
	    localIntent.setAction("ACTION_FINISH_ALL_ACTIVITIES");
	    paramContext.sendBroadcast(localIntent);
	  }
}
