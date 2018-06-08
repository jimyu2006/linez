package com.example.m787757.linez;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Grid {

    public static FrameLayout generateLayout(Context context, int width, int height) {
        FrameLayout layout = new FrameLayout(context);
        // Create Layout Parameters for FrameLayout
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        lp.width = width;
        lp.height = width;
        layout.setLayoutParams(lp);
        return layout;
    }

    static void addBallsToGrid(FrameLayout layout, Context context, Position[] positions, String[] colorsList, int gridSize) {
        for (int i = 0; i < positions.length; i++) {
            String c = colorsList[i];
            ImageView imgView = ImageViewCreater.generator(context, "ball_" + c, gridSize, gridSize);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(gridSize, gridSize);
            params.leftMargin = positions[i].x * gridSize; //Your X coordinate
            params.topMargin = positions[i].y * gridSize; //Your Y coordinate
            imgView.setLayoutParams(params);

            imgView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        Log.i("Clicked:", v.getClass().getName());
                        ((MainActivity)v.getContext()).clickedImageView=(ImageView) v;

//                    MyAnimation animation=new MyAnimation(ballView, event, 1000);
//                    animation.Move();
                    }
                    return true;
                }
            });

            layout.addView(imgView);
        }
    }
}
