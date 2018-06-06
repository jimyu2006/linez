package com.example.m787757.linez;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

import static com.example.m787757.linez.Constants.colorsCount;
import static com.example.m787757.linez.Constants.gridCount;

public class Board {
    private int width;
    private int height;
    private Bitmap.Config bgColorConfig;

    private int gridSize;

    ArrayList<GridAttribute> boardArray = new ArrayList<GridAttribute>();

    private ImageView boardView;

    public Board(int width, int height, Bitmap.Config bgColorConfig, ImageView boardView){
        this.width=width;
        this.height=height;
        this.bgColorConfig=bgColorConfig;
        this.boardView=boardView;

        gridSize=width / gridCount;
        initArray();
    }

    public void generate(){
        Bitmap blankBitmap=Bitmap.createBitmap(width, height, bgColorConfig);
        Canvas canvas=new Canvas(blankBitmap);
        Paint currentPaint=new Paint();
        currentPaint.setDither(true);
        currentPaint.setColor(0xFF00CC00);  // alpha.r.g.b
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeJoin(Paint.Join.ROUND);
        currentPaint.setStrokeCap(Paint.Cap.ROUND);
        currentPaint.setStrokeWidth(2);

        for (int i = 0; i <= gridCount; i++) {
            canvas.drawLine(0, i*gridSize, width, i*gridSize, currentPaint);
            canvas.drawLine(i * gridSize,0f, i * gridSize, height, currentPaint);
        }

        boardView.setImageBitmap(blankBitmap);
    }

    private void initArray() {
        for (int i = 0; i < gridCount; i++) {
            for (int j = 0; j < gridCount; j++) {
                for(int k=0; j<colorsCount; j++)
                boardArray.add(new GridAttribute())
            }
        }
    }

    public int[][] generateNextPosition(){
        int x=0, y=0;
        do{

        }while(boardArray[x][y]==1);

    }


    public int[][] populateArray(){

    }
}
