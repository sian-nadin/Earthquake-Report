package com.example.android.quakereport;

/**
 * Created by Sian on 22/01/2017.
 *
 * Earthquake represents a single earthquake that has occured
 * Each object has 3 properties: the magnitude, location & date
 */

public class Earthquake {
    //Magnitude of earthquake
    private String mMagnitude;
    //Location of earthquake
    private String mLocation;
    //Date earthquake occured
    private String mDate;

    public Earthquake(String magnitude, String location, String date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    // get the magnitude of earthquake
    public  String getMagnitude(){
        return mMagnitude;
    }

    //get location of earthquake
    public String getLocation(){
        return mLocation;
    }

    //get date earthquake occured
    public String getDate() {
        return mDate;
    }
}
