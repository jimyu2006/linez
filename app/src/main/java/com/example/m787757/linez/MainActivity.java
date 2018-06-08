package com.example.m787757.linez;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.m787757.linez.Constants.gridCount;

public class MainActivity extends AppCompatActivity {

    ImageView clickedImageView = null;
    ArrayList<ImageView> nextBallsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


//        final TextView infoText=findViewById(R.id.infoText);
//        ImageView bgView = (ImageView) findViewById(R.id.bgView);


    }

    private void init() {
        addImageList();
        initBoard();
    }

    private void initBoard() {
//        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        ImageView bgView = (ImageView) findViewById(R.id.bgView);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        Board board = new Board(
                this,
//                this.getApplicationContext(),
                width,
                width,
                Bitmap.Config.ARGB_8888,
                bgView);

        board.init();

        FrameLayout frameLayout = findViewById(R.id.frameLayout);

        Position[] positions = board.generateNextPosition();
        String[] colorsList = RandomColor.getNext3Colors();
        int gridSize = board.getGridSize();

        Grid.addBallsToGrid(frameLayout,
                this,
                positions,
                colorsList,
                gridSize);


        final TextView infoText = findViewById(R.id.infoText);

        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    infoText.setText("Touch coordinates : " +
                            String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));

                    Log.i("setOnTouchListener Clicked:", v.getClass().getName());

                    ImageView target = ((MainActivity) v.getContext()).clickedImageView;
                    if (target != null) {
                        MyAnimation animation = new MyAnimation(target, event, 1000);
                        animation.Move();
                    }
                }
                return true;
            }
        });
    }

    private void addImageList() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.nextBallsLayout);

        nextBallsList = new ArrayList<ImageView>();
        String[] nextColorsList = RandomColor.getNext3Colors();

        for (String c : nextColorsList) {
            ImageView img = ImageViewCreater.generator(this, "ball_" + c, 50, 50);
            nextBallsList.add(img);
            layout.addView(img);
        }
    }


}
