package com.liwenhaosuper.loveroid.activities;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.liwenhaosuper.loveroid.R;

public abstract class NuxBaseActivity extends BaseFragmentActivity{

	private ActionBar mBar;
	private String title;
	public void onCreate(Bundle paramBundle){
		super.onCreate(paramBundle);
		mBar = getSupportActionBar();
		mBar.setNavigationMode(0);
		mBar.setDisplayOptions(10);//FIXME: What 10 mean?
		mBar.setIcon(R.drawable.actionbar_up_button);
	}
	protected abstract void ItemSelected();

	public boolean onOptionsItemSelected(MenuItem paramMenuItem){
		switch (paramMenuItem.getItemId()){
		case R.id.nux_next:
			ItemSelected();
			return true;
		}
		return false;
	}
	public boolean onCreateOptionsMenu(Menu paramMenu){
		getSupportMenuInflater().inflate(R.menu.nux_menu, paramMenu);
		MenuItem localMenuItem = paramMenu.findItem(R.id.nux_next);
		if(title!=null){
			localMenuItem.setVisible(true);
			localMenuItem.setTitle(this.title);
		}else{
			localMenuItem.setVisible(false);
		}
		return true;
	}
	public void setActionBarTitle(int paramInt){
		if (paramInt <= 0){
			mBar.setDisplayShowTitleEnabled(false);
		}else{
			mBar.setDisplayShowTitleEnabled(true);
			mBar.setTitle(paramInt);
		}
	}
	public void setActionBarNext(int paramInt, Object[] paramArrayOfObject){
		if(paramInt <=0){
			return;
		}else{
			title = getString(paramInt, paramArrayOfObject);
		}
		invalidateOptionsMenu();
	}
	public void setActionBarNext(String paramString){
		title = paramString;
		invalidateOptionsMenu();
	}
}
