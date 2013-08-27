package com.liwenhaosuper.loveroid.tasks;

import java.util.concurrent.Callable;

public class BackgroundRunnable<T> implements Runnable{

	  private final Callable<T> ahh;
	  private final BackgroundRunnableCallbacks<T> ahi;

	  public BackgroundRunnable(Callable<T> paramCallable, BackgroundRunnableCallbacks<T> paramBackgroundRunnableCallbacks)
	  {
	    this.ahh = paramCallable;
	    this.ahi = paramBackgroundRunnableCallbacks;
	  }
	@Override
	public void run() {
		//TODO
	}

}
