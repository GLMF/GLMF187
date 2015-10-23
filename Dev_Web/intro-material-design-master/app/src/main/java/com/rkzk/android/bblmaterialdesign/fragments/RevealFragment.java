package com.rkzk.android.bblmaterialdesign.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;
import com.rkzk.android.bblmaterialdesign.activities.RevealDetailLollipopActivity;
import com.rkzk.android.bblmaterialdesign.activities.RevealDetailPreLollipopActivity;
import com.rkzk.android.bblmaterialdesign.helpers.BundleHelper;

import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RevealFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RevealFragment extends AbstractFragment implements View.OnClickListener {

    @InjectView(R.id.tvText1)
    TextView tvText1;
    @InjectView(R.id.tvText2)
    TextView tvText2;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ElevationFragment.
     */
    public static RevealFragment newInstance() {
        RevealFragment fragment = new RevealFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public RevealFragment() {
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

        tvText1.setOnClickListener(this);
        tvText2.setOnClickListener(this);
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.fragment_reveal;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (mActivity != null && mActivity.getSupportActionBar() != null) {
            mActivity.getSupportActionBar().setTitle(getString(R.string.title_reveal));
        }
    }

    @Override
    public void onClick(View view) {
        if(view == tvText1 || view == tvText2){
            launchReveal(view);
        }
    }

    /**
     * Launch Reveal effect in activity
     * @param v
     */
    private void launchReveal(View v){

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        Intent intent;

        if (v.getId() == tvText1.getId()) {
            //reveal effect for api <= 21
            intent = new Intent(mActivity, RevealDetailLollipopActivity.class);
        }else{
            //custom reveal effect
            intent = new Intent(mActivity, RevealDetailPreLollipopActivity.class);
        }

        Bundle bundle = new Bundle();

        bundle.putIntArray(BundleHelper.VIEW_COORDINATE, location);
        intent.putExtras(bundle);
        mActivity.startActivity(intent);
        mActivity.overridePendingTransition(0, 0);
    }
}
