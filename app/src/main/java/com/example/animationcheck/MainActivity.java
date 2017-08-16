package com.example.animationcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    AnimationView animationView;
    AnimationClass animationClass;
    private int screenWidth,screenHeight;
    private int x,y,w,h;
    private Random random;
    private int endX,endY;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;

        x = (((screenWidth)-((screenWidth*25)/100)))/2;
        y = (((((screenHeight*50)/100)-((screenWidth*25)/100)))/2)+(screenHeight*10)/100;
        w = x+((screenWidth*25)/100);
        h = y+((screenWidth*25)/100);

        random = new Random();

        endX = random.nextInt(w-x)+x;
        endY = random.nextInt(h-y)+y;

        animationView = (AnimationView) findViewById(R.id.myview);
        animationClass = new AnimationClass(animationView,endX,endY);
        animationClass.setDuration(2000);
        animationClass.start();
    }
}
