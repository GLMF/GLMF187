package com.rkzk.android.bblmaterialdesign.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;
import com.rkzk.android.bblmaterialdesign.activities.ImageDetailTransitionIllustrateActivity;
import com.rkzk.android.bblmaterialdesign.customviews.NetWorkImageView;

import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransitionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransitionFragment extends AbstractFragment implements View.OnClickListener {

    @InjectView(R.id.imgBBL)
    NetWorkImageView imgBBL;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ElevationFragment.
     */
    public static TransitionFragment newInstance() {
        TransitionFragment fragment = new TransitionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public TransitionFragment() {
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

        //download image here
        imgBBL.setImageUrl("http://images8.alphacoders.com/546/546902.jpg");
        imgBBL.setOnClickListener(this);
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.fragment_transition;
    }

    @Override
    public void onClick(View view) {

        if(view == imgBBL){

            Intent intent = new Intent(mActivity, ImageDetailTransitionIllustrateActivity.class);

            String transitionName = getString(R.string.transition_image_detail);

            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,
                            imgBBL,   // The view which starts the transition
                            transitionName    // The transitionName of the view we’re transitioning to
                    );
            ActivityCompat.startActivity(mActivity, intent, options.toBundle());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(mActivity != null && mActivity.getSupportActionBar() != null){
            mActivity.getSupportActionBar().setTitle(getString(R.string.title_transition));
        }
    }
}
