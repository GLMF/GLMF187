package com.rkzk.android.bblmaterialdesign.activities;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractActivity;
import com.rkzk.android.bblmaterialdesign.helpers.BundleHelper;

import butterknife.InjectView;


public class RevealDetailLollipopActivity extends AbstractActivity {

    @InjectView(R.id.container)
    ScrollView mContainer;
    @InjectView(R.id.tvText)
    TextView tvText;

    private int[] viewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mBundle != null) {
            viewLocation = mBundle.getIntArray(BundleHelper.VIEW_COORDINATE);
        }

        enterReveal();
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_reveal_details_lollipop;
    }

    @Override
    protected void initView() {

    }

    private void enterReveal(){

        if (viewLocation != null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                tvText.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {

                        tvText.getViewTreeObserver().removeOnPreDrawListener(this);

                        Animator animator = ViewAnimationUtils.createCircularReveal(
                                tvText,
                                viewLocation[0],      // x co-ordinate to start the mask from
                                viewLocation[1],      // y co-ordinate to start the mask from
                                0,
                                (float) Math.hypot(tvText.getWidth(), tvText.getHeight()));

                        // Set a natural ease-in/ease-out interpolator.
                        animator.setInterpolator(new AccelerateDecelerateInterpolator());

                        animator.setDuration(1500);

                        // Finally start the animation
                        animator.start();

                        return true;
                    }
                });
            }
        }
    }
}
