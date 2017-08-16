package com.example.animationcheck;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by 2114 on 24-03-2017.
 */

public class AnimationView extends View
{
    private final int screenWidth,screenHeight;
    private final Random random;
    private final int startX,startY;
    private int endX,endY;

    private final Paint paint;
    private final float cornerRadius;
    private final CornerPathEffect cornerPathEffect;
    private final Path path;
    public AnimationView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        screenHeight = context.getResources().getDisplayMetrics().heightPixels;

        random = new Random();
        startX = 10;//random.nextInt(screenWidth)+1;
        startY = 10;//random.nextInt(((screenHeight*200)/100)-((screenHeight*120)/100))+((screenHeight*120)/100);

        endX = startX;
        endY = startY;

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        cornerRadius = 10.0f;
        cornerPathEffect = new CornerPathEffect(cornerRadius);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setPathEffect(cornerPathEffect);

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        path.moveTo(startX,startY);
        path.lineTo(endX,endY);
        canvas.drawPath(path,paint);
    }

    public void setEndX(int endX)
    {
        this.endX = endX;
    }

    public void setEndY(int endY)
    {
        this.endY = endY;
    }

    public int getEndX()
    {
        return endX;
    }

    public int getEndY()
    {
        return endY;
    }
}
