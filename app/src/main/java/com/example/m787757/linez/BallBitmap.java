package com.example.m787757.linez;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BallBitmap {
    private int width;
    private int height;
    private int ballColor;

    private int ballSize;

    public BallBitmap(int ballSize, int ballColor){
        this.ballSize=ballSize;
        this.ballColor=ballColor;
    }

    public Bitmap generate(){
        Bitmap blankBitmap=Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(blankBitmap);
        Paint currentPaint=new Paint();
        currentPaint.setDither(true);
        currentPaint.setColor(ballColor);  // alpha.r.g.b

        canvas.drawCircle(width/2, width/2, width/2, currentPaint);
        return  blankBitmap;
    }
}
