package com.adrian.titanium_torpedo_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.adrian.titanium_torpedo_android.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton sensors = (FloatingActionButton) findViewById(R.id.sensors);
        sensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Start sensors activity", Snackbar.LENGTH_LONG)
                        .setAction("Sensors", null).show();*/
                startActivity(new Intent(view.getContext(), Sensors.class));
            }
        });
        FloatingActionButton actuators = (FloatingActionButton) findViewById(R.id.actuators);
        actuators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Start actuators activity", Snackbar.LENGTH_LONG)
                        .setAction("Actuators", null).show();*/
                startActivity(new Intent(view.getContext(), Actuators.class));
            }
        });
    }

}
