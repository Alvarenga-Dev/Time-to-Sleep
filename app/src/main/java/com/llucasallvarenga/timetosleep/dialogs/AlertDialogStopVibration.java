package com.llucasallvarenga.timetosleep.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.adapters.AdapterStopVibration;
import com.llucasallvarenga.timetosleep.adapters.StopVibratingOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class AlertDialogStopVibration extends AppCompatDialogFragment {

    private TextView btnCancel;
    private CardView cardView;
    private RecyclerView recyclerView;
    private ArrayList<StopVibratingOptions> stopVibratingOptions;
    private AlertDialogListener listener;
    private String[] selections = {
            "5 minutos",
            "10 minutos",
            "15 minutos",
            "20 minutos",
            "25 minutos",
            "30 minutos",
            "Nunca"
    };

    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(this.getActivity()));
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view =  inflater.inflate(R.layout.alert_dialog_stop_vibration, null);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        cardView = view.findViewById(R.id.containerTimePickerId);
        btnCancel = view.findViewById(R.id.btnDeleteConfirmId);
        recyclerView = view.findViewById(R.id.rcyOptionsStopVibrationId);
        stopVibratingOptions = new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        listaSettar();

        AdapterStopVibration adapter = new AdapterStopVibration(stopVibratingOptions);
        adapter.setOnClickListener(position -> {
            //Dentro do switch mandará instruções para o arduino. Já o texto será settado com a interface;

            String minutesValue;

            switch (position){
                case 0:
                    minutesValue = selections[0];
                    listener.minutesStopVibration(minutesValue);
                    alertDialog.dismiss();
                    break;
                case 1:
                    minutesValue = selections[1];
                    listener.minutesStopVibration(minutesValue);
                    alertDialog.dismiss();
                    break;
                case 2:
                    minutesValue = selections[2];
                    listener.minutesStopVibration(minutesValue);
                    alertDialog.dismiss();
                    break;
                case 3:
                    minutesValue = selections[3];
                    listener.minutesStopVibration(minutesValue);
                    alertDialog.dismiss();
                    break;
                case 4:
                    minutesValue = selections[4];
                    listener.minutesStopVibration(minutesValue);
                    alertDialog.dismiss();
                    break;
                case 5:
                    minutesValue = selections[5];
                    listener.minutesStopVibration(minutesValue);
                    alertDialog.dismiss();
                    break;
                case 6:
                    minutesValue = selections[6];
                    listener.minutesStopVibration(minutesValue);
                    alertDialog.dismiss();
                    break;
                case 7:
                    minutesValue = selections[7];
                    listener.minutesStopVibration(minutesValue);
                    alertDialog.dismiss();
                    break;
            }
        });
        recyclerView.setAdapter(adapter);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return alertDialog;
    }


    @Override
    public void onAttach(Context context) { //Método que notifica a ConfigActivity do evento de recuperação do texto.
        super.onAttach(context);

        try{
            listener = (AlertDialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException( context.toString() + "Implemente a classe");
        }

    }

    private void listaSettar(){
        for (String options : selections) stopVibratingOptions.add(new StopVibratingOptions(options));
    }

    public interface AlertDialogListener{
        void minutesStopVibration(String valueStopVibration);
    }
}