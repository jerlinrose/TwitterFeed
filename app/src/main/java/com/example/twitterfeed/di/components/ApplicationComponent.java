package com.example.twitterfeed.di.components;

import com.example.twitterfeed.di.modules.ApplicationModule;
import com.example.twitterfeed.network.ApiClient;
import com.example.twitterfeed.utils.BaseApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseApplication baseApplication);

    ApiClient getApiClient();
}
