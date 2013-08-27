package com.liwenhaosuper.loveroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.inject.Inject;
import com.liwenhaosuper.loveroid.MainApplication;
import com.liwenhaosuper.loveroid.R;
import com.liwenhaosuper.loveroid.UserSession;
import com.liwenhaosuper.loveroid.tasks.BackgroundTask;
import com.liwenhaosuper.loveroid.util.InternalUri;

public class EntryPointActivity extends BaseFragmentActivity {

	private boolean isRestarted = false;
	private boolean isActivityResult = false;
	

	@Inject
	private UserSession userSession;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red_linen);
        enterMain();
    }
    private void enterMain(){
    	MainApplication.getInstance().startNewTask(new MainRunner());
    }
    public class MainRunner implements Runnable{

		@Override
		public void run() {
			startMain();
		}
    	
    }
    private void startMain(){
    	Intent localIntent = getIntent();
    	if(localIntent==null){
    		Log.d("EntryPointActivity","hacker??????");
    		return;
    	}
    	//TODO
    	if ((0x100000 & localIntent.getFlags()) == 0){
    		if (!this.userSession.isLoggedIn()){
    			Log.d("EntryPointActivity","not log in");
    			finish();
    		}
    		if(!this.userSession.shouldRunNux()){
    			Log.d("EntryPointActivity","not run nux");
    			finish();
    		}
    		if(!userSession.isPostSignUp()){
    			Log.d("EntryPointActivity","not post sign up");
    			finish();
    		}
    		getHelper().finishAllActivities();
    		//FIXME
    		new StartPostNuxTask(this, 6).execute();
    	}else{
    		return;
    	}
    }
    //FIXME:
    public class Features{
    }
    public class StartPostNuxTask  extends BackgroundTask<Features>{

    	public StartPostNuxTask(Activity paramActivity, int paramInt){
    		//TODO
    	}
		@Override
		public Features call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void noodles(Throwable paramThrowable) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Features paramT) {
			// TODO Auto-generated method stub
			
		}
		public void execute(){
			
		}
    	
    }
    public void onRestart(){
    	super.onRestart();
    	isRestarted = true;
    }
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent){
    	isActivityResult = true;
    	super.onActivityResult(paramInt1, paramInt2, paramIntent);
    	Log.d("EntryPointActivity","onActivityResult: TODO!!!");
    }
    public void onResume(){
    	super.onResume();
    	if(this.isRestarted && !this.isActivityResult && !this.isFinishing()){
    		Log.d("EntryPointActivity","Returned to root activity without a result. Finishing ...");
    		finish();
    	}
    }
	@Override
	public boolean onInternalUriEvent(InternalUri paramInternalUri) {
		// TODO Auto-generated method stub
		return false;
	}
}