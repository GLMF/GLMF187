package com.rkzk.android.bblmaterialdesign.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractActivity;
import com.rkzk.android.bblmaterialdesign.customviews.RevealView;
import com.rkzk.android.bblmaterialdesign.helpers.BundleHelper;

import butterknife.InjectView;


public class RevealDetailPreLollipopActivity extends AbstractActivity implements RevealView.OnStateChangeListener {

    @InjectView(R.id.vRevealBackground)
    RevealView vRevealBackground;
    @InjectView(R.id.tvText)
    TextView tvText;
    @InjectView(R.id.container)
    FrameLayout container;
    @InjectView(R.id.svTextContainer)
    ScrollView svTextContainer;
    private int[] viewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mBundle != null) {
            viewLocation = mBundle.getIntArray(BundleHelper.VIEW_COORDINATE);
        }

        setUpRevealBackground(savedInstanceState);
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_reveal_details_pre_lollipop;
    }

    @Override
    protected void initView() {

    }

    private void setUpRevealBackground(Bundle savedInstanceState) {
        vRevealBackground.setOnStateChangeListener(this);
        if (savedInstanceState == null) {
            vRevealBackground.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    vRevealBackground.getViewTreeObserver().removeOnPreDrawListener(this);
                    vRevealBackground.startFromLocation(viewLocation);
                    return true;
                }
            });
        } else {
            vRevealBackground.setToFinishedFrame();
        }
    }

    @Override
    public void onStateChange(int state) {
        if (RevealView.STATE_FINISHED == state) {
            svTextContainer.setVisibility(View.VISIBLE);
        } else {
            svTextContainer.setVisibility(View.INVISIBLE);
        }
    }
}
