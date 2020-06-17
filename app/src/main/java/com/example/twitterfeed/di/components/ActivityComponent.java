package com.example.twitterfeed.di.components;

import com.example.twitterfeed.di.PerActivity;
import com.example.twitterfeed.di.modules.ActivityModule;
import com.example.twitterfeed.ui.feed.FeedActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(FeedActivity feedActivity);
}
