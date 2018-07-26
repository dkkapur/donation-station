package com.donationstation.android.utils;

import com.donationstation.android.models.Event;
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
    private static String Users = "[\n" +
            "   {\n" +
            "      \"host\":\"artur.renault@gmail.com\",\n" +
            "      \"type\":\"pickup\",\n" +
            "      \"name\":\"Arthur\",\n" +
            "      \"address\":\"1010 1st Ave, Seattle, WA 98104, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.33621740000001,47.6050755]}\",\n" +
            "      \"starttime\":\"0001-11-01T01:01\",\n" +
            "      \"endtime\":\"0001-11-11T11:11\",\n" +
            "      \"items\":[\n" +
            "         \"clothes\",\n" +
            "         \"blanket\",\n" +
            "         \"canned food\",\n" +
            "         \"shoes\"\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"host\":\"tusharg91@gmail.com\",\n" +
            "      \"type\":\"pickup\",\n" +
            "      \"name\":\"Tushar Gupta\",\n" +
            "      \"address\":\"2922 Western Ave, Seattle, WA 98121, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.33621740000001,47.6050755]}\",\n" +
            "      \"starttime\":\"0001-11-01T01:01\",\n" +
            "      \"endtime\":\"0001-11-11T11:11\",\n" +
            "      \"items\":[\n" +
            "         \"clothes\",\n" +
            "         \"blanket\"\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"host\":\"amenarde@gmail.com\",\n" +
            "      \"type\":\"pickup\",\n" +
            "      \"name\":\"Antonio\",\n" +
            "      \"address\":\"2899-2801 2nd Ave, Seattle, WA 98121, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.33621740000001,47.6050755]}\",\n" +
            "      \"starttime\":\"0001-11-01T01:01\",\n" +
            "      \"endtime\":\"0001-11-11T11:11\",\n" +
            "      \"items\":[\n" +
            "         \"canned food\",\n" +
            "         \"shoes\"\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"host\":\"sunillakkad@gmail.com\",\n" +
            "      \"type\":\"pickup\",\n" +
            "      \"name\":\"Sunil Lakkad\",\n" +
            "      \"address\":\"2801 Western Ave, Seattle, WA 98121\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.33621740000001,47.6050755]}\",\n" +
            "      \"starttime\":\"0001-11-01T01:01\",\n" +
            "      \"endtime\":\"0001-11-11T11:11\",\n" +
            "      \"items\":[\n" +
            "         \"clothes\",\n" +
            "         \"shoes\"\n" +
            "      ]\n" +
            "   }\n" +
            "]";

    //public static List<User> getUsers()

    private static String events = "[\n" +
            "   {\n" +
            "      \"host\":\"deeptanshuk@gmail.com\",\n" +
            "      \"type\":\"dropoff\",\n" +
            "      \"name\":\"Food Drive for Tatooine\",\n" +
            "      \"address\":\"Armory, Seattle, WA 98109, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-122.3509386,47.6215512]}\",\n" +
            "      \"starttime\":\"2018-07-27T09:00\",\n" +
            "      \"endtime\":\"2018-07-27T11:00\",\n" +
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
            "      \"starttime\":\"2018-07-27T13:00\",\n" +
            "      \"endtime\":\"2018-07-27T18:00\",\n" +
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
            "      \"name\":\"Wakanda needs your towels!\",\n" +
            "      \"address\":\"Amazon.com Blvd, Shepherdsville, KY 40165, USA\",\n" +
            "      \"location\":\"{\\\"type\\\":\\\"Point\\\",\\\"coordinates\\\":[-85.68607789999999,37.9828326]}\",\n" +
            "      \"starttime\":\"2018-08-01T10:30\",\n" +
            "      \"endtime\":\"2018-08-02T12:00\",\n" +
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
            "      \"starttime\":\"2018-08-05T09:00\",\n" +
            "      \"endtime\":\"2018-08-05T12:00\",\n" +
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
            "      \"starttime\":\"2018-07-31T18:00\",\n" +
            "      \"endtime\":\"2018-07-31T21:00\",\n" +
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
}
