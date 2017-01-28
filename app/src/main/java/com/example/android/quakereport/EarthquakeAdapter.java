package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sian on 22/01/2017.
 */


/*
* EarthquakeAdapter is an ArrayAdapter that can provide the layout for each list
* based on a data source, which is a list of Earthquake objects.
* */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param earthquakes A List of Earthquake objects to display in a list
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the magnitude from the current Earthquake object and
        // set this text on the magnitude TextView
        magnitudeTextView.setText(currentEarthquake.getMagnitude());

        // Get the location from the current Earthquake object
        //Split location in to two separate strings - a distance & a primary location
        // e.g. "17km SE of" and "London"
        String locationData = currentEarthquake.getLocation();
        String distanceFrom;
        String primaryLocation;

        if (locationData.contains(LOCATION_SEPARATOR)) {
            // Split it.
            String[] locationParts = locationData.split(LOCATION_SEPARATOR);
            distanceFrom = locationParts[0] + LOCATION_SEPARATOR; // Will say e.g. 5km SE of
            primaryLocation = locationParts[1]; // e.g. Tokyo
        } else {
            distanceFrom = getContext().getString(R.string.near_the); // Will say e.g. 5km SE of
            primaryLocation = locationData; // e.g. Tokyo
        }

        // Find the TextView in the list_item.xml layout with the ID distance_location
        TextView distanceLocationTextView = (TextView) listItemView.findViewById(R.id.distance_location);
        // Get distance from locationParts array & set this text on the distance location TextView
        distanceLocationTextView.setText(distanceFrom);

        // Find the TextView in the list_item.xml layout with the ID location
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Get primary location from locationParts array & set this text on the primary location TextView
        primaryLocationTextView.setText(primaryLocation);


        //Create a new date object from the time in milliseconds
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        
        // Find the TextView in the list_item.xml layout with the ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        //Format the date String

        String formattedDate = formatDate(dateObject);
        // Get the date from the current Earthquake object and
        // set this text on the date TextView
        dateTextView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
