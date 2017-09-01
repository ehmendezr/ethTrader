package com.eth.ehmendezr.ethtrades.layers.outter.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.eth.ehmendezr.ethtrades.R;

public class SplashViewController extends AppCompatActivity {
private TextView texto;
private ImageView imagen;
private Intent intent;
    private Thread timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_view_controller);
        setupViews();
        setupAnim();
        startLogIn();
    }

    private void setupViews(){
        texto = (TextView) findViewById(R.id.textoSplash);
        imagen = (ImageView) findViewById(R.id.imagen_splash);
    }
    private void setupAnim(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splashtransition);
        texto.startAnimation(animation);
        imagen.startAnimation(animation);

    }
    private void startLogIn(){
        intent = new Intent(this,LogInViewController.class);
        timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();

                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
