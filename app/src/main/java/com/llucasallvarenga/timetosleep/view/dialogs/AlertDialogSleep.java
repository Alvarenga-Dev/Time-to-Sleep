package com.llucasallvarenga.timetosleep.view.dialogs;

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
import com.llucasallvarenga.timetosleep.view.adapters.AdapterSleep;
import com.llucasallvarenga.timetosleep.view.adapters.SleepOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class AlertDialogSleep extends AppCompatDialogFragment{

        private RecyclerView recyclerView;
        private TextView btnCancel;
        private CardView cardView;
        private ArrayList<SleepOptions> sleepOptions;
        private AlertDialogListener listener;
        private String[] minutesOptions = {
                "1 minuto", "2 minutos", "3 minutos",
                "4 minutos", "5 minutos", "6 minutos",
                "7 minutos", "8 minutos", "9 minutos",
                "10 minutos", "11 minutos", "12 minutos",
                "13 minutos", "14 minutos", "15 minutos",
                "16 minutos", "17 minutos", "18 minutos",
                "19 minutos", "20 minutos", "21 minutos",
                "22 minutos", "23 minutos", "24 minutos",
                "25 minutos", "26 minutos", "27 minutos",
                "28 minutos", "29 minutos", "30 minutos"
        };

        @NotNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.alert_dialog_sleep, null);

            builder.setView(view);
            final AlertDialog dialog = builder.create();

            sleepOptions = new ArrayList<>();
            recyclerView = view.findViewById(R.id.rcyOptionsSleepsId);
            cardView = view.findViewById(R.id.containerAlertDialodSleepId);
            btnCancel = view.findViewById(R.id.btnAlertDialoSleepCancelId);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager( new LinearLayoutManager( this.getActivity() ) );
            setList();
            AdapterSleep adapter = new AdapterSleep(sleepOptions);
            adapter.setOnClickListener(position -> {

                //Dentro do switch mandará instruções para o arduino. Já o texto será settado com a interface;

                String minutesValue;

                switch (position){
                    case 0:
                        minutesValue = minutesOptions[0];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 1:
                        minutesValue = minutesOptions[1];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 2:
                        minutesValue = minutesOptions[2];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 3:
                        minutesValue = minutesOptions[3];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 4:
                        minutesValue = minutesOptions[4];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 5:
                        minutesValue = minutesOptions[5];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 6:
                        minutesValue = minutesOptions[6];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 7:
                        minutesValue = minutesOptions[7];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 8:
                        minutesValue = minutesOptions[8];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 9:
                        minutesValue = minutesOptions[9];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 10:
                        minutesValue = minutesOptions[10];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 11:
                        minutesValue = minutesOptions[11];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 12:
                        minutesValue = minutesOptions[12];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 13:
                        minutesValue = minutesOptions[13];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 14:
                        minutesValue = minutesOptions[14];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 15:
                        minutesValue = minutesOptions[15];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 16:
                        minutesValue = minutesOptions[16];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 17:
                        minutesValue = minutesOptions[17];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 18:
                        minutesValue = minutesOptions[18];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 19:
                        minutesValue = minutesOptions[19];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 20:
                        minutesValue = minutesOptions[20];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 21:
                        minutesValue = minutesOptions[21];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 22:
                        minutesValue = minutesOptions[22];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 23:
                        minutesValue = minutesOptions[23];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 24:
                        minutesValue = minutesOptions[24];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 25:
                        minutesValue = minutesOptions[25];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 26:
                        minutesValue = minutesOptions[26];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 27:
                        minutesValue = minutesOptions[27];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 28:
                        minutesValue = minutesOptions[28];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                    case 29:
                        minutesValue = minutesOptions[29];
                        listener.minutesSleep(minutesValue);
                        dialog.dismiss();
                        break;
                }
            });
            recyclerView.setAdapter(adapter);

            btnCancel.setOnClickListener(v -> dialog.dismiss());

            dialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );

            return dialog;
        }
        private void setList(){
            for (String options : minutesOptions) sleepOptions.add( new SleepOptions(options));
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);

            try{
                listener = (AlertDialogListener) context;
            }catch (ClassCastException e){
                throw new ClassCastException(context.toString() + "Implemente a classe");
            }
        }

        public interface AlertDialogListener{
            void minutesSleep(String valueSleep);
        }
}