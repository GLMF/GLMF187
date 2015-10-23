package com.rkzk.android.bblmaterialdesign.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class CustomSquareImageView extends SquareImageView {

    private TextView mTextViewForPalette;

    public CustomSquareImageView(Context context) {
        super(context);
    }

    public CustomSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTextViewForPalette(TextView textView){
        mTextViewForPalette = textView;
    }

    public void setImageUrl(String url){

        mImageUrl = url;

        ImageLoader.getInstance().displayImage(mImageUrl, this, mOptionUIL, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {

            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {

                mBitmap = bitmap;

                Palette.generateAsync(bitmap,
                        new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                Palette.Swatch vibrant =
                                        palette.getVibrantSwatch();
                                if (vibrant != null) {
                                    mTextViewForPalette.setBackgroundColor(
                                            vibrant.getRgb());
                                    mTextViewForPalette.setTextColor(
                                            vibrant.getTitleTextColor());
                                }
                            }
                        });
            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });
    }
}
