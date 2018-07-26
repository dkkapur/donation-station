package com.donationstation.android.utils;

import com.donationstation.android.models.Event;
import com.donationstation.android.models.MyItem;
import com.donationstation.android.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilkumarlakkad on 7/25/18.
 */

public class JsonUtils {
    public static List<MyItem> items = new ArrayList<>();

    private static String events = "[\n" +
            "   {\n" +
            "      \"host\":\"deeptanshuk@gmail.com\",\n" +
            "      \"type\":\"pickup\",\n" +
            "      \"name\":\"USS Enterprise wants to dry off!\",\n" +
            "      \"address\":\"Pike Pl, Seattle, WA 98101, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.3509386,47.6215512]}\",\n" +
            "      \"starttime\":\"26th July 2018, 10:00 AM\",\n" +
            "      \"endtime\":\"26th July 2018, 10:30 AM\",\n" +
            "      \"items\":[\n" +
            "         \"Towels\"\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"host\":\"deeptanshuk@gmail.com\",\n" +
            "      \"type\":\"dropoff\",\n" +
            "      \"name\":\"Food Drive for Tatooine\",\n" +
            "      \"address\":\"Armory, Seattle, WA 98109, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.3509386,47.6215512]}\",\n" +
            "      \"starttime\":\"26th July 2018, 1:00 PM\",\n" +
            "      \"endtime\":\"26th July 2018, 3:00 PM\",\n" +
            "      \"items\":[\n" +
            "         \"canned food\"\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"host\":\"deeptanshuk@gmail.com\",\n" +
            "      \"type\":\"pickup\",\n" +
            "      \"name\":\"Extra warmth for Pluto!\",\n" +
            "      \"address\":\"Pike Pl, Seattle, WA 98101, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.3419743,47.60955189999999]}\",\n" +
            "      \"starttime\":\"25th July 2018, 6:00 PM\",\n" +
            "      \"endtime\":\"25th July 2018, 10:00 PM\",\n" +
            "      \"items\":[\n" +
            "         \"clothes\",\n" +
            "         \"blanket\",\n" +
            "         \"shoes\",\n" +
            "         \"towels\"\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"host\":\"deeptanshuk@gmail.com\",\n" +
            "      \"type\":\"dropoff\",\n" +
            "      \"name\":\"Wakanda needs canned soup!\",\n" +
            "      \"address\":\"Amazon.com Blvd, Shepherdsville, KY 40165, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-85.68607789999999,37.9828326]}\",\n" +
            "      \"starttime\":\"27th July 2018, 10:00 AM\",\n" +
            "      \"endtime\":\"27th July 2018, 6:00 PM\",\n" +
            "      \"items\":[\n" +
            "         \"towels\"\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"host\":\"deeptanshuk@gmail.com\",\n" +
            "      \"type\":\"volunteer\",\n" +
            "      \"name\":\"Teach Computer Science at Winterfell\",\n" +
            "      \"address\":\"Pike Pl, Seattle, WA 98101, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.3419743,47.60955189999999]}\",\n" +
            "      \"starttime\":\"24th July 2018, 3:00 PM\",\n" +
            "      \"endtime\":\"24th July 2018, 4:00 PM\",\n" +
            "      \"items\":[\n" +
            "\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"host\":\"deeptanshuk@gmail.com\",\n" +
            "      \"type\":\"dropoff\",\n" +
            "      \"name\":\"Help disaster relief victims of the plague\",\n" +
            "      \"address\":\"Pike St, Seattle, WA, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.33248170000002,47.6119612]}\",\n" +
            "      \"starttime\":\"1st August 2018, 9:00 AM\",\n" +
            "      \"endtime\":\"1st August 2018, 4:00 PM\",\n" +
            "      \"items\":[\n" +
            "         \"clothes\",\n" +
            "         \"blanket\",\n" +
            "         \"shoes\",\n" +
            "         \"canned food\",\n" +
            "         \"towels\"\n" +
            "      ]\n" +
            "   }\n" +
            "]";

    public static List<Event> getEvents() {
        Gson gson = new Gson();

        Type founderListType = new TypeToken<ArrayList<Event>>() {
        }.getType();

        return gson.fromJson(events, founderListType);
    }

    private static String item = "[  \n" +
            "   {  \n" +
            "      \"title\":\"Towels\"\n" +
            "   }\n" +
            "]";

    public static void getItems() {
        Gson gson = new Gson();

        Type founderListType = new TypeToken<ArrayList<MyItem>>() {
        }.getType();

        items = gson.fromJson(item, founderListType);
    }
}
