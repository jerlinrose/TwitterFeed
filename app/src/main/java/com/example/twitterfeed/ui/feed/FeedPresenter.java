package com.example.twitterfeed.ui.feed;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import com.example.twitterfeed.ui.base.BasePresenter;
import com.example.twitterfeed.utils.PermissionUtility;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

import javax.inject.Inject;

public class FeedPresenter<V extends FeedMvpView> extends BasePresenter<V> implements FeedMvpPresenter<V> {

    public boolean isPermissionDenied = false;

    @Inject
    public FeedPresenter() {
    }

    @Inject
    PermissionUtility permissionUtility;

    @Override
    public void displayRunTimePermissions() {
        Dexter.withContext(getMvpView().getContext())
                .withPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        isPermissionDenied = false;
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        isPermissionDenied = true;

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();

    }

    public boolean isPermissionDeniedByUser() {
        return isPermissionDenied;
    }

    @Override
    public boolean isPermissionGranted() {
       return  permissionUtility.getPermission(getMvpView().getContext(), getMvpView().getPermissionString()) == permissionUtility.getGrantedPermission();
    }

    @Override
    public Intent onSettingsViewClicked() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts(getMvpView().getSettingsIntentScheme(), getMvpView().getContext().getPackageName(), null);
        intent.setData(uri);
        return intent;
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
