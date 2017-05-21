package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.santhosh.builditbigger.backend.jokeApi.JokeApi;
import com.santhosh.jokeactivity.JokeActivity;

import java.io.IOException;

/**
 * Created by santhosh-3366 on 21/05/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {


    private JokeApi jokeApi = null;
    private Context context;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(jokeApi == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    //.setRootUrl("http://127.0.0.1:8080/_ah/api/")
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            jokeApi = builder.build();
        }

        try {
            return jokeApi.putJoke(" ").execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.e("post","execute");
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra("joke",result);
        context.startActivity(intent);
    }
}
