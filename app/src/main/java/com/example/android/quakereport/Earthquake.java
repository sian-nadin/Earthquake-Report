package com.example.android.quakereport;

/**
 * Created by Sian on 22/01/2017.
 *
 * Earthquake represents a single earthquake that has occured
 * Each object has 3 properties: the magnitude, location & date
 */

public class Earthquake {
    //Magnitude of earthquake
    private double mMagnitude;
    //Location of earthquake
    private String mLocation;
    //Date earthquake occured
    private String mDate;
    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    public Earthquake(double magnitude, String location, long timeInMilliseconds){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    // get the magnitude of earthquake
    public  double getMagnitude(){
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
