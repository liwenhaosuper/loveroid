package com.liwenhaosuper.loveroid;

import com.google.inject.AbstractModule;
import com.liwenhaosuper.loveroid.tasks.NoNetworkTaskExecutor;
import com.liwenhaosuper.loveroid.tasks.UITaskExecutor;

import de.greenrobot.event.EventBus;

public class ApplicationConfig extends AbstractModule{

	@Override
	protected void configure() {
		bind(UITaskExecutor.class).toInstance(UITaskExecutor.getInstance());
		bind(NoNetworkTaskExecutor.class).toInstance(NoNetworkTaskExecutor.getInstance());
		bind(EventBus.class).toInstance(EventBus.getDefault());
	}
	
}