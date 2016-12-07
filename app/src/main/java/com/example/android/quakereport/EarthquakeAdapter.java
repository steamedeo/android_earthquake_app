package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by stefano on 05/12/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    //override constructor
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentQuake = getItem(position);

        // Format the magnitude to show 1 decimal place
        String m = Formatter.formatMagnitude(currentQuake.getMag());

        String d = String.valueOf(currentQuake.getDate());

        String place = currentQuake.getCity();

        String offset;

        String primary;

        int length = place.length();

        //Split string in offeset and primary
        int indexStart = place.indexOf(" of ");

        if (indexStart > 0){

            int indexEnd = indexStart + 3;

            offset = place.substring(0, indexEnd);

            primary = place.substring(indexEnd + 1, length);
        } else {
            offset = "Near the";

            primary = place;
        }


        // Find the TextView in the list_item.xml layout with the ID mag
        TextView mag= (TextView) listItemView.findViewById(R.id.mag);
        mag.setText(m);

        // Find the TextView in the list_item.xml layout with the ID offset
        TextView offsetView = (TextView) listItemView.findViewById(R.id.offset);
        offsetView.setText(offset);

        // Find the TextView in the list_item.xml layout with the ID offset
        TextView primaryView = (TextView) listItemView.findViewById(R.id.primary);
        primaryView.setText(primary);

        // Find the TextView in the list_item.xml layout with the ID date
        TextView date = (TextView) listItemView.findViewById(R.id.date);

        //create date object
        Date dateObject = new Date(currentQuake.getDate());

        //create formatted date
        String formattedDate = Formatter.formatDate(dateObject);

        date.setText(formattedDate);

        // Find the TextView in the list_item.xml layout with the ID time
        TextView time = (TextView) listItemView.findViewById(R.id.time);

        //create formatted date
        String formattedTime = Formatter.formatTime(dateObject);

        time.setText(formattedTime);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
