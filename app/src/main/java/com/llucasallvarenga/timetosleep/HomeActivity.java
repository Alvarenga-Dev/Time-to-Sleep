package com.llucasallvarenga.timetosleep;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.llucasallvarenga.timetosleep.activites.HelpActivity;
import com.llucasallvarenga.timetosleep.activites.SettingsActivity;
import com.llucasallvarenga.timetosleep.activites.SupportActivity;
import com.llucasallvarenga.timetosleep.activites.VTimerActivity;
import com.llucasallvarenga.timetosleep.adapters.ViewPagerAdapter;
import com.llucasallvarenga.timetosleep.fragments.AlarmFragment;
import com.llucasallvarenga.timetosleep.fragments.ChronometerFragment;
import com.llucasallvarenga.timetosleep.fragments.ClockFragment;
import com.llucasallvarenga.timetosleep.utils.Preferences;

public class HomeActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private NavigationView navigationView;
    private Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferences = new Preferences(HomeActivity.this);

        setBottomNavigationView();
        setNavigationView();

        viewPager = findViewById(R.id.vpHomeId); //Init Viewpager
        setupFm(getSupportFragmentManager(), viewPager); //Setup Fragment
        viewPager.setCurrentItem(0); //Set Currrent Item When Activity Start
        viewPager.addOnPageChangeListener(new PageChange());

        final int defaultPosition = 0;
        final int bottomNavigationPosition;

        if (savedInstanceState == null){
            bottomNavigationPosition = defaultPosition;
            bottomNavigationView.setSelectedItemId(R.id.bnvItemAlarmeId);
        }else{
            bottomNavigationPosition = savedInstanceState.getInt("opened_fragment", defaultPosition);
        }

        bottomNavigationView.setSelectedItemId(bottomNavigationPosition);
        preferences.saveFirstRun(true);

    }

    public static void setupFm(FragmentManager fragmentManager, ViewPager viewPager){
        ViewPagerAdapter Adapter = new ViewPagerAdapter(fragmentManager);
        //Add All Fragment To List
        Adapter.add(new AlarmFragment(), "Page Alarm");
        Adapter.add(new ClockFragment(), "Page Clock");
        Adapter.add(new ChronometerFragment(), "Page Chronometrer");
        viewPager.setAdapter(Adapter);
    }

    private void setBottomNavigationView(){

        bottomNavigationView = findViewById(R.id.bvHomeId);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch (id) {
                    case R.id.bnvItemMenuId:
                        drawerLayout.openDrawer(GravityCompat.START);
                        return true;

                    case R.id.bnvItemAlarmeId:
                        viewPager.setCurrentItem(0);
                        return true;

                    case R.id.bnvItemRelogioId:
                        viewPager.setCurrentItem(1);
                        return true;

                    case R.id.bnvItemCronometroId:
                        viewPager.setCurrentItem(2);
                        return true;

                    default:
                        return false;
                }

            }

        });

    }

    private void setNavigationView(){

        drawerLayout = findViewById(R.id.dlHomeId);
        navigationView = findViewById(R.id.navigationDrawerId);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch (id){

                    case R.id.drawerSettingItemId:
                        setClass(SettingsActivity.class);
                        return true;
                    case R.id.drawerVtimerItemId:
                        setClass(VTimerActivity.class);
                        return true;
                    case R.id.drawerHelpItemId:
                        setClass(HelpActivity.class);
                        return true;
                    case R.id.drawerSupportItemId:
                        setClass(SupportActivity.class);
                        return true;
                    default:
                        return false;
                }

            }
        });

    }

    private void setClass(Class aClass){
        Intent intent = new Intent(HomeActivity.this, aClass);
        drawerLayout.closeDrawer(GravityCompat.START);
        startActivity( intent );
    }

    @Override
    public void onBackPressed() {
        // fechar e abrir menu
        DrawerLayout drawer = findViewById(R.id.dlHomeId);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("opened_fragment", bottomNavigationView.getSelectedItemId());
        super.onSaveInstanceState(outState);
    }

    public class PageChange implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    bottomNavigationView.setSelectedItemId(R.id.bnvItemAlarmeId);
                    break;
                case 1:
                    bottomNavigationView.setSelectedItemId(R.id.bnvItemRelogioId);
                    break;
                case 2:
                    bottomNavigationView.setSelectedItemId(R.id.bnvItemCronometroId);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

}