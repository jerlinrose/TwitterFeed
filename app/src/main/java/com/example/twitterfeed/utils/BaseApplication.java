package com.example.twitterfeed.utils;

import android.app.Application;

import com.example.twitterfeed.di.components.ApplicationComponent;
import com.example.twitterfeed.di.components.DaggerApplicationComponent;
import com.example.twitterfeed.di.modules.ApplicationModule;

public class BaseApplication extends Application {
    public ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
}
}
