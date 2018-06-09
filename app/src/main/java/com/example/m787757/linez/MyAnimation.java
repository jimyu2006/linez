package com.example.m787757.linez;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;


public class MyAnimation {
    View view;
    Position position;
    int duration;

    public MyAnimation(View view, Position position, int duration){
        this.view=view;
        this.position=position;
        this.duration=duration;
    }

    public void Move(){
        ObjectAnimator animX = ObjectAnimator.ofFloat(view, "x", position.x);
        ObjectAnimator animY = ObjectAnimator.ofFloat(view, "y", position.y);

        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.playTogether(animX, animY);
        animSetXY.setDuration(duration);
        animSetXY.start();
    }
}
