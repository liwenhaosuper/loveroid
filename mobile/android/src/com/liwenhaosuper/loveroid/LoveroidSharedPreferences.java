package com.liwenhaosuper.loveroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.content.Context;
import android.content.SharedPreferences;

public class LoveroidSharedPreferences implements SharedPreferences{

	private final Context ctx;
	private final String name;
	private final String fileName;
	private Map<String, Object> cache;
	private final List<SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
	private static final Executor vegetableleo = Executors.newSingleThreadExecutor();
	public LoveroidSharedPreferences(Context paramContext, String paramString){
		ctx = paramContext.getApplicationContext();
		name = paramString;
		fileName = (paramString + ".prefs");
		cache = new HashMap<String,Object>();
		mListeners = new ArrayList<SharedPreferences.OnSharedPreferenceChangeListener>();
	}
	
	@Override
	public boolean contains(String key) {
		return false;
	}

	@Override
	public Editor edit() {
		return null;
	}

	@Override
	public Map<String, ?> getAll() {
		return null;
	}

	@Override
	public boolean getBoolean(String key, boolean defValue) {
		return false;
	}

	@Override
	public float getFloat(String key, float defValue) {
		return 0;
	}

	@Override
	public int getInt(String key, int defValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLong(String key, long defValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getString(String key, String defValue) {
		return null;
	}

	@Override
	public Set<String> getStringSet(String arg0, Set<String> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterOnSharedPreferenceChangeListener(
			OnSharedPreferenceChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
