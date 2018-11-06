package com.example.hp.project;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by VARAD on 17-03-2018.
 */

public class FireApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);


    }

}
