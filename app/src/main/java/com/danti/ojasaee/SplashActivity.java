package com.danti.ojasaee;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cuberto.liquid_swipe.LiquidPager;

public class SplashActivity extends AppCompatActivity {

    LiquidPager pager;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //getSupportActionBar().hide();

        pager = findViewById(R.id.pager);
        viewPager = new ViewPager(getSupportFragmentManager(), 1);
        pager.setAdapter(viewPager);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                //SplashActivity.AsyncTaskSplash asyncTask = new SplashActivity.AsyncTaskSplash();
                //asyncTask.execute();

                // This method will be executed once the timer is over
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        }, 12000);
    }
}