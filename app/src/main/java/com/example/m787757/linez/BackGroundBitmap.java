package com.example.m787757.linez;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BackGroundBitmap {
    private int width;
    private int height;
    private Bitmap.Config bgColorConfig;

    private int grids=10;
    private int gridSize;

    public BackGroundBitmap(int width, int height, Bitmap.Config bgColorConfig){
        this.width=width;
        this.height=height;
        this.bgColorConfig=bgColorConfig;
        gridSize=width / grids;
    }

    public Bitmap generate(){
        Bitmap blankBitmap=Bitmap.createBitmap(width, height, bgColorConfig);
        Canvas canvas=new Canvas(blankBitmap);
        Paint currentPaint=new Paint();
        currentPaint.setDither(true);
        currentPaint.setColor(0xFF00CC00);  // alpha.r.g.b
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeJoin(Paint.Join.ROUND);
        currentPaint.setStrokeCap(Paint.Cap.ROUND);
        currentPaint.setStrokeWidth(2);

        for (int i = 0; i <= grids; i++) {
            canvas.drawLine(0, i*gridSize, width, i*gridSize, currentPaint);
            canvas.drawLine(i * gridSize,0f, i * gridSize, height, currentPaint);
        }
        return  blankBitmap;
    }
}
