//CIS 3334 Sec 700 Mobile Device Programming - Spring 2016
//Assignment 5 Location Choice
//Date: 02/25/2016
//Submitted by: Dana McGree
//This app uses three widgets or views laid out in a vertical fashion.  A simple Text View that states "Select a Location".  
//The second one is a spinner that will display the address of five Dominos in the area.  The third is a button labeled "Find Pizza".
//When the user selects a location and clicks the button, a new activity will be loaded with an explicit intent. This new activity 
//will display the address of the selected Dominos.

package com.ebookfrenzy.locationchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner_address);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.address_arrary, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView mytext= (TextView) view;
        String selected = parent.getItemAtPosition(position).toString();
        Double spinnerValue = Double.parseDouble(selected.replaceAll("[\\D]", ""));

        // Showing selected spinner item
        Toast.makeText(this, "You Selected " + mytext.getText(), Toast.LENGTH_SHORT).show();


    }
    public void selectLocation(View view) {

        String address = spinner.getSelectedItem().toString();
        String locationChoice = "";

        //get location choice

        if (address.equals("103 W 23rd Street Hastings, MN")) {
            locationChoice = "Store #1967\nYou selected store #1967, located at " +
                    " 103 W 23rd Street in Hastings, MN.";
        }
        else if (address.equals("3019-A South Service Dr Red Wing, MN")) {
            locationChoice = "Store #7345\nYou selected store #7345, located at" +
                    " 3019-A South Service Dr Red Wing, MN.";
        }
        else if (address.equals("7145 E Point Douglas Road S Cottage Grove, MN")) {
            locationChoice = "Store #1935\nYou selected store #1935, located at" +
                    " 7145 E Point Douglas Road S Cottage Grove, MN.";
        }
        else if (address.equals("118 N Main Street River Falls, WI")) {
            locationChoice = "Store #2056\nYou selected store #2056, located at" +
                    " 118 N Main Street River Falls, WI.";
        }
        else {
            locationChoice = "Store #1975\nYou selected store #1975, located at" +
                    " 6635 Cahill Avenue Inver Grove Heights, MN.";
        }




        //create intent to pass to new activity
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        intent.putExtra("Choice", locationChoice);


        //start Activity
        startActivity(intent);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView){

    }
}
