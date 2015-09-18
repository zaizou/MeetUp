package com.example.yazid.meetup.applications;

import android.app.Application;
import android.content.Context;

/**
 * Created by Yazid on 18/09/2015.
 */
public class MeetApplication extends Application {
    private static MeetApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }

    public static MeetApplication getInstance(){
        return application;
    }

    public static Context getContext(){
        return application.getApplicationContext();
    }


}
