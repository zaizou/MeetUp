package com.example.yazid.meetup.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yazid.meetup.R;
import com.example.yazid.meetup.adapters.MeetRecycleAdapter;
import com.example.yazid.meetup.applications.MeetApplication;
import com.example.yazid.meetup.model.MenuListElement;

import java.util.ArrayList;
import java.util.List;


public class NavigationDrawerFragment extends Fragment {

    public static final String PREF_FILE_NAME="join_me";
    public static final String KEY_USER_LEARNED="user_learned_drawer";

    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private boolean mUserLearnedDrawer;
    private boolean mFromsavedInstanceState;
    private View containerView;
    private RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mUserLearnedDrawer=Boolean.valueOf(readFromPreferences(this.getContext(),KEY_USER_LEARNED,"false"));
        if(savedInstanceState!=null)
            mFromsavedInstanceState=true;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        this.recyclerView=((RecyclerView)v.findViewById(R.id.recycleElements));
        this.recyclerView.setAdapter(new MeetRecycleAdapter(this.getContext(),this.getMenuItems()));
        return v;

    }

    public void setUp(int layoutId,DrawerLayout drawerLayout,Toolbar toolbar) {
        this.containerView=this.getActivity().findViewById(layoutId);
        this.mDrawerLayout=drawerLayout;
        mDrawerToggle=new android.support.v7.app.ActionBarDrawerToggle(this.getActivity(),
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(mUserLearnedDrawer){
                    mUserLearnedDrawer=true;
                    saveToPreferences(getContext(),KEY_USER_LEARNED,mUserLearnedDrawer+"");
                }

                getActivity().invalidateOptionsMenu();
            }
        };

        /*if(!mUserLearnedDrawer && !mFromsavedInstanceState){
            this.mDrawerLayout.openDrawer(this.containerView);
        }*/

        this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
        this.mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        }



        public List<MenuListElement> getMenuItems(){
            ArrayList<MenuListElement> list=new ArrayList<>();
            int [] ids={R.drawable.posts,R.drawable.events,R.drawable.map,R.drawable.options};
            String [] tab={"Posts","Events","Map","Options"};
            for(int i=0;i<4;i++)
                list.add(new MenuListElement(ids[i],tab[i]));
            return list;
        }


        public void saveToPreferences(Context context,String preferenceName,String preferenceValue){
            SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE);
            SharedPreferences.Editor   editor=sharedPreferences.edit();
            editor.putString(preferenceName,preferenceValue);
            editor.apply();
        }

        public static String readFromPreferences(Context context,String preferenceName,String dafaultValue){
            SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(preferenceName,dafaultValue);
        }




    }

