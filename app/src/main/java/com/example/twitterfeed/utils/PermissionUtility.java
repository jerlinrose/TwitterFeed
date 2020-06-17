package com.example.twitterfeed.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

public class PermissionUtility {

    public int getPermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission);
    }

    public int getGrantedPermission() {
        return PackageManager.PERMISSION_GRANTED;
    }
}
