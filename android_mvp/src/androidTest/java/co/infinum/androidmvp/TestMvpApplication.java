package co.infinum.androidmvp;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.robolectric.Robolectric;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import co.infinum.androidmvp.retrofit.ApiInterface;
import retrofit.RestAdapter;

/**
 * Created by ivan on 16/02/15.
 */
public class TestMvpApplication extends MvpApplication {

    class SynchronousExecutor implements Executor {
        @Override public void execute(Runnable command) {
            command.run();
        }
    }

    private static MockWebServer mockWebServer;

    @Override
    public void onCreate() {
        super.onCreate();

        Robolectric.getFakeHttpLayer().interceptHttpRequests(false);
        Robolectric.getFakeHttpLayer().interceptResponseContent(false);

        mockWebServer = new MockWebServer();

        try {
            mockWebServer.play();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to start mock Host");
        }
    }

    @Override
    public ApiInterface getRestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(mockWebServer.getUrl("/").toString())
                .setExecutors(new SynchronousExecutor(), new SynchronousExecutor())
                .build();

        return restAdapter.create(ApiInterface.class);
    }

    public static void enqueue(MockResponse mockResponse) {
        mockWebServer.enqueue(mockResponse);
    }

    public static RecordedRequest takeRequest() throws InterruptedException {
        return mockWebServer.takeRequest();
    }

    public static RecordedRequest takeRequest(int timeoutInMillis) throws InterruptedException {
        return mockWebServer.takeRequest(timeoutInMillis, TimeUnit.MILLISECONDS);
    }

    public static void shutdown() {
        try {
            mockWebServer.shutdown();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to stop mock Host");
        }
    }
}
