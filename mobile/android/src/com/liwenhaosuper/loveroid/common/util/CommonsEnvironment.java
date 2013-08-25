package com.liwenhaosuper.loveroid.common.util;

import android.app.Application;
import android.content.Context;

public class CommonsEnvironment {
	  private static Application application;

	  public static void configure(Application paramApplication){
		  application = paramApplication;
	  }

	  public static Context getApplicationContext(){
		  return application.getApplicationContext();
	  }
}
