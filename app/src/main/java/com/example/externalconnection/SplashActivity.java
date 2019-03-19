package com.example.externalconnection;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.splashImg);
        textView = findViewById(R.id.splashText);

        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.splash_anim);
        Animation animation2 = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.zoom_in);

        imageView.startAnimation(animation);
        textView.startAnimation(animation2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, Main3Activity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
