package com.adrian.titanium_torpedo_android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import org.w3c.dom.Text;

public class Actuators extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actuators);

        //Get parent layout
        LinearLayout parentLayout = (LinearLayout)findViewById(R.id.actuators_linear_layout);

        LayoutInflater layoutInflater = (LayoutInflater)getLayoutInflater();
        View view;

        for(int i=1; i<=5; i++) {
            view = getLayoutInflater().inflate(R.layout.actuators_layout, parentLayout, false);
            Switch switch_button = (Switch)view.findViewById(R.id.inflate_switch);
            switch_button.setText("a " +  i);

            parentLayout.addView(view);
        }
    }
}
