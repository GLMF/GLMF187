package com.rkzk.android.bblmaterialdesign.activities;

import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractActivity;
import com.rkzk.android.bblmaterialdesign.customviews.NetWorkImageView;
import com.rkzk.android.bblmaterialdesign.helpers.AppHelper;

import butterknife.InjectView;


public class ImageDetailTransitionIllustrateActivity extends AbstractActivity {

    @InjectView(R.id.imgBBL2)
    NetWorkImageView imgBBL;

    @InjectView(R.id.container)
    LinearLayout container;
    @InjectView(R.id.txtDesc)
    TextView txtDesc;

    private int[] viewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_image_detail_transition_illustrate;
    }

    @Override
    protected void initView() {

        imgBBL.setImageUrl("http://images8.alphacoders.com/546/546902.jpg");

        txtDesc.setTranslationY(AppHelper.getScreenHeight(this));

        txtDesc.animate()
                .translationY(0)
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(1000)
                .start();
    }
}
