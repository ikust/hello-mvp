package co.infinum.androidmvp;

import android.app.Application;

import co.infinum.androidmvp.retrofit.ApiInterface;
import retrofit.RestAdapter;

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

    public ApiInterface getRestClient() {
        String endpoint = MvpApplication.getInstance().getString(R.string.api_server);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .build();

        return restAdapter.create(ApiInterface.class);
    }
}
