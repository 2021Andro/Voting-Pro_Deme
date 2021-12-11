package com.example.voting_pro.Activitys.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.voting_pro.Activitys.Home_Activity;
import com.example.voting_pro.R;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Thread.sleep(2*1000);

                    startActivity(new Intent(getApplicationContext(), Home_Activity.class));

                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();
    }
}