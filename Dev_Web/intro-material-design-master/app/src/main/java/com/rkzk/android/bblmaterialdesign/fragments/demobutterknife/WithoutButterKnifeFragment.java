package com.rkzk.android.bblmaterialdesign.fragments.demobutterknife;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WithoutButterKnifeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WithoutButterKnifeFragment extends AbstractFragment {

    private CardView cardView;

    private EditText editText;

    private TextView textView;

    private Button button;

    private RevealView revealView;

    private NetWorkImageView networkImage;

    private CustomSquareImageView suareImage;

    private RippleLayout rippleLayout;

    private ExpandableListView expandableList;

    private AnalogClock analogClock;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WithButterKnifeFragment.
     */
    public static WithoutButterKnifeFragment newInstance() {
        WithoutButterKnifeFragment fragment = new WithoutButterKnifeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public WithoutButterKnifeFragment() {
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

        cardView = (CardView) view.findViewById(R.id.cardView);

        editText = (EditText) view.findViewById(R.id.editText);

        textView = (TextView) view.findViewById(R.id.textView);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something
            }
        });

        revealView = (RevealView) view.findViewById(R.id.revealView);

        networkImage = (NetWorkImageView) view.findViewById(R.id.networkImage);

        suareImage = (CustomSquareImageView) view.findViewById(R.id.suareImage);

        rippleLayout = (RippleLayout) view.findViewById(R.id.rippleLayout);

        expandableList = (ExpandableListView) view.findViewById(R.id.expandableList);

        analogClock = (AnalogClock) view.findViewById(R.id.analogClock);

    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.fragment_demo_butterknife;
    }
}
