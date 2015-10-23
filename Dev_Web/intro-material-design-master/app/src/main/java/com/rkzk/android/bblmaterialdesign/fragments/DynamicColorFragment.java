package com.rkzk.android.bblmaterialdesign.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractFragment;
import com.rkzk.android.bblmaterialdesign.activities.AppBarScrollActivity;
import com.rkzk.android.bblmaterialdesign.activities.MainActivity;
import com.rkzk.android.bblmaterialdesign.adapters.DynamicColorListAdapter;
import com.rkzk.android.bblmaterialdesign.bo.ItemDynamicColor;
import com.rkzk.android.bblmaterialdesign.customviews.AutofitRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DynamicColorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DynamicColorFragment extends AbstractFragment {

    @InjectView(R.id.rcvDynamicColor)
    AutofitRecyclerView rcvDynamicColor;

    private DynamicColorListAdapter mAdapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DynamicColorFragment.
     */
    public static DynamicColorFragment newInstance() {
        DynamicColorFragment fragment = new DynamicColorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public DynamicColorFragment() {
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

        rcvDynamicColor.setHasFixedSize(true);
        rcvDynamicColor.setLayoutManager(new GridLayoutManager(mActivity, 2));

        List<ItemDynamicColor> datas = new ArrayList<>();

        datas.add(new ItemDynamicColor("http://www.capsulecomputers.com.au/wp-content/uploads/phibrain-2-1.png", "Cuius acerbitati uxor grave accesser"));
        datas.add(new ItemDynamicColor("http://www.dailymars.net/wp-content/uploads/2013/05/Code-Geass-Wallpapers-171.jpg", "ssu temporis ad nocend"));
        datas.add(new ItemDynamicColor("http://i.ytimg.com/vi/CSdvhkWxoIc/maxresdefault.jpg", "a porrigitur Nili, laeva"));
        datas.add(new ItemDynamicColor("http://images8.alphacoders.com/546/546902.jpg", "opperiens et succurrens s"));
        datas.add(new ItemDynamicColor("http://www.bleach-mx.fr/wp-content/uploads/fairy_tail_356_color_cleaning_written_by_ulquiorra90-d6qw8p6.jpg", "morati post haec milit"));

        datas.add(new ItemDynamicColor("http://www.images-booknode.com/book_cover/679/full/bleach,-tome-40---the-lust-679222.jpg", "erit, quamobrem cum oratio ad ea monstranda deflexerit quae Romae gererentur, nihil praeter seditiones na"));
        datas.add(new ItemDynamicColor("http://ru.playstation.com/media/tyTbT_mS/Bleach_Hero_vf1.JPG", "urator monetae extinctus est. Sericum enim et Asbolium supra dictos, quoniam cum hortaretur passim nominare, quos vellent, adiecta religione firm"));
        datas.add(new ItemDynamicColor("http://fc08.deviantart.net/fs71/f/2014/315/5/1/smile___naruto__bolt__himawari_by_amien15-d85xna3.png", "tibus sollicite, quos insignes faciunt virgae dexteris aptatae velut tessera data castrensi iuxta vehiculi frontem omne textrinum incedit: hu"));
        datas.add(new ItemDynamicColor("http://blog.lesoir.be/wp-content/uploads/sites/58/2012/05/naruto.jpg", "s ut militares quosdam perduceret ausos conspirasse Magnentio, cum reniti non possent, iussa licentius supergressus fluminis modo fortunis conpluri"));
        datas.add(new ItemDynamicColor("http://static.comicvine.com/uploads/original/11111/111115829/3820418-4069398391-narut.jpg", "yzantiorum fuisse refertissimam atque ornatissimam signis quis ignorat? Qu"));
        datas.add(new ItemDynamicColor("http://images.funadvice.com/photo/image/old/28367/l_eac12ec5643a543cf5357d444c375b3f.png", "os iunxerat imperiale praeceptum, dispicere litis exitialis certamina cogebatur abnuens et reclamans, adulatorum oblatrantibus turmis, bellicosu"));

        Collections.shuffle(datas);

        mAdapter = new DynamicColorListAdapter(mActivity, datas);

        rcvDynamicColor.setAdapter(mAdapter);
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.fragment_dynamic_color;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(mActivity != null && mActivity instanceof MainActivity){
            if (mActivity != null && mActivity.getSupportActionBar() != null) {
                mActivity.getSupportActionBar().setTitle(getString(R.string.title_dynamic_color));
            }
        }else{
            if(mActivity != null && mActivity instanceof AppBarScrollActivity){
                if (mActivity != null && mActivity.getSupportActionBar() != null) {
                    mActivity.getSupportActionBar().setTitle(getString(R.string.title_appbar_scroll));
                }
            }
        }
    }
}
