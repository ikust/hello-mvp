import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

import co.infinum.androidmvp.activities.ListMainActivity;

/**
* Created by Vito on 08/09/14.
*/
public class InitialJenkinsTestSetupTest extends ActivityInstrumentationTestCase2<ListMainActivity> {

    private Solo solo;

    public InitialJenkinsTestSetupTest() {
        super(ListMainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        solo = new Solo(getInstrumentation(), getActivity());

    }

    public void testListAppears(){
        solo.waitForActivity(ListMainActivity.class);

        solo.waitForText("bulbasaur");

        boolean hasScrolled = solo.scrollDown();

        Assert.assertTrue(hasScrolled);//glupi neki assert tek tako
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}