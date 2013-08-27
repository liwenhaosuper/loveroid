package com.liwenhaosuper.loveroid.tasks;

import android.util.Log;

import com.liwenhaosuper.loveroid.MainApplication;
import com.liwenhaosuper.loveroid.events.user.UserLoggedOutEvent;

	public abstract class BaseBackgroundRunnableCallbacks<T>
	  implements BackgroundRunnableCallbacks<T>
	{
	  private boolean aht;
	  private final boolean ahu;

	  public BaseBackgroundRunnableCallbacks()
	  {
	    this(true);
	  }

	  public BaseBackgroundRunnableCallbacks(boolean paramBoolean)
	  {
	    this.ahu = paramBoolean;
	  }

	  public boolean dp()
	  {
	    return true;
	  }

	  public boolean eQ()
	  {
	    return this.aht;
	  }

	  void init()
	  {
	    this.aht = false;
	    if (this.ahu)
	      MainApplication.getInstance().getEventBus().register(this, UserLoggedOutEvent.class, new Class[0]);
	  }

	  public void error(Throwable paramThrowable)
	  {
	    Log.d("BaseBackgroundRunningCallback","Exception caught during background processing:"+paramThrowable.getMessage());
	  }

	  public void onEventMainThread(UserLoggedOutEvent paramUserLoggedOutEvent)
	  {
	    this.aht = true;
	  }

	  public void onFinally()
	  {
	  }

	  public void onPreExecute()
	  {
	  }

	  void release()
	  {
	    if (this.ahu)
	      MainApplication.getInstance().getEventBus().unregister(this);
	  }
	}
	
