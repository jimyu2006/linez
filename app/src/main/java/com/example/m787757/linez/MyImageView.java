package com.example.m787757.linez;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import android.graphics.Paint;
import android.widget.ImageView;

public class MyImageView extends AppCompatImageView {
    private float width;
    private float height;

    public float left;
    public float top;
    public float right;
    public float bottom;

    private float gridSize;

    private Paint currentPaint;

    private int grids=10;

    private Context context;
    private GridAttribute gridAttribute;

    public MyImageView(Context context, GridAttribute gridAttribute) {
        super(context);
        this.context=context;
        this.gridAttribute=gridAttribute;
//        init();

    }

    public MyImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
//        init();
    }

//    private void init(){
//        currentPaint = new Paint();
//        currentPaint.setDither(true);
//        currentPaint.setColor(0xFF00CC00);  // alpha.r.g.b
//        currentPaint.setStyle(Paint.Style.STROKE);
//        currentPaint.setStrokeJoin(Paint.Join.ROUND);
//        currentPaint.setStrokeCap(Paint.Cap.ROUND);
//        currentPaint.setStrokeWidth(2);
//    }

    public float getLayoutWidth(){
        return  width;
    }

    public float getLayoutHeight(){
        return height;
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        for(int i=0; i<grids; i++){
//            canvas.drawLine(1.0f*i* gridSize, 0f,i*gridSize, height, currentPaint);
//        }
//    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        width=getMeasuredWidth();
//        height=getMeasuredHeight();
//        gridSize=width/(grids * 1.0f);
//    }
}
