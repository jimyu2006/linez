package com.example.m787757.linez;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Grid {

    public static FrameLayout generateLayout(Context context, int width, int height) {
        FrameLayout layout = new FrameLayout(context);
        // Create Layout Parameters for FrameLayout
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.width = width;
        lp.height = width;
        // Apply the Layout Parameters for FrameLayout
        layout.setLayoutParams(lp);
        // Apply 16 pixels padding each site of frame layout
        layout.setPadding(16, 16, 16, 16);

        return layout;
    }

    static void addBallsToGrid(FrameLayout layout, Context context, Position[] positions, String[] colorsList, int gridSize) {
        for (int i = 0; i < positions.length; i++) {
            String c = colorsList[i];
            ImageView imgView = ImageViewCreater.generator(context, "ball_" + c, gridSize, gridSize);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = positions[i].x * gridSize; //Your X coordinate
            params.topMargin = positions[i].y * gridSize; //Your Y coordinate
            imgView.setLayoutParams(params);

            layout.addView(imgView);
        }
    }


}
