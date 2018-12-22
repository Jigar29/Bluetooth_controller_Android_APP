package com.example.jigaragrawal.bluetooth_controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button pause_button, play_button, up_button, down_button, left_button, right_button;
    private Switch bluetooth_sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pause_button = (Button) findViewById(R.id.pause_button);
        play_button = (Button) findViewById(R.id.play_button);
        up_button = (Button) findViewById(R.id.up_button);
        down_button = (Button) findViewById(R.id.down_button);
        right_button = (Button) findViewById(R.id.right_button);
        left_button = (Button) findViewById(R.id.left_button);
        bluetooth_sw = (Switch) findViewById(R.id.BT_switch);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        // Bluetooth switch onclick listener setup
        bluetooth_sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetooth_sw.isChecked() == true)
                {
                    bluetooth_sw.setTextOff("Turn Off");
                    down_button.setVisibility(View.VISIBLE);
                    up_button.setVisibility(View.VISIBLE);
                    left_button.setVisibility(View.VISIBLE);
                    right_button.setVisibility(View.VISIBLE);
                    pause_button.setVisibility(View.VISIBLE);
                    play_button.setVisibility(View.VISIBLE);
                }
                else
                {
                    bluetooth_sw.setTextOn("Turn On");
                    down_button.setVisibility(View.INVISIBLE);
                    up_button.setVisibility(View.INVISIBLE);
                    left_button.setVisibility(View.INVISIBLE);
                    right_button.setVisibility(View.INVISIBLE);
                    pause_button.setVisibility(View.INVISIBLE);
                    play_button.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Play pause button Onclick listener setup

    }

    @Override
    protected void onStart() {
        super.onStart();

        //Setting the initial state of all the buttons
        down_button.setVisibility(View.INVISIBLE);
        up_button.setVisibility(View.INVISIBLE);
        left_button.setVisibility(View.INVISIBLE);
        right_button.setVisibility(View.INVISIBLE);
        pause_button.setVisibility(View.INVISIBLE);
        play_button.setVisibility(View.INVISIBLE);
    }


}
