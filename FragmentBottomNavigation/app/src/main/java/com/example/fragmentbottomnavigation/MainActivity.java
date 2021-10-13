package com.example.fragmentbottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        //berfungsi menjadikan chatsfragment menjadi fragment default
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatsFragment()).commit();

        //memberi fungsi icon di bottom navigation
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                // untuk mengambil idfragment
                switch (item.getItemId()){
                    //kondisi jika nav_chats dipilih
                    case R.id.nav_chats:
                        // mengubah nilai selected fragment menjadi ChatFragment
                        selectedFragment = new ChatsFragment();
                        break;
                    //kondisi jika nav_status dipilih
                    case R.id.nav_status:
                        // mengubah nilai selected fragment menjadi StatusFragment
                        selectedFragment = new StatusFragment();
                        break;
                    //kondisi jika nav_calls dipilih
                    case R.id.nav_calls:
                        // mengubah nilai selected fragment menjadi CallsFragment
                        selectedFragment = new CallsFragment();
                        break;
                }
                // Mengganti Fragment menjadi fragment yang dipilih /selectedFragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

    }
}