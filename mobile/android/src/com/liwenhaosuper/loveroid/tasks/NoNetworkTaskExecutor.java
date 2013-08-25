package com.liwenhaosuper.loveroid.tasks;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NoNetworkTaskExecutor implements ExecutorService{
	 private static NoNetworkTaskExecutor mInstance;
	 ExecutorService es;
	 
	 private NoNetworkTaskExecutor(ExecutorService paramExecutorService){
		 this.es = paramExecutorService;
	 }
	 public static NoNetworkTaskExecutor getInstance(){
		 if (mInstance == null){
			 mInstance = new NoNetworkTaskExecutor(Executors.newFixedThreadPool(1));
		 }
		 return mInstance;
	  }

	  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
	  {
	    try {
			return this.es.awaitTermination(paramLong, paramTimeUnit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	  }

	  public void execute(Runnable paramRunnable)
	  {
	      this.es.execute(paramRunnable);
	  }

	  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
	  {
	    try {
			return this.es.invokeAll(paramCollection);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	  }

	  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
	  {
		    try {
				return this.es.invokeAll(paramCollection, paramLong, paramTimeUnit);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
	  }

	  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
	  {
	    try {
			return this.es.invokeAny(paramCollection);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	  }

	  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
	  {
	    try {
			return this.es.invokeAny(paramCollection, paramLong, paramTimeUnit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return null;
	  }

	  public boolean isShutdown()
	  {
	    return this.es.isShutdown();
	  }

	  public boolean isTerminated()
	  {
	    return this.es.isTerminated();
	  }

	  public void shutdown()
	  {
	    this.es.shutdown();
	  }

	  public List<Runnable> shutdownNow()
	  {
	    return this.es.shutdownNow();
	  }

	  public Future<?> submit(Runnable paramRunnable)
	  {
	    return this.es.submit(paramRunnable);
	  }

	  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
	  {
	    return this.es.submit(paramRunnable, paramT);
	  }

	  public <T> Future<T> submit(Callable<T> paramCallable)
	  {
	    return this.es.submit(paramCallable);
	  }}
