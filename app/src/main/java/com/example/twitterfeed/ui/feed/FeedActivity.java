package com.example.twitterfeed.ui.feed;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.example.twitterfeed.R;
import com.example.twitterfeed.ui.base.BaseActivity;
import com.example.twitterfeed.utils.PermissionUtility;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class FeedActivity extends BaseActivity implements FeedMvpView {

    @Inject
    FeedMvpPresenter<FeedMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(FeedActivity.this);
        mPresenter.displayRunTimePermissions();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter.isPermissionDeniedByUser() && !mPresenter.isPermissionGranted()) {
            getSnackBar();
        }
    }

    @Override
    public String getPermissionString() {
        return Manifest.permission.ACCESS_COARSE_LOCATION;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void getSnackBar() {
        Snackbar
                .make(findViewById(R.id.feed_activity), getText(R.string.snackbar_text), Snackbar.LENGTH_LONG)
                .setActionTextColor(getResources().getColor(R.color.colorWhite, null))
                .setAction(getText(R.string.snackbar_button_text), view -> goToPermissionSettingsScreen()).show();
    }

    public void goToPermissionSettingsScreen() {
        startActivity(mPresenter.onSettingsViewClicked());
    }

    @Override
    public String getSettingsIntentScheme() {
        return getResources().getString(R.string.settings_intent_scheme);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
