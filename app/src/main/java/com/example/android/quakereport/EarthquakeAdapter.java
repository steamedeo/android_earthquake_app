package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        final Earthquake currentQuake = getItem(position);

        // Format the magnitude to show 1 decimal place
        String m = Formatter.formatMagnitude(currentQuake.getMag());

        String d = String.valueOf(currentQuake.getDate());

        String place = currentQuake.getCity();

        String offset;

        String primary;

        int length = place.length();

        //Split string in offset and primary
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

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Find the TextView in the list_item.xml layout with the ID offset
        final TextView offsetView = (TextView) listItemView.findViewById(R.id.offset);
        offsetView.setText(offset);

        final LinearLayout list = (LinearLayout) listItemView.findViewById(R.id.linear_list);

        //set click listener
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(currentQuake.getUrl()));
                list.getContext().startActivity(i);
            }
        });



        // Find the TextView in the list_item.xml layout with the ID primary
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


    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
