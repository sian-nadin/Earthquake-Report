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
    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    public Earthquake(String magnitude, String location, long timeInMilliseconds){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
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
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }


}
