package com.example.twitterfeed.ui.feed;

import android.content.Context;

import com.example.twitterfeed.ui.base.MvpView;

public interface FeedMvpView extends MvpView {

    Context getContext();

    void getSnackBar();

    String getSettingsIntentScheme();

    String getPermissionString();
}
