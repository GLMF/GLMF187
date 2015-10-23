package com.rkzk.android.bblmaterialdesign.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FloatingLabelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FloatingLabelFragment extends AbstractFragment {

    @InjectView(R.id.username_edit_text)
    AppCompatEditText usernameEditText;
    @InjectView(R.id.username_text_input_layout)
    TextInputLayout usernameTextInputLayout;
    @InjectView(R.id.btnFocus)
    Button btnFocus;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FABFragment.
     */
    public static FloatingLabelFragment newInstance() {
        FloatingLabelFragment fragment = new FloatingLabelFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FloatingLabelFragment() {
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

        usernameEditText.setHintTextColor(getResources().getColor(R.color.textSecondaryColor));
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.fragment_floatinglabel;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (mActivity != null && mActivity.getSupportActionBar() != null) {
            mActivity.getSupportActionBar().setTitle(getString(R.string.title_floating_label));
        }
    }

    @OnClick(R.id.btnFocus)
    void focusEditText(){
        if(usernameEditText.isFocused()){
            usernameEditText.clearFocus();
        }else{
            usernameEditText.requestFocus();
        }
    }
}
