package com.donationstation.android.network;

import android.annotation.SuppressLint;
import android.content.Context;

import com.donationstation.android.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class RetrofitClient {
    @SuppressLint("StaticFieldLeak")
    private static RetrofitClient instance;

    private Context context;
    private DonationStationService donationStationService;

    private RetrofitClient(Context context) {
        this.context = context;

        Retrofit retrofit = createRetrofit();
        donationStationService = retrofit.create(DonationStationService.class);
    }

    /**
     * Creates singleton instance of RetrofitClient
     *
     * @param context android application context
     * @return instance of RetrofitClient
     */
    public static synchronized RetrofitClient getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitClient(context);
        }

        return instance;
    }

    public DonationStationService getDonationStationService() {
        return donationStationService;
    }

    /**
     * It configure Retrofit instance using Builder method
     *
     * @return instance of Retrofit
     */
    private Retrofit createRetrofit() {
        //Configuring Retrofit instance with OkHttpClient, GsonConverterFactory and base url
        return new Retrofit.Builder()
                .baseUrl(Constants.CONFIG_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //To parse network response body to POJO model classes
                .build();
    }
}
