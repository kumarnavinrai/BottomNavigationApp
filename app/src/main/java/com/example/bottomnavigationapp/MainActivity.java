package com.example.bottomnavigationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);

        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_home) {
                    loadFrag(new AFragment(), true);
                }else if(id == R.id.nav_search) {
                    loadFrag(new BFragment(), true);
                }else if(id == R.id.nav_utilities) {
                    loadFrag(new CFragment(), true);
                }else{
                    loadFrag(new AFragment(), false);
                }
                return true;
            }


        });

        bnView.setSelectedItemId(R.id.nav_home);
    }

    public void loadFrag(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag == false)
            ft.add(R.id.container, fragment);
        else
            ft.replace(R.id.container, fragment);
        ft.commit();

    }


}