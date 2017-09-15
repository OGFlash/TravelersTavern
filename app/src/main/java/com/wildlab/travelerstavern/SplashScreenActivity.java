package com.wildlab.travelerstavern;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wildlab.travelerstavern.DAndDActivity;
import com.wildlab.travelerstavern.R;

/**
 * @author ogflash
 * @since 9/15/2017.
 */

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_content);
        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), DAndDActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                }

            }
        };
        splashThread.start();
    }
}
