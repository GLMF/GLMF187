package com.rkzk.android.bblmaterialdesign.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class NetWorkImageView extends ImageView {

    protected String mImageUrl;

    private Context mContext;

    protected Bitmap mBitmap;

    protected static DisplayImageOptions mOptionUIL;

    public NetWorkImageView(Context context) {
        super(context);
        mContext = context;

        init();
    }

    public NetWorkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        init();
    }

    public NetWorkImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        init();
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
            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });
    }

    private void init(){
        if(mOptionUIL == null){
            mOptionUIL = new DisplayImageOptions.Builder()
                    .resetViewBeforeLoading(true)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .imageScaleType(ImageScaleType.EXACTLY)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .considerExifParams(true)
                    .build();
        }
    }
}
