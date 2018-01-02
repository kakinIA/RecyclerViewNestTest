package com.example.cx.ganktest;

import android.app.Application;

/**
 * Created by cx on 2017/12/26.
 */

public class App extends Application {
    private static App INSTANCE;

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
