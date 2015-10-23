package com.rkzk.android.bblmaterialdesign.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rkzk.android.bblmaterialdesign.BBLApplication;
import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractActivity;
import com.rkzk.android.bblmaterialdesign.activities.AppBarScrollActivity;
import com.rkzk.android.bblmaterialdesign.activities.ImageDetailCollapseToolBarIllustrateActivity;
import com.rkzk.android.bblmaterialdesign.bo.ItemDynamicColor;
import com.rkzk.android.bblmaterialdesign.helpers.BundleHelper;
import com.rkzk.android.bblmaterialdesign.viewholders.DynamicColorItemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DynamicColorListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private final List<ItemDynamicColor> mDatas = new ArrayList<>();
    private AbstractActivity mActivity;

    public DynamicColorListAdapter(AbstractActivity activityContext, List<ItemDynamicColor> datas) {
        mContext = activityContext;
        mActivity = activityContext;
        if(mContext == null)
            mContext = BBLApplication.getAppContext();
        mDatas.addAll(datas);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_dynamic_color, parent, false);
        return new DynamicColorItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final DynamicColorItemViewHolder viewHolder = (DynamicColorItemViewHolder) holder;

        final ItemDynamicColor item = getItemAtPosition(position);

        viewHolder.imgDynamic.setTextViewForPalette(viewHolder.tvTitle);
        viewHolder.imgDynamic.setImageUrl(item.getImageUrl());
        viewHolder.tvTitle.setText(item.getTitle());

        //enable onclick just for this activity
        if(mActivity != null && mActivity instanceof AppBarScrollActivity){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ImageDetailCollapseToolBarIllustrateActivity.class);
                    intent.putExtra(BundleHelper.URI_URL, item.getImageUrl());
                    intent.putExtra(BundleHelper.TITLE, item.getTitle());
                    mActivity.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * get item at position
     * @param position
     * @return item or null
     */
    private ItemDynamicColor getItemAtPosition(int position){
        try{
            return mDatas.get(position);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
