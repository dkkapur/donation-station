package com.donationstation.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class SharedPreferencesUtils {

    private static final String PREFERENCE_IS_USER_REGISTERED = "is_user_registered";
    private static final String PREFERENCE_USER_ID = "user_id";


    private static SharedPreferencesUtils instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

    private SharedPreferencesUtils(Context context) {
        this.sharedPreferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
        this.gson = new Gson();
    }

    public static synchronized void createInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesUtils(context);
        }
    }

    public static SharedPreferencesUtils getInstance() {
        return instance;
    }

    private String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    private void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    private boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    private void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean isUserRegistered() {
        return getBoolean(PREFERENCE_IS_USER_REGISTERED);
    }

    public void setIsUserRegistered(boolean isUserRegistered) {
        putBoolean(PREFERENCE_IS_USER_REGISTERED, isUserRegistered);
    }

    public String getUserId() {
        return getString(PREFERENCE_USER_ID);
    }

    public void setUserId(String user) {
        putString(PREFERENCE_USER_ID, user);
    }
}
