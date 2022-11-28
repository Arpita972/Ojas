package com.danti.ojasaee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    //private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        menu = navigationView.getMenu();
        //menu.findItem(R.id.nav_logout).setVisible(false);
        //menu.findItem(R.id.nav_profile).setVisible(false);
        //getSupportActionBar().hide();

        setSupportActionBar(toolbar);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        ImageView itskill = (GifImageView) findViewById(R.id.energyk);

        itskill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GalleryActivity.class);
                startActivity(intent);
            }
        });

        ImageView wisdom = (GifImageView) findViewById(R.id.edu);

        wisdom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PDFListActivity.class);
                startActivity(intent);
            }
        });


        ImageView energynews = (GifImageView) findViewById(R.id.news);

        energynews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EnergyNews.class);
                startActivity(intent);
            }
        });

        ImageView youtube = (GifImageView) findViewById(R.id.utube);

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,YouTube.class);
                startActivity(intent);
            }
        });

        ImageView galleryencon = (GifImageView) findViewById(R.id.gallary);

        galleryencon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GalleryofENCONActivity.class);
                startActivity(intent);
            }
        });

        ImageView newsletter = (GifImageView) findViewById(R.id.newsletter);

        newsletter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewsletterActivity.class);
                startActivity(intent);
            }
        });


        ImageView barscan = (GifImageView) findViewById(R.id.qrred);

        barscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ScannedBarcodeActivity.class);
                startActivity(intent);
            }
        });


        ImageView abtus = (GifImageView) findViewById(R.id.abtus);

        abtus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        return false;
//    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_aboutus:
                Intent intent1 = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_contactus:
                Intent intent2 = new Intent(MainActivity.this, ContactUs.class);
                startActivity(intent2);
                break;

            case R.id.nav_link:
                Intent intent3 = new Intent(MainActivity.this, LinkActivity.class);
                startActivity(intent3);
                break;

            case R.id.nav_aeelogin:
                Intent intent4 = new Intent(MainActivity.this, AEEMemberLogin.class);
                startActivity(intent4);
                break;


            case R.id.nav_aeeregistration:
                Intent intent5 = new Intent(MainActivity.this, AEERegistration.class);
                startActivity(intent5);
                break;
                /*
                menu.findItem(R.id.nav_logout).setVisible(true);
                menu.findItem(R.id.nav_profile).setVisible(true);
                menu.findItem(R.id.nav_login).setVisible(false);*/


        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }
}