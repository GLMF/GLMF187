package com.rkzk.android.bblmaterialdesign.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FABFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FABFragment extends AbstractFragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FABFragment.
     */
    public static FABFragment newInstance() {
        FABFragment fragment = new FABFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FABFragment() {
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
        return R.layout.fragment_fab;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (mActivity != null && mActivity.getSupportActionBar() != null) {
            mActivity.getSupportActionBar().setTitle(getString(R.string.title_fab));
        }
    }
}
