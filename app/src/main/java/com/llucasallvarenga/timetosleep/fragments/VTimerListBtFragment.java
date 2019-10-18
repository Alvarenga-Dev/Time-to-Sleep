package com.llucasallvarenga.timetosleep.fragments;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.activites.VTimerActivity;
import com.llucasallvarenga.timetosleep.bluetooth.AdapterDeviceListBt;
import com.llucasallvarenga.timetosleep.bluetooth.Device;
import com.llucasallvarenga.timetosleep.utils.Consts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import static android.app.Activity.RESULT_OK;

public class VTimerListBtFragment extends Fragment {

    private ImageView btnBackSettings;
    private RecyclerView listBtRcy;
    private ArrayList<Device> devices;
    private BluetoothAdapter bluetoothAdapter = null;
    private BluetoothDevice bluetoothDevice = null;
    private BluetoothSocket bluetoothSocket = null;
    private boolean connection = false;

    UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    ConnectedThread connectedThread;

    public VTimerListBtFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vtimer_list_bt, container, false);

        if ( savedInstanceState == null ){
            Activity activity = new Activity();
            activity.setResult(Consts.REQUEST_CONNECTION_BT);
        }

        btnBackSettings = view.findViewById(R.id.btnBackSettingsId);
        listBtRcy = view.findViewById(R.id.rcyListBtId);
        devices = new ArrayList<>();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            Toast.makeText(getActivity(), "Não tem Bt!", Toast.LENGTH_SHORT).show();
        } else if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, Consts.REQUEST_ENABLE_BT);
        }

        btnBackSettings.setOnClickListener(v -> getActivity().finish());

        listBtRcy.setHasFixedSize(true);
        listBtRcy.setLayoutManager(new LinearLayoutManager( getActivity() ));

        setDevicesTest();

        AdapterDeviceListBt adapterDeviceListBt = new AdapterDeviceListBt(devices);
        adapterDeviceListBt.setOnClickListener(position -> {

            String nameBt = devices.get(position).getNameBt();
            String macAddress = devices.get(position).getMacAddress();

            Intent informationBt = new Intent();
            informationBt.putExtra(Consts.NAME_BT, nameBt);
            informationBt.putExtra(Consts.MAC_ADDRESS_BT, macAddress);

            Toast.makeText(getActivity(), macAddress, Toast.LENGTH_SHORT).show();

            Activity activity = new Activity();
            activity.setResult( RESULT_OK, informationBt );
        });

        listBtRcy.setAdapter(adapterDeviceListBt);

        return view;
    }

    private void setDevicesTest(){
        Set<BluetoothDevice> bluetoothDevices = bluetoothAdapter.getBondedDevices(); //Lista de dispositivos

        if (bluetoothDevices.size() > 0) {
            for (BluetoothDevice device : bluetoothDevices){
                String deviceName = device.getName();
                String deviceMacAddress = device.getAddress();
                devices.add(new Device( deviceName, deviceMacAddress ));
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case Consts.REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(getActivity(), "O bt foi ativado", Toast.LENGTH_SHORT).show();
                    setDevicesTest();
                }else {
                    Toast.makeText(getActivity(), "O bt n foi ativado", Toast.LENGTH_SHORT).show();
                }
                break;

            case Consts.REQUEST_CONNECTION_BT:
                if (resultCode == RESULT_OK){

                    if (data != null) {
                        String mac = data.getExtras().getString(Consts.MAC_ADDRESS_BT, "Nenhum MAc");
                        String name = data.getExtras().getString(Consts.NAME_BT, "Nenhum MAc");

                        bluetoothDevice = bluetoothAdapter.getRemoteDevice(mac);

                        try {
                            bluetoothSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(MY_UUID);
                            bluetoothSocket.connect();
                            connection = true;

                            connectedThread = new ConnectedThread(bluetoothSocket);
                            connectedThread.start();

                            Toast.makeText(getActivity(), "Você foi conectado com " + name, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            connection = false;
                            Toast.makeText(getActivity(), "Você não foi conectado com " + name, Toast.LENGTH_SHORT).show();
                            Log.i("AAAAA", e.getMessage());
                        }

                    }

                } else {
                    Toast.makeText(getActivity(), "Não foi possível obter o MAC", Toast.LENGTH_SHORT).show();
                }

        }

    }

    private class ConnectedThread extends Thread {

        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            bluetoothSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams; using temp objects because
            // member streams are final.
            try {
                tmpIn = socket.getInputStream();
            } catch (IOException e) {
                Log.e("b", "Error occurred when creating input stream", e);
            }
            try {
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
                Log.e("d", "Error occurred when creating output stream", e);
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            // mmBuffer store for the stream,,
            byte[] mmBuffer = new byte[1024];
            int numBytes; // bytes returned from read()

            // Keep listening to the InputStream until an exception occurs.
            while (true) {
                try {
                    // Read from the InputStream.
                    numBytes = mmInStream.read(mmBuffer);
                } catch (IOException e) {
                    Log.d("a", "Input stream was disconnected", e);
                    break;
                }
            }
        }

        // Call this from the main activity to send data to the remote device.
        private void send(String output) {

            byte[] byteBuffer = output.getBytes();

            try {
                mmOutStream.write(byteBuffer);
            } catch (IOException e) { Log.e("Error no byteBuffer", e.getMessage()); }
        }

    }
}
