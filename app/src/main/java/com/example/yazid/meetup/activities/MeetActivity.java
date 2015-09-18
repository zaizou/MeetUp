package com.example.yazid.meetup.activities;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yazid.meetup.R;
import com.example.yazid.meetup.adapters.ViewPagerAdapter;
import com.example.yazid.meetup.fragments.NavigationDrawerFragment;
import com.example.yazid.meetup.views.SlidingTabLayout;

public class MeetActivity extends AppCompatActivity {


    Toolbar meetBar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabLayout;
    String []titles={"Posts","Events"};
    int nbTab=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);
        this.init();

    }


    private void init(){
        this.initToolbar();
        this.iniNavDrawer();
        this.initTabing();
    }

    private void initToolbar(){
        this.meetBar= (Toolbar) this.findViewById(R.id.meetBar);
        this.setSupportActionBar(this.meetBar);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void iniNavDrawer(){
        NavigationDrawerFragment drawerFragment=(NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.nav_drawer);
        drawerFragment.setUp(R.id.nav_drawer,(DrawerLayout)this.findViewById(R.id.drawer_main),this.meetBar);
    }
    private void initTabing(){
        this.adapter=new ViewPagerAdapter(getSupportFragmentManager(),this.titles,this.nbTab);
        this.pager=(ViewPager)this.findViewById(R.id.viewPager);
        this.pager.setAdapter(this.adapter);
        this.tabLayout=(SlidingTabLayout)this.findViewById(R.id.slidingTabs);
        /*this.tabLayout.setDistributeEvenly(true);
        this.tabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });*/
        this.tabLayout.setViewPager(this.pager);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
