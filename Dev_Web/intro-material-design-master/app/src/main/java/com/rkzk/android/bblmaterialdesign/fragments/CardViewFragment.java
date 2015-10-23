package com.rkzk.android.bblmaterialdesign.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardViewFragment extends AbstractFragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CardViewFragment.
     */
    public static CardViewFragment newInstance() {
        CardViewFragment fragment = new CardViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public CardViewFragment() {
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
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.fragment_cardview;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(mActivity != null && mActivity.getSupportActionBar() != null){
            mActivity.getSupportActionBar().setTitle(getString(R.string.title_cardview));
        }
    }
}
