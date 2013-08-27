package com.liwenhaosuper.loveroid.activities;

import roboguice.inject.InjectView;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.liwenhaosuper.loveroid.R;
import com.liwenhaosuper.loveroid.util.InternalUri;

public class NuxWelcomeSplashActivity extends NuxSignUpActivity{



	@InjectView(R.id.nux_welcome_view_pager)
	ViewPager vp;

	@Override
	public boolean onInternalUriEvent(InternalUri paramInternalUri) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onCreate(Bundle paramBundle){
		super.onCreate(paramBundle);
		setContentView(R.layout.nux_welcome_splash_activity);
	}
	
	@Override
	protected void resume() {
		// TODO Auto-generated method stub
		
	}
	
	public void onResume(){
		super.onResume();
		//TODO
	}
	@Override
	protected void ItemSelected() {
		// TODO Auto-generated method stub
		
	}
	protected void onSaveInstanceState(Bundle paramBundle){
		super.onSaveInstanceState(paramBundle);
		paramBundle.putInt("pager_pane_num", this.vp.getCurrentItem());
	}
}
