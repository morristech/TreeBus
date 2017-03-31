package me.dmdev.treebus.demo;

import android.app.Application;

import me.dmdev.treebus.BuildConfig;
import timber.log.Timber;

/**
 * @author Dmitriy Gorbunov
 */

public class DemoApplication extends Application {

    private static DemoApplication INSTANCE;

    public static DemoApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initLogger();
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
