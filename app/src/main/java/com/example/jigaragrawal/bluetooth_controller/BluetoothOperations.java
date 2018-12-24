package com.example.jigaragrawal.bluetooth_controller;

public class BluetoothOperations {
    // Character Send Function
    public void sendChar(char character)
    {

    }
    // String Send function
    public void sendString(String str)
    {
        for(int i=0; i<str.length(); i++)
        {
            sendChar(str.charAt(i));
        }
    }
}
