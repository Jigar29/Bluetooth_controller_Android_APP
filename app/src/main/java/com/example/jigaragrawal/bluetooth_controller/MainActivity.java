package com.example.jigaragrawal.bluetooth_controller;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button pause_button, play_button, up_button, down_button, left_button, right_button;
    private Switch bluetooth_sw;
    private BluetoothAdapter mBTAdapter;

    protected void setVisibilityOfButtons(int a)
    {
        down_button.setVisibility(a);
        up_button.setVisibility(a);
        left_button.setVisibility(a);
        right_button.setVisibility(a);
        pause_button.setVisibility(a);
        play_button.setVisibility(a);
    }

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

        mBTAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        // Bluetooth switch position check if altered by any other activity
        if(mBTAdapter != null)
            bluetooth_sw.setChecked(mBTAdapter.isEnabled());

        // Bluetooth switch onclick listener setup
        bluetooth_sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetooth_sw.isChecked() == true)
                {
                    //mBTAdapter.enable();
                    Toast.makeText(MainActivity.this, "Bluetooth module turned on", Toast.LENGTH_LONG);
                    setVisibilityOfButtons(View.VISIBLE);
                }
                else
                {
                    //mBTAdapter.disable();
                    Toast.makeText(MainActivity.this, "Bluetooth module turned off", Toast.LENGTH_LONG);
                    setVisibilityOfButtons(View.INVISIBLE);
                }
            }
        });

        // Play button Onclick listener setup
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Pause button onclick listener setup
        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Up button Onclick listener setup
        up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Setting the initial state of all the buttons
        setVisibilityOfButtons(View.INVISIBLE);

        if(mBTAdapter == null)
        {
            Toast.makeText(MainActivity.this, "Bluetooth device is not available\n", Toast.LENGTH_LONG).show();
            bluetooth_sw.setVisibility(View.INVISIBLE);
        }
        else
        {
            Toast.makeText(MainActivity.this, "Bluetooth device Found\n", Toast.LENGTH_LONG).show();
            bluetooth_sw.setVisibility(View.VISIBLE);

            // Get the initial bluetooth state
            if(mBTAdapter.isEnabled())
            {
                bluetooth_sw.setVisibility(View.VISIBLE);
            }
            else
            {
                bluetooth_sw.setVisibility(View.INVISIBLE);
            }
        }
    }


}
