package com.proyectos.khanakat.tienda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_title);
        iv = (ImageView) findViewById(R.id.iv_logo);

        Animation splashanimacion = AnimationUtils.loadAnimation(this,R.anim.splashtransition);

        tv.startAnimation(splashanimacion);
        iv.startAnimation(splashanimacion);

        final Intent i = new Intent(this,MainMenuActivity.class);

        Thread timer = new Thread(){
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
