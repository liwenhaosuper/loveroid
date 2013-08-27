package com.liwenhaosuper.loveroid.tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import com.liwenhaosuper.loveroid.util.ThreadUtil;

public abstract class BaseBackgroundTask<T> extends BaseBackgroundRunnableCallbacks<T>
implements Callable<T>
{
private final BackgroundRunnable<T> ahv = new BackgroundRunnable(this, this);

private final Runnable ahw = new TaskRunner();

public class TaskRunner implements Runnable{
	@Override
	public void run() {
		// TODO
		
	}
	
}
public void wheatbiscuit(Executor paramExecutor)
{
	//TODO
}
}
