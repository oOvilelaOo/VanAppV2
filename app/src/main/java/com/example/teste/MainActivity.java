package com.example.teste;

import android.os.Bundle;
import android.view.View;

import com.example.teste.ui.main.VOs.UsuarioVO;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AppBarLayout toolBar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabChat;
    TabItem tabTransportador;
    TabItem tabMapaOnline;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataBaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = findViewById(R.id.tollbar);


        tabLayout = findViewById(R.id.tabs);
        tabChat = findViewById(R.id.tabChat);
        tabTransportador = findViewById(R.id.tabTransportadores);
        tabMapaOnline = findViewById(R.id.tabMapa);
        viewPager= findViewById(R.id.view_pager);

        inicializarFireBase();

        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount(), dataBaseReference);
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    private void inicializarFireBase(){

        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        dataBaseReference = firebaseDatabase.getReference();
    }



}