package com.example.twitterfeed.di.modules;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.twitterfeed.di.PerActivity;
import com.example.twitterfeed.ui.feed.FeedActivity;
import com.example.twitterfeed.ui.feed.FeedMvpPresenter;
import com.example.twitterfeed.ui.feed.FeedMvpView;
import com.example.twitterfeed.ui.feed.FeedPresenter;
import com.example.twitterfeed.utils.PermissionUtility;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    public AppCompatActivity mAppCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        mAppCompatActivity = appCompatActivity;
    }

    public Activity provideContext() {
        return mAppCompatActivity;
    }

    @Provides
    @PerActivity
    FeedMvpPresenter<FeedMvpView> providePresenter(FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @PerActivity
    @Provides
    PermissionUtility providePermissionUtility() {
        return new PermissionUtility();
    }
}
