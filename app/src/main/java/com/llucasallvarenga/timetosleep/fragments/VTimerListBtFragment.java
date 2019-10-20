package com.llucasallvarenga.timetosleep.fragments;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.bluetooth.AdapterDeviceListBt;
import com.llucasallvarenga.timetosleep.bluetooth.Device;
import com.llucasallvarenga.timetosleep.utils.ConnectedThread;
import com.llucasallvarenga.timetosleep.utils.Consts;
import com.llucasallvarenga.timetosleep.utils.MyServices;
import com.llucasallvarenga.timetosleep.utils.Preferences;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import static android.app.Activity.RESULT_OK;

public class VTimerListBtFragment extends Fragment {

    private ImageView btnBackSettings;
    private RecyclerView listBtRcy;
    private ArrayList<Device> devices;
    private AdapterDeviceListBt adapterDeviceListBt;
    private Preferences preferences;
    private BluetoothAdapter bluetoothAdapter = null;

    public VTimerListBtFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vtimer_list_bt, container, false);

        btnBackSettings = view.findViewById(R.id.btnBackSettingsId);
        listBtRcy = view.findViewById(R.id.rcyListBtId);
        devices = new ArrayList<>();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        preferences = new Preferences(Objects.requireNonNull(getActivity()));

        if (bluetoothAdapter == null) {
            Toast.makeText(getActivity(), "Seu dispositivo não possui bluetooth!", Toast.LENGTH_SHORT).show();
        } else if (bluetoothAdapter.isEnabled()) {
            setDevicesTest(false);
        }else{
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, Consts.REQUEST_ENABLE_BT);
        }

        btnBackSettings.setOnClickListener(v -> getActivity().finish());

        listBtRcy.setHasFixedSize(true);
        listBtRcy.setLayoutManager(new LinearLayoutManager( getActivity() ));

        adapterDeviceListBt = new AdapterDeviceListBt(devices);
        adapterDeviceListBt.setOnClickListener(position -> {

            if (!preferences.getConnection()) {

                String nameBt = devices.get(position).getNameBt();
                String macAddress = devices.get(position).getMacAddress();

                if (!(nameBt.isEmpty() && macAddress.isEmpty())) {

                    preferences.saveNameDevice(nameBt);
                    preferences.saveMacAdressBt(macAddress);
                    preferences.saveConnection(true);

                    Intent intent = new Intent(getActivity(), MyServices.class);
                    getActivity().startService(intent);
                    getActivity().finish();
                }

            }else
                Toast.makeText(getActivity(), "Você já está conectado", Toast.LENGTH_SHORT).show();

        });

        listBtRcy.setAdapter(adapterDeviceListBt);

        return view;
    }

    private void setDevicesTest(boolean onBluetooth){
        Set<BluetoothDevice> bluetoothDevices = bluetoothAdapter.getBondedDevices(); //Lista de dispositivos

        if (bluetoothDevices.size() > 0) {
            for (BluetoothDevice deviceInformations : bluetoothDevices){

                Device device = new Device();
                device.setNameBt( deviceInformations.getName() );
                device.setMacAddress(deviceInformations.getAddress());
                if (onBluetooth)
                    adapterDeviceListBt.addDevice(device);
                else
                    devices.add(device);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Consts.REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                setSnackbar("Bluetooth ativado!");
                setDevicesTest(true);
            } else {
                setSnackbar("Bluetooth não ativado!");
            }
        }

    }

    private void setSnackbar(String text){
        Snackbar.make(Objects.requireNonNull(getView()), text, Snackbar.LENGTH_LONG).show();
    }

}
