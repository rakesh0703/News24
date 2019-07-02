package com.example.rakesh.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
private TextView tv;
    private ImageView iv;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv1);
        iv = (ImageView) findViewById(R.id.iv);
        Animation myanimation = AnimationUtils.loadAnimation(this,R.anim.myanim);
        tv.startAnimation(myanimation);
        iv.startAnimation(myanimation);
        tv1.startAnimation(myanimation);
        final Intent i = new Intent(this,MainActivity.class);
        Thread timer =new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
