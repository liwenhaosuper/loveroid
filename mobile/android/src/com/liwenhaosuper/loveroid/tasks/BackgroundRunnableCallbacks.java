package com.liwenhaosuper.loveroid.tasks;

public abstract interface BackgroundRunnableCallbacks<T>
{
  public abstract boolean dp();

  public abstract boolean eQ();

  public abstract void noodles(Throwable paramThrowable);

  public abstract void onFinally();

  public abstract void onPreExecute();

  public abstract void onSuccess(T paramT);
}