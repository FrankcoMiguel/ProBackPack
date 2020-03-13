package com.example.pro_packback;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;

    private TextView title;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        title = (TextView) findViewById(R.id.title);
        logo = (ImageView) findViewById(R.id.backpack);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        title.startAnimation(animation);
        logo.startAnimation(animation);


        intent = new Intent(this,MainActivity.class);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(intent);
                finish();

            }
        },3000);


    }
}
