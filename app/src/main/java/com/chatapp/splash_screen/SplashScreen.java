package com.chatapp.splash_screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.chatapp.R;
import com.chatapp.WelcomeScreen;

/**
 * Created by sprw-it-0007 on 16/4/16.
 */
public class SplashScreen extends Activity {
    //Splash Timeout
    private static final int SPLASH_TIME_OUT = 500;
    @Override
    protected  void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this, WelcomeScreen.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}
