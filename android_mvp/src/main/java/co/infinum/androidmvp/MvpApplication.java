package co.infinum.androidmvp;

import android.app.Application;

/**
 * Custom implementation that exposes MyApplication
 * instance across the application.
 */
public class MvpApplication extends Application {

    private static MvpApplication instance;

    @Override public void onCreate() {
        super.onCreate();
        instance = this; //Stores the only instance of application.
    }

    public static MvpApplication getInstance() {
        return instance;
    }
}
