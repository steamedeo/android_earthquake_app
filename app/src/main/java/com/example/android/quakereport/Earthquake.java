package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by stefano on 05/12/2016.
 */

public class Earthquake {

    private double mMag;

    private String mCity;

    private long mTime;

    //constructor
    public Earthquake(double mag, String city, long time){
        mMag = mag;
        mCity = city;
        mTime = time;
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
}
