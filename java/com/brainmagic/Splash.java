package com.brainmagic;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private static final long SPLASH_DISPLAY_LENGTH = 3000;
    Animation animBlink;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv = (TextView) findViewById(R.id.tv);
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
//        tv.setVisibility(View.VISIBLE);
        tv.startAnimation(animBlink);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                //if (isregister)
                //{
                Intent mainIntent = new Intent(Splash.this,Login.class);
                startActivity(mainIntent);
                finish();
            }
            //else {
            //  Intent mainIntent = new Intent(Splash_Activity.this, Registration_Activity.class);
            //mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            //      startActivity(mainIntent);
            //    finish();
            //}
                /* Create an Intent that will start the Menu-Activity. */

            //}

        }, SPLASH_DISPLAY_LENGTH);
    }
}

