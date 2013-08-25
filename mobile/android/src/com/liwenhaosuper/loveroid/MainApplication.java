package com.liwenhaosuper.loveroid;

import java.util.Iterator;

import android.app.ActivityManager;
import android.app.Application;

import com.google.inject.Key;
import com.google.inject.Singleton;
import com.liwenhaosuper.loveroid.common.util.CommonsEnvironment;

import de.greenrobot.event.EventBus;

@Singleton
public class MainApplication extends Application{
	private static MainApplication mApp;
	private EventBus eventBus;
	
	public MainApplication(){
		mApp = this;
	}
	public static MainApplication getInstance(){
		return mApp;
	}
	public EventBus getEventBus(){
		return eventBus;
	}
	public boolean isSelfRunning(){
		ActivityManager localActivityManager = (ActivityManager)getSystemService("activity");
		if(localActivityManager==null){
			throw new RuntimeException("cannot grab activity manager :/");
		}
		Iterator localIterator = localActivityManager.getRunningAppProcesses().iterator();
	    while (true){
	    	if (localIterator.hasNext()){
	    		ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
	            if (!"com.liwenhaosuper.loveroid".equals(localRunningAppProcessInfo.processName))
	              continue;
	            if (android.os.Process.myPid() != localRunningAppProcessInfo.pid)
	              break;
	            return true;
	          }
	      }
		return false;
	}
	@Override
	public void onCreate(){
		super.onCreate();
		this.eventBus = EventBus.getDefault();
		CommonsEnvironment.configure(this);
	}
	
	public static <T> T wheatbiscuit(Key<T> paramKey){
	    return null;
	}

	public static <T> T wheatbiscuit(Class<T> paramClass){
		return null;
	}
	
}
