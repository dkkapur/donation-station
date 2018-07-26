package com.donationstation.android.models;

import java.util.List;

/**
 * Created by sunilkumarlakkad on 7/24/18.
 */

public class User {
    private String user_id;
    private String type = "donor";
    private String name;
    private String email;
    private String zip;
    private String location;
    private List<String> interest;
    private List<String> items;

    public User(String name, String email, String location, String zipCode, List<String> interest) {
        this.name = name;
        this.email = email;
        this.user_id = email;
        this.location = location;
        this.zip = zipCode;
        this.interest = interest;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getZip() {
        return zip;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getInterest() {
        return interest;
    }

    public List<String> getItems() {
        return items;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
