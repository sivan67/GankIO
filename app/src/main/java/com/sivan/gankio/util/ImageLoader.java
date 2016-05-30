package com.sivan.gankio.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by lixinwei on 16/5/30.
 */
public class ImageLoader {
    public static void loadImg(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    public static void loadImg(Activity activity, String url, ImageView imageView) {
        Glide.with(activity)
                .load(url)
                .into(imageView);
    }

    public static void loadImg(Fragment fragment, String url, ImageView imageView) {
        Glide.with(fragment)
                .load(url)
                .into(imageView);
    }
}
