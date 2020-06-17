package com.example.twitterfeed.ui.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.twitterfeed.di.components.ActivityComponent;
import com.example.twitterfeed.di.modules.ActivityModule;
import com.example.twitterfeed.utils.BaseApplication;
import com.example.twitterfeed.di.components.DaggerActivityComponent;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements MvpView {
    private ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((BaseApplication) getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
    }
}

