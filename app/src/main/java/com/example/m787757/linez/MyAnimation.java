package com.example.m787757.linez;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;


public class MyAnimation {
    View view;
    MotionEvent event;
    int duration;

    public MyAnimation(View view, MotionEvent event, int duration){
        this.view=view;
        this.event=event;
        this.duration=duration;
    }

    public void Move(){
        ObjectAnimator animX = ObjectAnimator.ofFloat(view, "x", event.getX());
        ObjectAnimator animY = ObjectAnimator.ofFloat(view, "y", event.getY());

        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.playTogether(animX, animY);
        animSetXY.setDuration(duration);
        animSetXY.start();
    }
}
