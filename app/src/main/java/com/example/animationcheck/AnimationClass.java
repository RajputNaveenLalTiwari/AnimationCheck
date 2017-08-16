package com.example.animationcheck;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by 2114 on 24-03-2017.
 */

public class AnimationClass extends Animation
{
    private AnimationView animationView;
    private int endX,endY;
    private int newEndX,newEndY;

    public AnimationClass(AnimationView animationView,int endX,int endY)
    {
        this.animationView = animationView;
        this.endX = animationView.getEndX();
        this.endY = animationView.getEndY();

        newEndX = endX;
        newEndY = endY;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t)
    {
        super.applyTransformation(interpolatedTime, t);

        int x = (int) (endX + ((newEndX-endX)*interpolatedTime));
        int y = (int) (endY + ((newEndY-endY)*interpolatedTime));

        animationView.setEndX(x);
        animationView.setEndY(y);

        animationView.requestLayout();
    }
}
