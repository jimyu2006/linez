package com.example.m787757.linez;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ImageViewCreater {
    public static ImageView generator(Context context, String imageName, int width, int height){
        ImageView imgView = new ImageView(context);

        imgView.setLayoutParams(new android.view.ViewGroup.LayoutParams(width, height));

        int res =context.getResources().getIdentifier(imageName,
                "drawable", context.getPackageName());
        imgView.setImageResource(res);

        return  imgView;
    }
}
