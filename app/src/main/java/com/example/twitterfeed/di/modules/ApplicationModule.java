package com.example.twitterfeed.di.modules;

import android.app.Application;

import com.example.twitterfeed.network.ApiClient;
import com.example.twitterfeed.network.AppApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    public Application mApplication;

    Application provideContext() {
        return mApplication;
    }

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    ApiClient provideApiClient() {
        return new AppApiClient();
    }

}
