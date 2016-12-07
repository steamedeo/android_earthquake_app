package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by stefano on 05/12/2016.
 */

public class Earthquake {

    private double mMag;

    private String mCity;

    private long mTime;

    private String mUrl;

    //constructor
    public Earthquake(double mag, String city, long time){
        mMag = mag;
        mCity = city;
        mTime = time;
    }

    public Earthquake(double mag, String city, long time, String url){
        mMag = mag;
        mCity = city;
        mTime = time;
        mUrl = url;
    }

    //getters
    public double getMag(){
      return mMag;
    };

    public String getCity(){
        return mCity;
    }

    public long getDate(){
        return mTime;
    }

    public String getUrl(){
        return mUrl;
    }
}
