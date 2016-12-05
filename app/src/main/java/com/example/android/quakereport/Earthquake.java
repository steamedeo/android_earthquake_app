package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by stefano on 05/12/2016.
 */

public class Earthquake {

    private double mMag;

    private String mCity;

    private String mDate;

    //constructor
    public Earthquake(double mag, String city, String date){
        mMag = mag;
        mCity = city;
        mDate = date;
    }

    //getters
    public double getMag(){
      return mMag;
    };

    public String getCity(){
        return mCity;
    }

    public String getDate(){
        return mDate;
    }
}
