package com.llucasallvarenga.timetosleep.introsreens;


import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;
import com.heinrichreimersoftware.materialintro.app.SlideFragment;
import com.llucasallvarenga.timetosleep.HomeActivity;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.utils.Consts;
import com.llucasallvarenga.timetosleep.utils.Preferences;

import java.util.Objects;

import static android.app.Activity.RESULT_OK;

public class BtEnableSlide extends SlideFragment {

    private Button btnBtEnable;
    private BluetoothAdapter bluetoothAdapter = null;

    public BtEnableSlide() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bt_enable_slide, container, false);

        btnBtEnable = view.findViewById(R.id.btnBtEnable);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        btnBtEnable.setOnClickListener( View -> enableBt() );

        return view;
    }

    @Override
    public boolean canGoForward() {

        return goNextPage();
    }

    private boolean goNextPage(){

        if (bluetoothAdapter.isEnabled()) {
            Preferences preferences = new Preferences(Objects.requireNonNull(getActivity()));
            preferences.saveOpenFirstApp(false);
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }

    private void enableBt(){

        if (bluetoothAdapter == null){
            Toast.makeText(getActivity(), "Seu dispositivo não possui bluetooth!", Toast.LENGTH_SHORT).show();
            Objects.requireNonNull(getActivity()).finishAffinity();
        }else if (bluetoothAdapter.isEnabled()) {
            routerSettingsBt();
        }else{
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, Consts.REQUEST_ENABLE_BT);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Consts.REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                setToast("Bluetooth ativado! Agora conecte com o V-Timer", Toast.LENGTH_LONG);
                routerSettingsBt();
            } else {
                setToast("Bluetooth não ativado!", Toast.LENGTH_SHORT);
            }
        }
    }

    private void setToast(String text, int duration){
        Toast.makeText(getActivity(), text, duration).show();
    }

    private void routerSettingsBt(){ startActivityForResult(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS), 0); }

}
