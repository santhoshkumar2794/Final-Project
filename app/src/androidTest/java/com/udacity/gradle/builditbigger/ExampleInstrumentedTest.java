package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void checkNonStringNull() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(appContext);
        endpointsAsyncTask.execute();
        String result = null;
        try {
            result = endpointsAsyncTask.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
