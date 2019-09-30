package com.llucasallvarenga.timetosleep.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.llucasallvarenga.timetosleep.HomeActivity;
import com.llucasallvarenga.timetosleep.R;
import com.llucasallvarenga.timetosleep.adapters.AdapterArticles;
import com.llucasallvarenga.timetosleep.adapters.AdapterInformations;
import com.llucasallvarenga.timetosleep.adapters.Articles;
import com.llucasallvarenga.timetosleep.adapters.Informations;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {

    private ImageView btnReturn;
    private ArrayList<Articles> articles;
    private ArrayList<Informations> informations;
    private RecyclerView listaRcyArticles;
    private RecyclerView listaRcyAbout;

    private String[] titleArticles = {
            "Ajustar hora, data e fuso horário",
            "Criar, cancelar ou adiar alarmes",
            "Usar o cronômetro",
            "Instalar o app Time to Sleep"
    };
    private String[] aboutTitles = {
            "Termos e Politica de Privacidade",
            "Dados do app"
    };
    private int[] icons = {
            R.drawable.ic_help_policy_and_terms,
            R.drawable.ic_help_info_app
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        articles = new ArrayList<>();
        informations = new ArrayList<>();
        listaRcyArticles = findViewById(R.id.rcyArticlesId);
        listaRcyAbout = findViewById(R.id.rcyInformationId);
        btnReturn = findViewById(R.id.btnBackSettingsId);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //Lista articles.
        listaRcyArticles.setHasFixedSize(true);
        listaRcyArticles.setLayoutManager( new LinearLayoutManager( HelpActivity.this ) );
        addArticles();
        AdapterArticles adapterArticles = new AdapterArticles(articles);
        adapterArticles.setOnClickListener(new AdapterArticles.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                switch (position) {
                    case 0:
                        Toast.makeText(HelpActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(HelpActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(HelpActivity.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(HelpActivity.this, "4", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        listaRcyArticles.setAdapter(adapterArticles);

        //Lista sobre o app e instituição.
        listaRcyAbout.setHasFixedSize(true);
        listaRcyAbout.setLayoutManager( new LinearLayoutManager( HelpActivity.this ) );
        addInformations();
        AdapterInformations adapterInformations = new AdapterInformations(informations);
        adapterInformations.setOnClickListener(new AdapterInformations.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                switch (position){
                    case 0:
                        Toast.makeText(HelpActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(HelpActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        listaRcyAbout.setAdapter(adapterInformations);


    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void addArticles() {
        for (String title : titleArticles) articles.add( new Articles(title) );
    }
    private void addInformations() {
        for (int position = 0; position < aboutTitles.length; position++)
            informations.add( new Informations( icons[position], aboutTitles[position] ) );
    }

    private void router(){
        Intent intent = new Intent(HelpActivity.this, HomeActivity.class);
        startActivity( intent );
    }
}