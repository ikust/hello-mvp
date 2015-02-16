package co.infinum.androidmvp.test;

import com.squareup.okhttp.mockwebserver.MockResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import co.infinum.androidmvp.R;
import co.infinum.androidmvp.TestMvpApplication;
import co.infinum.androidmvp.activities.GridMainActivity;

import static co.infinum.androidmvp.test.ResourceUtils.readFromFile;
import static org.assertj.android.api.Assertions.assertThat;

/**
 * Created by ivan on 16/02/15.
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class GridMainActivityTest {

    @Before
    public void setUp() {
        //Runs before each test.
    }

    @Test
    public void testNoData() {
        ActivityController<GridMainActivity> accountsActivityActivityController = Robolectric.buildActivity(GridMainActivity.class);
        GridMainActivity gridActivity = accountsActivityActivityController.get();

        TestMvpApplication.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(readFromFile("empty_list.json"))
        );

        accountsActivityActivityController
                .create()
                .start()
                .resume();

//        try {
//            RecordedRequest request = TestMvpApplication.takeRequest();
//        } catch (InterruptedException e) {
//            throw new IllegalStateException(e);
//        }

        assertThat(gridActivity.findViewById(R.id.progressBar)).isGone();
    }

    @Test
    public void testError() {
        ActivityController<GridMainActivity> accountsActivityActivityController = Robolectric.buildActivity(GridMainActivity.class);
        GridMainActivity gridActivity = accountsActivityActivityController.get();

        TestMvpApplication.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(readFromFile("invalid.json"))
        );

        accountsActivityActivityController
                .create()
                .start()
                .resume();

//        try {
//            RecordedRequest request = TestMvpApplication.takeRequest();
//        } catch (InterruptedException e) {
//            throw new IllegalStateException(e);
//        }

        assertThat(gridActivity.findViewById(R.id.progressBar)).isGone();
    }

    @Test
    public void testWithData() {

    }

    @After
    public void tearDown() {
        TestMvpApplication.shutdown();
    }
}
