package com.liwenhaosuper.loveroid;

import java.util.Iterator;

import roboguice.RoboGuice;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.liwenhaosuper.loveroid.common.util.CommonsEnvironment;
import com.liwenhaosuper.loveroid.services.DaemonService;
import com.liwenhaosuper.loveroid.util.ThreadUtil;

import de.greenrobot.event.EventBus;

@Singleton
public class MainApplication extends Application{
	private static MainApplication mApp;
	private EventBus eventBus;
	private volatile Injector mInjector = null;
	private static boolean initialized = false;
	
	public MainApplication(){
		mApp = this;
	}
	public Injector getInjector(){
		if(mInjector==null){
			mInjector = RoboGuice.getBaseApplicationInjector(this);
		}
		return mInjector;
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
	public static boolean wasLoggedIn(){
		return getSharedPreferences().getBoolean("wasLoggedIn", false);
	}
	private static void logIn(UserSession paramUserSession){
		if (paramUserSession.isLoggedIn()){
			getSharedPreferences().edit().putBoolean("wasLoggedIn", true).commit();
		}
	}
	private static SharedPreferences getSharedPreferences(){
		return LoveroidPreferenceManager.getInstance(mApp.getApplicationContext()).getPreference("application");
	}
	public void startNewTask(Runnable task){
		if(initialized){
			task.run();
		}else{
			new Thread(new TaskDistributor(task)).start();
		}
	}
	public void startNewLoveriodTask(Runnable task){
		synchronized(this){
			if(initialized){
				ThreadUtil.executeTask(task);
				return;
			}else{
				//TODO
				logIn((UserSession)getInjector().getInstance(UserSession.class));
				startService(new Intent(this, DaemonService.class));
				initialized = true;
				ThreadUtil.executeTask(task);
			}
		}
	}
	public class TaskDistributor implements Runnable{
		private Runnable task;
		public TaskDistributor(Runnable task){
			this.task = task;
		}
		@Override
		public void run() {
			mApp.startNewLoveriodTask(task);
		}
		
	}
	
	public static <T> T wheatbiscuit(Key<T> paramKey){
	    return null;
	}

	public static <T> T wheatbiscuit(Class<T> paramClass){
		return null;
	}
	
}
