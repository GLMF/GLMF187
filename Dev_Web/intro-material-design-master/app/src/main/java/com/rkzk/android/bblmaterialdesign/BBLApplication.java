package com.rkzk.android.bblmaterialdesign;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by ramyklaus on 06/06/15.
 */
public class BBLApplication extends Application {

    private static Context mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        initImageDownloader();
    }

    private void initImageDownloader(){
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mInstance).build();
        ImageLoader.getInstance().init(config);
    }

    /**
     * Get the app context
     * @return
     */
    public static Context getAppContext() {
        return mInstance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        //Clear cache of image load when quitting apps
        ImageLoader.getInstance().clearMemoryCache();
        ImageLoader.getInstance().clearDiskCache();
    }
}
