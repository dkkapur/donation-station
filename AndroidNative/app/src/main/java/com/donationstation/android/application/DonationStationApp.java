package com.donationstation.android.application;

import android.app.Application;

import com.donationstation.android.utils.JsonUtils;
import com.donationstation.android.utils.SharedPreferencesUtils;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class DonationStationApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtils.createInstance(this);

        JsonUtils.getItems();
    }
}
