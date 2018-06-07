package com.example.m787757.linez;

import android.content.Context;
import android.widget.ImageView;

public class ImageViewCreater {
    public static ImageView generator(Context context, String imageName, int width, int height){
        ImageView imgView = new ImageView(context);

//        imgView.setLayoutParams(new android.view.ViewGroup.LayoutParams(width, height));
        int res =context.getResources().getIdentifier(imageName,
                "drawable", context.getPackageName());
        imgView.setImageResource(res);
        imgView.setLayoutParams(new android.view.ViewGroup.LayoutParams(width, height));
//        imgView.getLayoutParams().width = width;
//        imgView.getLayoutParams().height = height;
        return  imgView;
    }
}
