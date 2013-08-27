package com.liwenhaosuper.loveroid;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;

public class LoveroidPreferenceManager {
	private static LoveroidPreferenceManager instance;
	private final Context ctx;
	private final Map<String, SharedPreferences> mSp;
	
	private LoveroidPreferenceManager(Context paramContext){
		this.ctx = paramContext;
		this.mSp = new HashMap<String, SharedPreferences>();
	}
	public static LoveroidPreferenceManager getInstance(Context ctx){
		if(instance==null){
			instance = new LoveroidPreferenceManager(ctx);
		}
		return instance;
	}
	public SharedPreferences getDefaultPreference(){
		return getPreference("default");
	}
	public SharedPreferences getPreference(String nm){
		SharedPreferences sp = (SharedPreferences)mSp.get(nm);
		if(sp==null){
			sp = new LoveroidSharedPreferences(ctx,nm);
			mSp.put(nm, sp);
		}
		return sp;
	}
}
