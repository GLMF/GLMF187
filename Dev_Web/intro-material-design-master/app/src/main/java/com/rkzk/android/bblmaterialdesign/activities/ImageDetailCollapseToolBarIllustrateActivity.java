package com.rkzk.android.bblmaterialdesign.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.view.MenuItem;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractActivity;
import com.rkzk.android.bblmaterialdesign.customviews.NetWorkImageView;
import com.rkzk.android.bblmaterialdesign.helpers.BundleHelper;

import butterknife.InjectView;


public class ImageDetailCollapseToolBarIllustrateActivity extends AbstractActivity {

    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @InjectView(R.id.imageBBL)
    NetWorkImageView imageBBL;

    private String imageUrl;
    private String title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mBundle != null) {
            title = mBundle.getString(BundleHelper.TITLE);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        collapsingToolbar.setTitle(title);
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_image_detail_collapsetoolbar_illustrate;
    }

    @Override
    protected void initView() {
        if (mBundle != null) {
            imageUrl = mBundle.getString(BundleHelper.URI_URL);
        }
        //download image
        imageBBL.setImageUrl(imageUrl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
