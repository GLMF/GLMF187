package com.rkzk.android.bblmaterialdesign.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;
import com.rkzk.android.bblmaterialdesign.customviews.NetWorkImageView;

import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ElevationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElevationFragment extends AbstractFragment implements View.OnClickListener {

    @InjectView(R.id.imgBBL)
    NetWorkImageView imgBBL;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ElevationFragment.
     */
    public static ElevationFragment newInstance() {
        ElevationFragment fragment = new ElevationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ElevationFragment() {
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
        imgBBL.setImageUrl("http://images.vefblog.net/vefblog.net/g/h/ghost_rider91/photos_gros/2008/07/Ghost_Rider91121665980647_gros.jpg");
        imgBBL.setOnClickListener(this);
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.fragment_elevation;
    }

    @Override
    public void onClick(View view) {
        if(view == imgBBL){
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // only for lollipop and newer versions
                imgBBL.setElevation(imgBBL.getElevation() + 5);
            }
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(mActivity != null && mActivity.getSupportActionBar() != null){
            mActivity.getSupportActionBar().setTitle(getString(R.string.title_elevation));
        }
    }
}
