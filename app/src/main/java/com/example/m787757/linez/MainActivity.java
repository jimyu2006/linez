package com.example.m787757.linez;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<ImageView> nextBallsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



//        final View ballView=findViewById(R.id.ballView);
//        Log.i("bgView width:", String.valueOf(bitmap.getWidth()));
//        ballView.getLayoutParams().width=bitmap.getWidth()/10;
//        ballView.getLayoutParams().height=bitmap.getWidth()/10;

//        final TextView infoText=findViewById(R.id.infoText);

//        bgView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    events.add(event);
//                    infoText.setText("Touch coordinates : " +
//                            String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
//
//                    MyAnimation animation=new MyAnimation(ballView, event, 1000);
//                    animation.Move();
//                }
//                return true;
//            }
//        });
    }

    private void init() {
        initBoard();

        addImageList();
    }

    private void initBoard() {
        ImageView bgView = (ImageView) findViewById(R.id.bgView);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        Board board = new Board(width,
                width,
                Bitmap.Config.ARGB_8888,
                bgView);

        board.generate();
    }



    private void addImageList() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.nextBallsLayout);

        nextBallsList = new ArrayList<ImageView>();
        String[] nextColorsList = RandomColor.getNext3Balls();

        for (String c : nextColorsList) {
            ImageView img = new ImageView(this.getApplicationContext());
            img.setLayoutParams(new android.view.ViewGroup.LayoutParams(80, 60));
            int res = getResourceIdByName("ball_" + c);
            img.setImageResource(res);
            nextBallsList.add(img);

            layout.addView(img);
        }
    }

    private int getResourceIdByName(String imageName) {
        int resID = getResources().getIdentifier(imageName,
                "drawable", getPackageName());
        return resID;
    }


}
