package com.example.android.quakereport;

/**
 * Created by Sian on 22/01/2017.
 *
 *
 * Constructs a new Earthquake object.
 *
 * magnitude is the magnitude (size) of the earthquake
 * location is the location where the earthquake happened
 * timeInMilliseconds is the time in milliseconds (from the Epoch) when the
 *                           earthquake happened
 * url is the website URL to find more details about the earthquake
 */

public class Earthquake {
    //Magnitude of earthquake
    private double mMagnitude;
    //Location of earthquake
    private String mLocation;
    //Date earthquake occured
    private String mDate;
    // Time of the earthquake
    private long mTimeInMilliseconds;
    //URL of earthquake
    private String mURL;


    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mURL = url;
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

    //get URL for earthquake
    public String getURL() {return  mURL;}


}
