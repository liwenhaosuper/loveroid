package com.liwenhaosuper.loveroid;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.inject.Singleton;

@Singleton
public class UserSession {
	private static final String TOKEN = "token";
	private static final String USER_ID = "userId";
	private static final String VERSION = "version";
	
	private final Context context = MainApplication.getInstance().getApplicationContext();
	
	public String getUsername(){
		//TODO
		return null;
	}
	public boolean shouldRunNux(){
		return getPreference().getBoolean("runNux", false);
	}
	public boolean isPostSignUp(){
		return getPreference().getBoolean("isPerformingPostSignUpNux", false);		
	}
	public String getToken(){
		//TODO
		return null;
	}
	public String getUserId(){
		//TODO
		return null;
	}
	private SharedPreferences getPreference(){
		return LoveroidPreferenceManager.getInstance(context).getDefaultPreference();
	}
	private boolean getBooleanValue(String str){
		return getPreference().getBoolean(str,false);
	}
	private void setBooleanValue(String str,boolean val){
		getPreference().edit().putBoolean(str, val);
	}
	
	public boolean isLoggedIn(){
		if ((getUsername() != null) && (getToken() != null) && (getUserId() != null)){
			return true;
		}
		return false;
	}
}
