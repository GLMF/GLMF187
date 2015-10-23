package com.rkzk.android.bblmaterialdesign.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;

import com.rkzk.android.bblmaterialdesign.R;
import com.rkzk.android.bblmaterialdesign.abstracts.AbstractActivity;
import com.rkzk.android.bblmaterialdesign.fragments.CardViewFragment;
import com.rkzk.android.bblmaterialdesign.fragments.DynamicColorFragment;
import com.rkzk.android.bblmaterialdesign.fragments.ElevationFragment;
import com.rkzk.android.bblmaterialdesign.fragments.FABFragment;
import com.rkzk.android.bblmaterialdesign.fragments.FloatingLabelFragment;
import com.rkzk.android.bblmaterialdesign.fragments.InterpolatorsFragment;
import com.rkzk.android.bblmaterialdesign.fragments.NavigationDrawerFragment;
import com.rkzk.android.bblmaterialdesign.fragments.RevealFragment;
import com.rkzk.android.bblmaterialdesign.fragments.RippleFragment;
import com.rkzk.android.bblmaterialdesign.fragments.SnackBarFragment;
import com.rkzk.android.bblmaterialdesign.fragments.TransitionFragment;


public class MainActivity extends AbstractActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    protected int getContentViewResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (position){
            case 0:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, ElevationFragment.newInstance())
                        .commit();
            }break;

            case 1:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, CardViewFragment.newInstance())
                        .commit();
            }break;

            case 2:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, DynamicColorFragment.newInstance())
                        .commit();
            }break;

            case 3:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, TransitionFragment.newInstance())
                        .commit();
            }break;

            case 4:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, RippleFragment.newInstance())
                        .commit();
            }break;

            case 5:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, RevealFragment.newInstance())
                        .commit();
            }break;

            case 6:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, InterpolatorsFragment.newInstance())
                        .commit();
            }break;

            case 7:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FABFragment.newInstance())
                        .commit();
            }break;

            case 8:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, FloatingLabelFragment.newInstance())
                        .commit();
            }break;

            case 9:{
                fragmentManager.beginTransaction()
                        .replace(R.id.container, SnackBarFragment.newInstance())
                        .commit();
            }break;

            case 10:{//startActivity
                Intent intent = new Intent(this, AppBarScrollActivity.class);
                startActivity(intent);
            }break;
        }
    }
}
