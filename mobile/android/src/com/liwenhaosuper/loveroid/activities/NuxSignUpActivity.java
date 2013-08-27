package com.liwenhaosuper.loveroid.activities;

import javax.annotation.Nullable;

import android.content.Intent;

import com.liwenhaosuper.loveroid.R;

public abstract class NuxSignUpActivity extends NuxBaseActivity{

	public void onBackPressed(){
		super.onBackPressed();
		overridePendingTransition(R.anim.nux_slide_in_left, R.anim.nux_slide_out_right);
	}
	protected abstract void resume();
	public void onResume(){
		super.onResume();
		resume();
	}
	protected void startActivity(@Nullable Class<? extends NuxSignUpActivity> paramClass){
		if (paramClass != null){
			startActivityForResult(new Intent(this, paramClass), 10);
			overridePendingTransition(R.anim.nux_slide_in_right, R.anim.nux_slide_out_left);
		}
	}
	public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent){
		super.onActivityResult(paramInt1, paramInt2, paramIntent);
		switch (paramInt1){
		case 10:
			if (paramInt2 == -1){
				setResult(-1, paramIntent);
				finish();
			}
		}
	}
}
