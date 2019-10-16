package com.llucasallvarenga.timetosleep.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.bluetooth.AdapterDeviceListBt;
import com.llucasallvarenga.timetosleep.bluetooth.Device;

import java.util.ArrayList;

public class VTimerListBtFragment extends Fragment {

    private ImageView btnBackSettings;
    private RecyclerView listBtRcy;
    private ArrayList<Device> devices;

    private String[] devicesTest = {
            "Airpods",
            "Jbl Free X",
            "V-Timer",
            "SmartWach Sansumg",
            "Airpods",
    };

    public VTimerListBtFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vtimer_list_bt, container, false);

        btnBackSettings = view.findViewById(R.id.btnBackSettingsId);
        listBtRcy = view.findViewById(R.id.rcyListBtId);
        devices = new ArrayList<>();

        btnBackSettings.setOnClickListener(v -> getActivity().finish());

        listBtRcy.setHasFixedSize(true);
        listBtRcy.setLayoutManager(new LinearLayoutManager( getActivity() ));
        addComponents();
        AdapterDeviceListBt adapterDeviceListBt = new AdapterDeviceListBt(devices);
        adapterDeviceListBt.setOnClickListener(position -> {
            switch (position){
                case 0:
                    Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
            }
        });

        listBtRcy.setAdapter(adapterDeviceListBt);

        return view;
    }

    private void addComponents(){
        for (String devicesItens: devicesTest) devices.add(new Device(devicesItens));
    }

}
