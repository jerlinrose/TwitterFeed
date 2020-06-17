package com.example.twitterfeed.ui.feed;

import android.content.Intent;

import com.example.twitterfeed.ui.base.MvpPresenter;
import com.example.twitterfeed.ui.base.MvpView;

public interface FeedMvpPresenter<V extends FeedMvpView> extends MvpPresenter<V> {
    void displayRunTimePermissions();

    Intent onSettingsViewClicked();

    boolean isPermissionDeniedByUser();

    boolean isPermissionGranted();
}
