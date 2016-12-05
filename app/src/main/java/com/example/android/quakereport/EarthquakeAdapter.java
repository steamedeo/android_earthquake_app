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
import java.util.List;

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

        String m = String.valueOf(currentQuake.getMag());

        String d = String.valueOf(currentQuake.getDate());

        // Find the TextView in the list_item.xml layout with the ID mag
        TextView mag= (TextView) listItemView.findViewById(R.id.mag);
        mag.setText(m);

        // Find the TextView in the list_item.xml layout with the ID city
        TextView city = (TextView) listItemView.findViewById(R.id.city);
        city.setText(currentQuake.getCity());

        // Find the TextView in the list_item.xml layout with the ID date
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(d);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
