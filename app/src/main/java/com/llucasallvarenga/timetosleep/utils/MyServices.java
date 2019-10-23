package com.llucasallvarenga.timetosleep.utils;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Vibrator;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;

public class MyServices extends Service {

    private BluetoothAdapter bluetoothAdapter = null;
    private BluetoothDevice bluetoothDevice = null;
    private BluetoothSocket bluetoothSocket = null;
    private Preferences preferences;
    private ConnectedThread connectedThread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Não foi implementado");
    }

    @Override
    public void onCreate() {

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        preferences = new Preferences(MyServices.this);

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Bundle bundle = intent.getExtras();
        String router;

        if (bundle != null) {

            router = bundle.getString(Consts.ROUTER);

                if ("setAlarm".equals(router) ) {
                    Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(1500);
                    connectedThread.send("1");
                    Handler handler = new Handler();
                    handler.postDelayed(() -> connectedThread.send("2"), 6000);
                }
                    
        }else
            connection();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void connection(){

        if (preferences.getNameDevice().equals("HC-05")) {

            bluetoothDevice = bluetoothAdapter.getRemoteDevice(preferences.getMacAddress());

            try {
                bluetoothSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(Consts.MY_UUID);
                bluetoothSocket.connect();
                preferences.saveConnection(true);

                connectedThread = new ConnectedThread(bluetoothSocket);
                connectedThread.start();

                Toast.makeText(getApplicationContext(), "Você foi conectado com " + preferences.getNameDevice(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                preferences.saveConnection(false);
                Toast.makeText(getApplicationContext(), "Você não foi conectado com V-Timer", Toast.LENGTH_SHORT).show();
            }

        }

    }

}
