package com.rkzk.android.bblmaterialdesign.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SnackBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SnackBarFragment extends AbstractFragment {

    @InjectView(R.id.btnShow)
    Button btnShow;
    @InjectView(R.id.container)
    RelativeLayout mContainer;
    @InjectView(R.id.coordinator)
    CoordinatorLayout coordinator;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of this fragment.
     */
    public static SnackBarFragment newInstance() {
        SnackBarFragment fragment = new SnackBarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SnackBarFragment() {
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
        return R.layout.fragment_snackbar;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (mActivity != null && mActivity.getSupportActionBar() != null) {
            mActivity.getSupportActionBar().setTitle(getString(R.string.title_snackbar));
        }
    }

    @OnClick(R.id.btnShow)
    void showSnackBar() {
        Snackbar
                .make(coordinator, R.string.txt_snackbar, Snackbar.LENGTH_SHORT)
                .show(); // Don’t forget to show!
    }
}
