package com.rkzk.android.bblmaterialdesign.fragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;
import com.rkzk.android.bblmaterialdesign.helpers.AppHelper;

import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InterpolatorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InterpolatorsFragment extends AbstractFragment {

    @InjectView(R.id.fab1)
    FloatingActionButton fab1;
    @InjectView(R.id.fab2)
    FloatingActionButton fab2;
    @InjectView(R.id.fab3)
    FloatingActionButton fab3;
    @InjectView(R.id.fab4)
    FloatingActionButton fab4;
    @InjectView(R.id.container)
    LinearLayout mContainer;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment InterpolatorsFragment.
     */
    public static InterpolatorsFragment newInstance() {
        InterpolatorsFragment fragment = new InterpolatorsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public InterpolatorsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContainer.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {

                mContainer.getViewTreeObserver().removeOnPreDrawListener(this);

                startAnimation();

                return true;
            }
        });
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.fragment_interpolators;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (mActivity != null && mActivity.getSupportActionBar() != null) {
            mActivity.getSupportActionBar().setTitle(getString(R.string.title_interploators));
        }
    }

    private void startAnimation(){
        fabInAnimation(fab1);
        fabInAnimation(fab2);
        fabInAnimation(fab3);
        fabInAnimation(fab4);
    }

    //fab in out annimation
    private void fabInAnimation(final View fab) {

        fab.setTranslationY(-AppHelper.getScreenHeight(mActivity) + mActivity.getToolbarHeight() + fab.getHeight()*2);

        ViewPropertyAnimator animation = fab.animate();

        if(fab == fab2)
            animation.setInterpolator(new AccelerateInterpolator());

        if(fab == fab3)
            animation.setInterpolator(new DecelerateInterpolator());

        if(fab == fab4)
            animation.setInterpolator(new AccelerateDecelerateInterpolator());

        animation
                .translationY(0)
                .setDuration(2000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if(fab == fab1)
                            fabOutAnimation(fab1);

                        if(fab == fab2)
                            fabOutAnimation(fab2);

                        if(fab == fab3)
                            fabOutAnimation(fab3);

                        if(fab == fab4)
                            fabOutAnimation(fab4);
                    }
                })
                .start();
    }

    private void fabOutAnimation(final View fab) {

        fab.setTranslationY(0);

        ViewPropertyAnimator animation = fab.animate();

        if(fab == fab2)
            animation.setInterpolator(new AccelerateInterpolator());

        if(fab == fab3)
            animation.setInterpolator(new DecelerateInterpolator());

        if(fab == fab4)
            animation.setInterpolator(new AccelerateDecelerateInterpolator());

        animation
                .translationY(-AppHelper.getScreenHeight(mActivity) + mActivity.getToolbarHeight() + fab.getHeight() * 2)
                .setDuration(2000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if(fab == fab1)
                            fabInAnimation(fab1);

                        if(fab == fab2)
                            fabInAnimation(fab2);

                        if(fab == fab3)
                            fabInAnimation(fab3);

                        if(fab == fab4)
                            fabInAnimation(fab4);
                    }
                })
                .start();
    }
}
