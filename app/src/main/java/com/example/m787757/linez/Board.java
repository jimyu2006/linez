package com.example.m787757.linez;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import static com.example.m787757.linez.Constants.colorsCount;
import static com.example.m787757.linez.Constants.gridCount;

public class Board {
    private Context context;
    private RelativeLayout boardLayout;
    private int width;
    private int height;
    private Bitmap.Config bgColorConfig;

    private int gridSize;

    GridAttribute boardArray[][];

    private ImageView boardView;

    public Board(Context context, int width, int height, Bitmap.Config bgColorConfig, ImageView boardView) {
        this.context = context;
        this.width = width;
        this.height = height;
        this.bgColorConfig = bgColorConfig;
        this.boardView = boardView;

        boardArray = new GridAttribute[10][10];

        gridSize = width / gridCount;
        initArray();
    }

    private void initArray() {
        for (int i = 0; i < gridCount; i++) {
            for (int j = 0; j < gridCount; j++) {
                boardArray[i][j] = new GridAttribute(null, 0);
            }
        }
    }

    public int getGridSize(){
        return  this.gridSize;
    }

    public void init() {
        Bitmap blankBitmap = Bitmap.createBitmap(width, height, bgColorConfig);
        Canvas canvas = new Canvas(blankBitmap);
        Paint currentPaint = new Paint();
        currentPaint.setDither(true);
        currentPaint.setColor(0xFF00CC00);  // alpha.r.g.b
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeJoin(Paint.Join.ROUND);
        currentPaint.setStrokeCap(Paint.Cap.ROUND);
        currentPaint.setStrokeWidth(1);

        for (int i = 0; i <= gridCount; i++) {
            canvas.drawLine(0, i * gridSize, width, i * gridSize, currentPaint);
            canvas.drawLine(i * gridSize, 0f, i * gridSize, height, currentPaint);
        }

        boardView.setImageBitmap(blankBitmap);
    }


    public Position[] generateNextPosition() {
        Position[] nextPositions = new Position[3];
        int filledCount = 0;
        int x = 0, y = 0;
        do {
            x = RandomColor.getNextPosition();
            y = RandomColor.getNextPosition();
            if (boardArray[x][y].status != 1) {
                boardArray[x][y].status = 1;
                nextPositions[filledCount] = new Position(x, y);
                filledCount++;
            }
        } while (filledCount < 3);
        return nextPositions;
    }
}
