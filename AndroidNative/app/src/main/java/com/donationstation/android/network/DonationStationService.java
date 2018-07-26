package com.donationstation.android.network;

import com.donationstation.android.models.Event;
import com.donationstation.android.models.MyItem;
import com.donationstation.android.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public interface DonationStationService {

    @POST("userspost")
    Call<Void> sendUserRegistration(@Body User user);

    @POST("PushNotification")
    Call<Void> sendNotificationToken(@Body User user);

    @GET("events")
    Call<List<Event>> getEvents();

    @GET("items")
    Call<List<MyItem>> getMyItems(@Query("userId") String userId);
}
