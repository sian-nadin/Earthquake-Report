/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake(3.2,"San Francisco", "3rd Jan"));
        earthquakes.add(new Earthquake(1.0, "London", "6th Aug"));
        earthquakes.add(new Earthquake(2.4,"Tokyo", "5th Feb"));
        earthquakes.add(new Earthquake(4.4, "Mexico City", "7th June"));
        earthquakes.add(new Earthquake(3.1, "Moscow", "29th July"));
        earthquakes.add(new Earthquake(5.2, "Rio de Janeiro", "17th May"));
        earthquakes.add(new Earthquake(6.7, "Paris", "3rd Aug"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new earthquake adapter whose source is a list of earthquakes
        // The adapter knows how to craete ListItem views for each item in the list
        EarthquakeAdapter earthquake = new EarthquakeAdapter(this, earthquakes);

        //Get a refrence to the listView & attach array adapter
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(earthquake);


    }
}
