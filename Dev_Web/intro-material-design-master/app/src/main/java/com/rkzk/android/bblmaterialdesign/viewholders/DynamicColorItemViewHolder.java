package com.rkzk.android.bblmaterialdesign.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.customviews.CustomSquareImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DynamicColorItemViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.imgDynamic)
    public CustomSquareImageView imgDynamic;

    @InjectView(R.id.tvTitle)
    public TextView tvTitle;

    public DynamicColorItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
