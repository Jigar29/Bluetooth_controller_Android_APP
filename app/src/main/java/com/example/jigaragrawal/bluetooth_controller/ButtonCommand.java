package com.example.jigaragrawal.bluetooth_controller;

public class ButtonCommand  {
    public interface ButtonOperations{
        public enum ButtonCommands
        {
            SEND_START_COMMAND,
            SEND_STOP_COMMAND,
            SEND_UP_COMMAND,
            SEND_DOWN_COMMAND,
            SEND_LEFT_COMMAND,
            SEND_RIGHT_COMMAND,
            NUM_OF_COMMANDS,
        }
        public void sendButtonCommand(ButtonCommands cmd);
    }
}
