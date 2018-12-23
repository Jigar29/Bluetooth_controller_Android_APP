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

        if(mBTAdapter == null)
        {
            Toast.makeText(MainActivity.this, "Bluetooth Adapter is not available\n", Toast.LENGTH_SHORT).show();
            bluetooth_sw.setVisibility(View.INVISIBLE);
        }
        else
        {
            Toast.makeText(MainActivity.this, "Bluetooth Adapter Found\n", Toast.LENGTH_SHORT).show();
            bluetooth_sw.setVisibility(View.VISIBLE);
        }
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
                    mBTAdapter.enable();
                    Toast.makeText(MainActivity.this, "Bluetooth turned on", Toast.LENGTH_SHORT).show();
                    setVisibilityOfButtons(View.VISIBLE);
                }
                else
                {
                    mBTAdapter.disable();
                    Toast.makeText(MainActivity.this, "Bluetooth turned off", Toast.LENGTH_SHORT).show();
                    setVisibilityOfButtons(View.INVISIBLE);
                }
            }
        });

        // Play button Onclick listener setup
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Play Button Pressed", Toast.LENGTH_SHORT).show();
            }
        });

        // Pause button onclick listener setup
        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pause Button Pressed", Toast.LENGTH_SHORT).show();
            }
        });

        // Up button Onclick listener setup
        up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Up Button Pressed", Toast.LENGTH_SHORT).show();
            }
        });

        // Down button Onclick listener setup
        down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Down Button Pressed", Toast.LENGTH_SHORT).show();
            }
        });

        // left button Onclick listener setup
        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Left Button Pressed", Toast.LENGTH_SHORT).show();
            }
        });

        // right button Onclick listener setup
        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Right Button Pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Setting the initial state of all the buttons
        setVisibilityOfButtons(View.INVISIBLE);
    }

}
