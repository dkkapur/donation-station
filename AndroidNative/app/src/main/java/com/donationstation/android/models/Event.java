package com.donationstation.android.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class Event implements Parcelable {
    public String host;
    public String type;
    public String name;
    public String address;
    public String location;
    public String starttime;
    public String endtime;
    public List<String> items;

    public Event() {
    }

    protected Event(Parcel in) {
        host = in.readString();
        type = in.readString();
        name = in.readString();
        address = in.readString();
        location = in.readString();
        starttime = in.readString();
        endtime = in.readString();
        items = in.createStringArrayList();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(host);
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(location);
        dest.writeString(starttime);
        dest.writeString(endtime);
        dest.writeStringList(items);
    }
}
