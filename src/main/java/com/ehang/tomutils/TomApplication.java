package com.ehang.tomutils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * 通用的Application,包含以下功能
 * <p>1.管理、获取当前处于顶层的Activity
 * <p>
 * Created by tom on 2018/3/29.
 */

public class TomApplication extends Application {
    private Activity topActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        registerTopActivityChangedListener();
    }

    public Activity getTopActivity() {
        return topActivity;
    }

    private void registerTopActivityChangedListener() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                topActivity = activity;
            }

            @Override
            public void onActivityPaused(Activity activity) {
                if (topActivity == activity) {
                    topActivity = null;
                }
            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

}
