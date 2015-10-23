package com.rkzk.android.bblmaterialdesign.fragments.demobutterknife;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;
import com.rkzk.android.bblmaterialdesign.customviews.CustomSquareImageView;
import com.rkzk.android.bblmaterialdesign.customviews.NetWorkImageView;
import com.rkzk.android.bblmaterialdesign.customviews.RevealView;
import com.rkzk.android.bblmaterialdesign.customviews.RippleLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WithButterKnifeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WithButterKnifeFragment extends AbstractFragment {

    @InjectView(R.id.cardView)
    CardView cardView;
    @InjectView(R.id.editText)
    EditText editText;
    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.button)
    Button button;
    @InjectView(R.id.revealView)
    RevealView revealView;
    @InjectView(R.id.networkImage)
    NetWorkImageView networkImage;
    @InjectView(R.id.suareImage)
    CustomSquareImageView suareImage;
    @InjectView(R.id.rippleLayout)
    RippleLayout rippleLayout;
    @InjectView(R.id.expandableList)
    ExpandableListView expandableList;
    @InjectView(R.id.analogClock)
    AnalogClock analogClock;

    /*@InjectView(R.id.cardView)
    CardView cardView;
    @InjectView(R.id.editText)
    EditText editText;
    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.button)
    Button button;
    @InjectView(R.id.revealView)
    RevealView revealView;
    @InjectView(R.id.networkImage)
    NetWorkImageView networkImage;
    @InjectView(R.id.suareImage)
    CustomSquareImageView suareImage;
    @InjectView(R.id.rippleLayout)
    RippleLayout rippleLayout;
    @InjectView(R.id.expandableList)
    ExpandableListView expandableList;
    @InjectView(R.id.analogClock)
    AnalogClock analogClock;*/

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WithButterKnifeFragment.
     */
    public static WithButterKnifeFragment newInstance() {
        WithButterKnifeFragment fragment = new WithButterKnifeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public WithButterKnifeFragment() {
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
        return R.layout.fragment_demo_butterknife;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
