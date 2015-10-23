package com.rkzk.android.bblmaterialdesign.abstracts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.rkzk.android.bblmaterialdesign.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

public abstract class AbstractActivity extends AppCompatActivity {

    @Optional @InjectView(R.id.toolbar_actionbar) protected Toolbar mToolbar;

    protected Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Set the view
        if (getContentViewResourceId() != 0){
            setContentView(getContentViewResourceId());
            ButterKnife.inject(this);
        }

        if(mToolbar != null)
            setSupportActionBar(mToolbar);

        if(getIntent() != null && getIntent().getExtras() != null)
            mBundle = getIntent().getExtras();

        initView();
    }

    /**
     * Set content View
     * @return
     */
    protected abstract int getContentViewResourceId();

    /**
     * Init view with drawable etc...
     */
    protected abstract void initView();

    /**
     * get toolbar height
     * @return
     */
    public int getToolbarHeight(){
        if(mToolbar != null)
            return mToolbar.getHeight();

        return 0;
    }
}
